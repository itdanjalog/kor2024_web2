package korweb.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import korweb.model.dto.MemberDto;
import korweb.model.entity.MemberEntity;
import korweb.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberRepository memberRepository;

    // 1. 회원가입 서비스
    @Transactional // 트랜잭션
    public boolean signup( MemberDto memberDto ){
        // 1.  저장할 dto를 entity 로 변환한다.
        MemberEntity memberEntity = memberDto.toEntity();
        // 2. 변환된 entity를 save한다.
        // 3. save(영속성/연결된) 한 엔티티를 반환 받는다.
        MemberEntity saveEntity = memberRepository.save( memberEntity );
        // 4. 만약에 영속된 엔티티의 회원번호가 0보다 크면 회원가입 성공
        if( saveEntity.getMno() > 0 ){ return true; }
        else{ return  false;}
    } // f end

    // 2. 로그인 서비스
    @Transactional // 트랜잭션
    public boolean login( MemberDto memberDto ){
        //[방법1]
        /*
        // (1) 모든 회원 엔티티를 조회한다.
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        // (2) 모든 회원 엔티티를 하나씩 조회한다.
        for( int index = 0 ; index <= memberEntityList.size()-1 ; index++ ){
            // (3) index번째의 엔티티를 꺼내기
            MemberEntity memberEntity = memberEntityList.get(index);
            // (4) index번째의 엔티티 아이디가 입력받은(dto) 아이디와 같으면
            if( memberEntity.getMid().equals( memberDto.getMid() ) ) {
                // (5) index번째의 엔티티 비밀번호가 입력받은(dto)비밀번호와 같으면
                if( memberEntity.getMpwd().equals( memberDto.getMpwd() ) ){
                    System.out.println(" login OK ");
                    return true; // 로그인 성공
                } // if end
            } // if end
        } // for end
        return false; // 로그인 실패
        */

        // [방법2] JPA Repository 추상메소드 활용.
        boolean result
        = memberRepository.existsByMidAndMpwd( memberDto.getMid() , memberDto.getMpwd() );

        if( result == true ){
            System.out.println("로그인성공");
            setSession(memberDto.getMid()) ;
            return true; // 로그인 실패
        }else{
            System.out.println("로그인실패");
            return false; // 로그인 실패
        }

    } // f end

    // * 로그인 했다는 증거/기록
    @Autowired private HttpServletRequest request;

    // 2. 세션 저장 : 로그인
    @Transactional
    public boolean setSession( String mid ){
        request.getSession().setAttribute("loginInfo" , mid ); // *회원번호( 1 ) , 시큐리티 ( 권한 )
        return true;
    } // f end

    // 3. 세션 삭제 : 로그아웃
    @Transactional
    public boolean deleteSession( ){
        request.getSession().setAttribute("loginInfo" , null );
        return true;
    }

    // 4. 세션 정보 반환 : 세션 정보 확인
    @Transactional
    public String  getSession(){
        Object object = request.getSession().getAttribute("loginInfo");
        if( object != null ){
            return (String)object; // 강제형변환
        }
        return null;
    }
    // 3. 아이디로 내 정보 조회
    @Transactional
    public MemberDto getMyInfo( ){
        String mid = getSession();
        if( mid!= null ){
            // 1. id로 entity를 ��아��다.
            MemberEntity memberEntity = memberRepository.findByMid( mid );
            if( memberEntity!= null ){
                // 2. entity -> dto 로 변환
                MemberDto memberDto = memberEntity.toDto();
                // 3. dto -> view 에서 ��� object 로 변환
                return memberDto; // 로그인 성공
            }
        }
        return null; // 로그인 실��
    }

    // 4. 회원 탈퇴
    @Transactional
    public boolean myDelete(){
        String mid = getSession();
        if( mid!= null ){
            // 1. id 로 entity를 ��아서 ��제
            MemberEntity memberEntity = memberRepository.findByMid( mid );
            if( memberEntity!= null ){
                // 3. dto -> view 에서 object 로 변환
                memberRepository.delete( memberEntity ); // delete
                deleteSession();
                return true; // ���원 ����� 성공
            }
        }
        return false; // ���원 ����� 실��
    }
    // 5. 회원 정보 수정
    @Transactional
    public boolean myUpdate( MemberDto memberDto ){
        String mid = getSession();
        if( mid!= null ){
            // 1. id 로 entity를 ��아서 ���
            MemberEntity memberEntity = memberRepository.findByMid( mid );
            if( memberEntity!= null ){
                // 2. dto -> entity 로 변환
                memberEntity.setMname( memberDto.getMname() );
                memberEntity.setMemail( memberDto.getMemail() );
                return true;
            }
        }
        return false;
    }
} // class end



















