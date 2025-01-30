package korweb.controller;

import korweb.model.dto.MemberDto;
import korweb.model.dto.PointDto;
import korweb.service.FileService;
import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FileController {

    @Autowired private FileService fileService;

    // 1. 회원가입 HTTP 매핑
    @GetMapping("/file/download.do")
    public void signup(  @RequestParam String file ){
         fileService.fileDownload( file );
    } // f end

} // class end

















