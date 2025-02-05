package korweb.service;

import korweb.model.dto.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BoardService {
    // [1] 게시물 쓰기
    public boolean boardWrite( BoardDto boardDto ){
        // 코드 구현하기 전
        return false; // 임시용.
    }
    // [2] 게시물 전체 조회
    public List<BoardDto> boardFindAll( ){
        // 코드 구현하기 전
        return null; // 임시용.
    }
    // [3] 게시물 특정(개별) 조회
    public BoardDto boardFind( int bno ){
        // 코드 구현하기 전
        return null; // 임시용.
    }
    // [4] 게시물 특정(개별) 수정
    public boolean boardUpdate( BoardDto boardDto ){
        // 코드 구현하기 전
        return false; // 임시용.
    }
    // [5] 게시물 특정(개별) 삭제
    public boolean boardDelete( int bno ){
        // 코드 구현하기 전
        return false; // 임시용.
    }


}
