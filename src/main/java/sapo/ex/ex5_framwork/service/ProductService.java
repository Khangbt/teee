package sapo.ex.ex5_framwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sapo.ex.ex5_framwork.converter.ProductConverter;
import sapo.ex.ex5_framwork.model.ProductEntity;
import sapo.ex.ex5_framwork.repository.ProductRepository;
import sapo.ex.ex5_framwork.service.ipl.ProductServiceIml;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceIml {
    @Autowired
    private ProductRepository productRepository;

    private ProductConverter categoryConverter=new ProductConverter();
    public List<ProductEntity> getAll(){
        return (List<ProductEntity>) productRepository.findAll();
    }
    public int  save(ProductEntity productDto){
       // ProductEntity productEntity=categoryConverter.converEntty(productDto);
        productRepository.save(productDto);
        return 1;
    }

    @Override
    public boolean checkId(int id) {
        return productRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteByIdCategory(int id) {
        productRepository.deleteByIdcategory(id);
    }

    @Override
    public Page<ProductEntity> getByIdCategory(int id,Pageable pageable) {
        return productRepository.getByIdcatego(id, pageable);
    }

    @Override
    public int numberOfRow(int id) {
        return productRepository.getCountIdCategory(id);
    }


    public Optional<ProductEntity> getId(int i){
        return productRepository.findById(i);
    }
    public Page<ProductEntity> getAllpage(Pageable pageable){
        return productRepository.getAllPage(pageable);
    }
}
