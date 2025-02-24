package korweb.model.mapper;

import korweb.model.dto.ProductDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper // [2] 해당 인터페이스가 myBatis mapper 임을 명시
public interface ProductMapper { // [1] 인터페이스타입 선언
    // 추상메소드
    // [3] @SQL어노테이션(" SQL 작성 ")
    // [4] SQL 에서 매개변수 표현 : #{ 매개변수 }
    @Insert(" insert into products(name, price) " +
            "values( #{ name } , #{ price } )")
    int save(ProductDto productDto);

}







