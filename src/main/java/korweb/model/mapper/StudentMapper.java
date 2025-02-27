package korweb.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper // 스프링 컨테이너에 빈 등록 , mybatis 와 연동되는 인터페이스 이면서 SQL 매핑 담당
public interface StudentMapper {

    // [1] 학생 점수 등록(추상)
    @Insert(" insert into student( name , kor , math ) values( #{name}, #{kor}, #{math} )")
    @Options( useGeneratedKeys = true , keyProperty = "sno")
    // useGeneratedKeys : auto_increment로 생성된 pk번호 를 반환 하겠다는 뜻한다.
    // keyProperty : pk번호를 가지는 pk필드(속성)명 뜻한다.
    // --> insert 성공한 자동으로 생성된 pk번호를 매개변수에 저장한다.
    int save(Map<String,Object> map );

    // [2] 학생 전체 조회(추상)
    @Select(" select * from student")
    List<Map<String,Object>> findAll();

}
