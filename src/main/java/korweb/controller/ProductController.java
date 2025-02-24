package korweb.controller;

import korweb.model.dto.ProductDto;
import korweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    // [1] 제품 등록
    @PostMapping("/product/save.do")
    // [POST] http://localhost:8080/product/save.do
    // [BODY] {  "name" : "콜라" , "price" : "1200" }
    public int save(@RequestBody ProductDto productDto ){
        return productService.save( productDto );
    } // f end

    // [2] 제품 전체 조회
    @GetMapping("/product/findall.do")
    // http://localhost:8080/product/findall.do
    public List<ProductDto> findAll(){
        return productService.findAll();
    }
    // [3] 제품 개별 조회
    @GetMapping("/product/find.do")
    // http://localhost:8080/product/find.do?id=1
    public ProductDto find(@RequestParam int id ){
        return productService.find( id );
    }

} // c end












