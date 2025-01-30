package korweb.controller;

import korweb.model.dto.MemberDto;
import korweb.model.dto.PointDto;
import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    // 1. 회원가입 HTTP 매핑
    @PostMapping("/member/signup.do")
    public boolean signup(  MemberDto memberDto ){
        System.out.println("memberDto = " + memberDto);
        return memberService.signup( memberDto );
    } // f end

    // 2. 로그인 HTTP 매핑
    @PostMapping("/member/login.do")
    public boolean login( @RequestBody MemberDto memberDto ){
        return memberService.login( memberDto );
    } // f end

    // 3. 현재 로그인된 회원 아이디 http 매핑
    @GetMapping("/member/login/id.do")
    public String loginId( ){
        return memberService.getSession();
    } // f end

    // 4. 현재 로그인된 회원 로그아웃
    @GetMapping("/member/logout.do")
    public boolean logout(){
        return memberService.deleteSession();
    }

    // [6] 내정보 조회
    @GetMapping("/member/myinfo.do")
    public MemberDto myInfo(){
        return memberService.getMyInfo();
    }

    // [7] 회원탈퇴
    @DeleteMapping("/member/delete.do")
    public boolean myDelete(){
        return memberService.myDelete();
    }

    // [8] 회원정보 수정
    @PutMapping("/member/update.do")
    public boolean myUpdate( @RequestBody MemberDto memberDto ){
        return memberService.myUpdate( memberDto );
    }

    // [10] 내 포인트 지급 전제 내역 조회
    @GetMapping("/member/point/list.do")
    public List<PointDto> pointList(){
        return memberService.pointList();
    }
    // [11] 현재 내 포인트 조회
    @GetMapping("/member/point/info.do")
    public int pointInfo(){
        return memberService.pointInfo();
    }

} // class end

















