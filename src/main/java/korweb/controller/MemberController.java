package korweb.controller;

import korweb.model.dto.MemberDto;
import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired private MemberService memberService;

    // 1. 회원가입 HTTP 매핑
    @PostMapping("/member/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto ){
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

} // class end

















