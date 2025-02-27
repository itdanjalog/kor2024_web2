package korweb.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper // 스프링 컨테이너에 빈 등록 , mybatis 와 연동되는 인터페이스 이면서 SQL 매핑 담당
public interface StudentMapper {

    // [1] 학생 점수 등록(추상)
    @Insert(" insert into student( name , kor , math ) values( #{name}, #{kor}, #{math} )")
    int save(Map<String,Object> map );

    // [2] 학생 전체 조회(추상)
    @Select(" select * from student")
    List<Map<String,Object>> findAll();

}
