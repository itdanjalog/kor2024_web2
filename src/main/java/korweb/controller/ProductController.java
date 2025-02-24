package korweb.controller;

import korweb.model.dto.ProductDto;
import korweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/product/save.do")
    // [POST] http://localhost:8080/product/save.do
    // [BODY] {  "name" : "콜라" , "price" : "1200" }
    public int save(@RequestBody ProductDto productDto ){
        return productService.save( productDto );
    }
}
