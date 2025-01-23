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
    }

    @GetMapping("/member/loginInfo.do")
    public String getSession(){
        return memberService.getSession();
    }

    @GetMapping("/member/logout.do")
    public boolean deleteSession(){
        return memberService.deleteSession();
    }

    @PostMapping("/member/info.do")
    public MemberDto getMyInfo(){
        return memberService.getMyInfo();
    }

    @PostMapping("/member/update.do")
    public boolean update( @RequestBody MemberDto memberDto ){
        return memberService.myUpdate( memberDto );
    }

    @GetMapping("/member/delete.do")
    public boolean delete(){
        return memberService.myDelete();
    } // f end


} // class end

















