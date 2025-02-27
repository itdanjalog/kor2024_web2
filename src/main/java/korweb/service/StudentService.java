package korweb.service;

import korweb.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service // 스프링 컨테이너에 빈(인스턴스) 등록 , springMVC 에서 비지니스 로직 담당
// 비지니스로직 : 어떠한 기능 핵심이 되는 코드 , 예] 회원가입 에서 '저장'로직
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // [1] 학생 점수 등록
    public int save(Map<String , Object> map ){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        //return 1;
        return studentMapper.save( map );
    }
    // [2] 학생 전체 조회
    public List< Map<String,Object> > findAll(){
        System.out.println("StudentService.findAll");
        // return null;
        return studentMapper.findAll();
    }

}
