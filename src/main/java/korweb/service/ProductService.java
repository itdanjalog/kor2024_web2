package korweb.service;

import korweb.model.dto.ProductDto;
import korweb.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public int save(ProductDto productDto){
        return productMapper.save( productDto );
    }
}







