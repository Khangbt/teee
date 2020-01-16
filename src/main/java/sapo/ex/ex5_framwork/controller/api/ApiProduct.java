package sapo.ex.ex5_framwork.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sapo.ex.ex5_framwork.converter.ProductConverter;
import sapo.ex.ex5_framwork.dto.ProductDto;
import sapo.ex.ex5_framwork.model.ProductEntity;
import sapo.ex.ex5_framwork.service.ipl.ProductServiceIml;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = { "*" })


public class ApiProduct {
    @Autowired
    private ProductServiceIml productServiceIml;
    int i = 0;
    private ProductConverter productConverter=new ProductConverter();
    @RequestMapping(value = "/admin/products/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> entity(@PathVariable int id) {
        Optional<ProductEntity> entity = productServiceIml.getId(id);
        if (!entity.isPresent()) {

            return new ResponseEntity<>("lôi ko co id rồi", HttpStatus.BAD_GATEWAY);
        }
        ProductDto productDto=productConverter.converDto(entity.get());

        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@RequestParam(required = false,defaultValue = "0") @Null Integer page,
                                    @RequestParam(required = false,defaultValue = "5") @Null Integer size) {
        System.out.println(page + "=======" + size);
        Pageable pageable;
        if (size == 0) {
            pageable = PageRequest.of(page, 5);
        } else {
            pageable = PageRequest.of(page, size);
        }
        Page<ProductEntity> list = productServiceIml.getAllpage(pageable);
        if (list.getSize() == 0) {
            return new ResponseEntity<>("khong co gia tri", HttpStatus.BAD_GATEWAY);
        }
        i++;

        return new ResponseEntity<>(list.iterator(), HttpStatus.OK);
    }

    /// chưa sửa
    @RequestMapping(value = "/admin/products/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody ProductDto entity, @PathVariable int id) {
        Optional<ProductEntity> optional = productServiceIml.getId(id);
        if (!optional.isPresent()) {
            System.out.println("dddddđ");
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        System.out.println(entity.getProductimagePath()+"*************");
        optional.get().setNameprouct(entity.getNameprouct());
        optional.get().setProductdescription(entity.getProductdescription());
        optional.get().setProductimagepath(entity.getProductimagePath());
        optional.get().setSellnumber(entity.getSellnumber());
        optional.get().setProductprice(entity.getProductprice());
        optional.get().setNumberproducts(entity.getNumberproducts());
      //  optional.get().setIdcategory(entity.getIdCategory());
        System.err.println(entity.getIdCategory());
        productServiceIml.save(optional.get());
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/products", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> creat(@Valid @RequestBody ProductDto entity) {
        ProductEntity productEntity=productConverter.converEntty(entity);

        productServiceIml.save(productEntity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }


    @RequestMapping(value = "/admin/productId", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIdCategory(@RequestParam Integer cate,
                                           @RequestParam(required = false,defaultValue = "0") @Null Integer page,
                                           @RequestParam(required = false,defaultValue = "1") @Null Integer size ){
        Pageable pageable=PageRequest.of(page,size);
        Page<ProductEntity> list=  productServiceIml.getByIdCategory(cate,pageable);
        if(list.getSize()==0){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        int i=productServiceIml.numberOfRow(cate);
        return new ResponseEntity<>(list.iterator(),HttpStatus.OK);
    }
    @RequestMapping(value = "/admin/productIdcount", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIdCategoryCount(@RequestParam Integer cate){

       int i=productServiceIml.numberOfRow(cate);
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

}
