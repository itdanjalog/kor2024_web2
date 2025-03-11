package korweb.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import korweb.model.dto.MemberDto;
import korweb.model.dto.PointDto;
import korweb.model.entity.MemberEntity;
import korweb.model.entity.PointEntity;
import korweb.model.repository.MemberRepository;
import korweb.model.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MemberService implements UserDetailsService , OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest = " + userRequest);

        // 1. 로그인을 성공한 oauth2 사용자정보(동의항목)의 정보 호출
        OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
        System.out.println("oAuth2User = " + oAuth2User);

        // 2. 인증결과( 카카오 , 네이버 , 구글 )
        // 2-1 인증한 소셜 서비스 아이디( 각 회사명 ) 찾기
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("registrationId = " + registrationId);
        String nickname = null;
        String image = null;

        // 2-2 카카오 이면
        if (registrationId.equals("kakao")) {
            Map<String, Object> kakao_account = (Map<String, Object>) oAuth2User.getAttributes().get("kakao_account");
            Map<String, Object> profile = (Map<String, Object>) kakao_account.get("profile");
            nickname = profile.get("nickname").toString();
            System.out.println("nickname = " + nickname);
            image = profile.get("profile_image_url").toString();
            System.out.println("image = " + image);

            if( memberRepository.findByMid(nickname) == null ){
                MemberEntity memberEntity = MemberEntity.builder()
                       .mid(nickname)
                       .mname(nickname)
                        .memail( nickname ) // 샘플
                        .mimg( image )
                        .mpwd( new BCryptPasswordEncoder().encode("1234")) // 샘플
                       .build();
                memberRepository.save(memberEntity);
            }
            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            return new DefaultOAuth2User(authorities, profile, "nickname");
        }
        return null;
    }




    // 2-2 DTO 만들기
//        MemberDto memberDto = MemberDto.builder()   // oauth2는 패스워드를 알수없다..
//                .memail( memail ).mname( mname ).build();
//        // 2-3 DB 처리
//        // 만약에 처음 접속한 OAUTH2 회원이면 권한을 추가하고 DB처리
//        if( memberRepository.findByMid( memail ) != null ){  // 해당 이메일이 db에 없으면
////            memberDto.setMrol("USER");
////            memberDto.setMpassword("1234"); // 필드가 not null 이기 때문에 임의 비밀번호 제공( 추후 일반 로그인시 유효성검사를 통해 막기 필요. 또는 비밀번호 페이지로 이동후 입력받은 페이지 필요.)
////            memberEntityRepository.save( memberDto.toEntity() );
//
//        }else{ //만약에 처음 접속이 아니면  기존 권한을 db에서 가져와서 넣어주기.
//            //memberDto.setMrol( memberEntityRepository.findByMemail( memail).getMrol() );
//        }

        // 2-1 권한 목록에 추가
//        List<GrantedAuthority> 권한목록 = new ArrayList<>();
//        권한목록.add(  new SimpleGrantedAuthority("ROLE_"+registrationId )  );
//        권한목록.add(  new SimpleGrantedAuthority("ROLE_TEAM1" )  );
//        권한목록.add(  new SimpleGrantedAuthority("ROLE_"+ memberDto.getMrol() )  );
//
//        // 3 : 일반회원(UserDetails) + OAUTH2(OAuth2User) 통합회원 = DTO 같이 쓰기
//        LoginDto loginDto = LoginDto.builder()   // oauth2는 패스워드를 알수없다..
//                .memail( memail ).mrolList( 권한목록 ).build();
//        return loginDto;




    @Autowired private MemberRepository memberRepository;

    @Autowired private FileService fileService; // 파일 서비스 객체

    // [1]. 회원가입 서비스
    @Transactional // 트랜잭션
    public boolean signup( MemberDto memberDto ){
        // day70 : - 프로필사진 첨부파일 존재하면 업로드 진행
            // (1) 만약에 업로드 파일이 비어 있으면 'default.jpg' 임시용 프로필 사진 등록한다.
        if( memberDto.getUploadfile().isEmpty() ){
            memberDto.setMimg( "default.jpg");
        }
        else { // (2) 아니고 업로드 파일이 존재하면 , 파일 서비스 객체내 업로드 함수를 호출한다.
            String fileName = fileService.fileUpload( memberDto.getUploadfile() ); // 업로드 함수에 multipart 객체를 대입해준다.
            // (3) 만약에 업로드 후 반환된 값이 null 이면 업로드 실패 , null 아니면 업로드 성공
            if( fileName == null ){ return false; } // 업로드 실패 했으면 회원가입 실패
            else{
                memberDto.setMimg( fileName ); // 업로드 성공한 uuid+파일명 을 dto에 대입한다.
            }
        }

        // 1.  저장할 dto를 entity 로 변환한다.
        MemberEntity memberEntity = memberDto.toEntity();
        // 2. 변환된 entity를 save한다.
        // 3. save(영속성/연결된) 한 엔티티를 반환 받는다.
        MemberEntity saveEntity = memberRepository.save( memberEntity );
        // 4. 만약에 영속된 엔티티의 회원번호가 0보다 크면 회원가입 성공
        if( saveEntity.getMno() > 0 ){
            // day69실습 : 포인트 지급
            PointDto pointDto = PointDto.builder()
                    .pcontent("회원가입축하")
                    .pcount( 100 )
                    .build();
            pointPayment( pointDto , memberEntity );
            return true;
        }
        else{ return  false;}
    } // f end

    // [2]. 로그인 서비스 // 시큐리티 이후에 사용하지 않는다.
//    @Transactional // 트랜잭션
//    public boolean login( MemberDto memberDto ){
//        //[방법1]
//        /*
//        // (1) 모든 회원 엔티티를 조회한다.
//        List<MemberEntity> memberEntityList = memberRepository.findAll();
//        // (2) 모든 회원 엔티티를 하나씩 조회한다.
//        for( int index = 0 ; index <= memberEntityList.size()-1 ; index++ ){
//            // (3) index번째의 엔티티를 꺼내기
//            MemberEntity memberEntity = memberEntityList.get(index);
//            // (4) index번째의 엔티티 아이디가 입력받은(dto) 아이디와 같으면
//            if( memberEntity.getMid().equals( memberDto.getMid() ) ) {
//                // (5) index번째의 엔티티 비밀번호가 입력받은(dto)비밀번호와 같으면
//                if( memberEntity.getMpwd().equals( memberDto.getMpwd() ) ){
//                    System.out.println(" login OK ");
//                    return true; // 로그인 성공
//                } // if end
//            } // if end
//        } // for end
//        return false; // 로그인 실패
//        */
//        // [방법2] JPA Repository 추상메소드 활용.
//        boolean result
//        = memberRepository.existsByMidAndMpwd( memberDto.getMid() , memberDto.getMpwd() );
//
//        if( result == true ){
//            System.out.println("로그인성공");
//            setSession( memberDto.getMid() ); // 로그인 성공시 세션에 아이디 저장
//            //  포인트 DTO 생성
//            PointDto pointDto = PointDto.builder()
//                    .pcontent("로그인접속")
//                    .pcount( 1 ).build();
//            // - 현재 로그인된 엔티티 찾기  // .findById( pk번호 ) : 지정한 pk번호의 엔티티 조회
//            MemberEntity memberEntity = memberRepository.findById(  getMyInfo().getMno() ).get();
//            // 포인트 지급 함수
//            pointPayment( pointDto , memberEntity );
//
//            return true; // 로그인 성공
//        }else{
//            System.out.println("로그인실패");
//            return false; // 로그인 실패
//        }
//    } // f end

    // [ 2 ] : 시큐리티 에서의 로그인 함수
        // (1) 해당 서비스 클래스명 뒤에 implements UserDetailsService
        // (2) 'loadUserByUsername' 메소드를 오버라이딩/재정의 한다.
    @Override
    public UserDetails loadUserByUsername(String mid) throws UsernameNotFoundException {
        System.out.println("MemberService.loadUserByUsername");
        System.out.println("mid = " + mid); // 로그인시 입력받은 mid

        // (3) 입력받은 mid 이용하여 데이터베이스의 저장된 암호화패스워드를 가져오기.
        MemberEntity memberEntity = memberRepository.findByMid( mid ); // - 입력받은 아이디로 회원 엔티티 찾기
        if( memberEntity == null ){  // - 입력받은 아이디의 엔티티가 없으면
            throw new UsernameNotFoundException("없는 아이디 입니다.");
            // throw : 던지다 뜻 // new UsernameNotFoundException : 예외클래스 강제 실행
        }
        // - 입력받은 아이디의 엔티티가 존재하면 암호화된 패스워드 확인
        String password = memberEntity.getMpwd();
        System.out.println("password = " + password);

        // (4) 입력받은 mid 와 입력받은 mid의 암호화된 패스워드를 리턴. <UserDetails>
            // UserDetails : 인터페이스 , 시큐리티에서 사용하는 유저 정보를 조작하는 인터페이스
            // User : 클래스 , UserDetails 를 구현하는 구현(객)체
                // --> 시큐리티는 UserDetails 반환 하면 자동으로 로그인 처리를 해준다.
                // 단] 입력받은 id 와 입력받은 id의 암호화된password 대입 해줘야 한다.
        UserDetails user = User.builder()
                .username( mid )
                .password( password )
                .build();

        // (5) UserDetails 반환
        return user;
    }

    // ===================== 세션 관련 함수 ============== //
    // (1) 내장된 톰캣 서버의 요청 객체
    @Autowired private HttpServletRequest request;

    // [3] 세션객체내 정보 추가 : 세션객체에 로그인된 회원아이디를 추가하는 함수. ( 로그인 ) // 시큐리티 이후에는 사용하지 않는다. // 시큐리티 자동으로 세션 추가해준다.
//    public boolean setSession( String mid ){
//        // (2) 요청 객체를 이용한 톰캣내 세션 객체를 반환한다.
//        HttpSession httpSession = request.getSession();
//        // (3) 세션 객체에 속성(새로운 값) 추가한다.
//        httpSession.setAttribute( "loginId" , mid );
//        return true;
//    } // f end

    // [4] 세션객체내 정보 반환 : 세션객체에 로그인된 회원아이디 반환하는 함수 ( 내정보 조회 , 수정 등등 ) // 시큐리티 이후에 코드 수정.
    public String getSession( ){
        // (1) 시큐리티 에서 자동으로 생성한 (로그인) 세션 꺼내기 , 기존 세션 사용법과 다르다.
            // SecurityContextHolder : 시큐리티에 관련된 정보 저장소 // .getContext() : 저장소 반환
            // .getAuthentication() : 저장소에서 인증서 반환 // .getPrincipal(); : 중요한 인증 정보
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // (2) 만약에 비로그인[ anonymousUser ] 이면
        if( object.equals("anonymousUser") ){  return null; } // 비로그인 상태이면 null 반환
        // (3) 로그인 상태이면 로그인 구현할때 'loadUserByUsername' 메소드에서 반환한 userDetails 로 타입변환
        String loginMid = ""; // Username == mid
        if( object instanceof DefaultOAuth2User ){
            DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) object;
            loginMid = defaultOAuth2User.getAttributes().get("nickname").toString(); // Username == mid
        }else if( object instanceof UserDetails ){
            UserDetails userDetails = (UserDetails) object;
            loginMid = userDetails.getUsername(); // Username == mid
        }
        // (4) 로그인된 정보에서 mid 꺼낸다.

        // (5) 로그인된 mid를 반환한다.
        return loginMid;
    }

//    public String getSession( ){
//        // (2)
//        HttpSession httpSession = request.getSession();
//        // (4) 세션 객체에 속성명의 값 반환한다. * 반환타입이 Object 이다.
//        Object object = httpSession.getAttribute( "loginId");
//        // (5) 검사후 타입변환
//        if( object != null ){// 만약에 세션 정보가 존재하면
//            String mid = (String)object; // Object타입 --> String타입
//            return mid;
//        }
//        return null;
//    } // f end

    // [5] 세션객체내 정보 초기화 : 로그아웃
    public boolean deleteSession(){
        HttpSession httpSession = request.getSession();
        // (3) 세션객체 안에 특정한 속성명 제거
        httpSession.removeAttribute( "loginId");
        return true;
    }

    // [6] 현재 로그인된 회원의 회원정보 조회
    public MemberDto getMyInfo(){
        String mid = getSession();  // 1. 현재 세션에 저장된 회원 아이디 조회
        if( mid != null ){   // 2. 만약에 로그인상태이면
            MemberEntity memberEntity = memberRepository.findByMid( mid );  // 3. 회원아이디로 엔티티 조회
            MemberDto memberDto = memberEntity.toDto(); // 4. entity --> dto 변환
            return memberDto;// 5. 반환
        }
        return null; // * 비로그인상태이면
    } // f end

    // [7] 현재 로그인된 회원 탈퇴
    public boolean myDelete( ){
        String mid = getSession(); // 1. 현재 세션에 저장된 회원 아이디 조회
        if( mid != null ){// 2. 만약에 로그인상태이면
            MemberEntity memberEntity = memberRepository.findByMid( mid ); // 3. 현재 로그인된 아이디로 엔티티 조회


            // 외래 키로 참조하고 있는 엔티티의 관계를 끊음
            List<PointEntity> relatedEntities = pointRepository.findByMemberEntity(memberEntity);
            for (PointEntity relatedEntity : relatedEntities) {
                relatedEntity.setMemberEntity(null);
            }

            memberRepository.delete( memberEntity ); // 4. 엔티티 탈퇴/삭제 하기
            deleteSession();// ** 로그인정보 지우기 : 로그아웃
            return true;// 5. 반환
        }
        return false; // * 비로그인상태이면
    } // f end

    // [8] 현재 로그인된 회원 정보 수정 , mname 닉네임 , memail 이메일
    @Transactional
    public boolean myUpdate( MemberDto memberDto ){
        String mid = getSession();
        if( mid != null ){
            MemberEntity memberEntity = memberRepository.findByMid( mid );
            memberEntity.setMname( memberDto.getMname() );
            memberEntity.setMemail( memberDto.getMemail() );
            return true;
        }
        return false;
    } // f end

    @Autowired private PointRepository pointRepository;

    // [9] (부가서비스) 포인트 지급 함수 . 지급내용 pcontent / 지급수량 pcount , 지급받는회원엔티티
    @Transactional
    public boolean pointPayment( PointDto pointDto , MemberEntity memberEntity ){

        PointEntity pointEntity = pointDto.toEntity();
        pointEntity.setMemberEntity( memberEntity ); // 지급받는 회원엔티티 대입

        PointEntity saveEntity = pointRepository.save( pointEntity  );
        if( saveEntity.getPno() > 0 ){return true; }
        else{ return false; }
    } // f end

    // [10] 내 포인트 지급 전제 내역 조회
    public List<PointDto> pointList(){
        // 1. (로그인된) 내정보 가져오기
        String mid = getSession();
        MemberEntity memberEntity = memberRepository.findByMid( mid );
        // 2. 내 포인트 조회하기
        List<PointEntity> pointEntityList = pointRepository.findByMemberEntity( memberEntity );
        // 3. 조회된 포인트 엔티티를 dto로 변환
        List<PointDto> pointDtoList = new ArrayList<>();
        pointEntityList.forEach( (entity) ->{
            pointDtoList.add( entity.toDto() );
        });
        return  pointDtoList;
    }

    // [11] 현재 내 포인트 조회
    public int pointInfo(){
        // 1. (로그인된) 내정보 가져오기
        String mid = getSession();
        MemberEntity memberEntity = memberRepository.findByMid( mid );
        // 2. 내 포인트 조회하기
        List<PointEntity> pointEntityList = pointRepository.findByMemberEntity( memberEntity );
        // 3. 조회된 포인트 엔티티의 합계 구하기.
        int myPoint = 0;
        for( int index = 0 ; index<=pointEntityList.size()-1 ; index++ ){
            myPoint += pointEntityList.get(index).getPcount();
        }
        return  myPoint;
    }



} // class end



















