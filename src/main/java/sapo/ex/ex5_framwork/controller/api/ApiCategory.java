package sapo.ex.ex5_framwork.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sapo.ex.ex5_framwork.dto.CategoryDto;
import sapo.ex.ex5_framwork.model.CategoryEntity;
import sapo.ex.ex5_framwork.service.ipl.CategoryServiceIml;
import sapo.ex.ex5_framwork.service.ipl.ProductServiceIml;

import java.util.List;

@RestController
@RequestMapping(name = "")
@CrossOrigin(origins = { "*" })

public class ApiCategory {
    @Autowired
    private CategoryServiceIml categoryServiceIml;
    @Autowired
    private ProductServiceIml productServiceIml;
    @RequestMapping(value = "/test")
    public ResponseEntity<String> entity(){
        return new ResponseEntity<>("saaaaaaaa", HttpStatus.OK);
    }
    @Transactional
    @RequestMapping(value = "/admin/category/delete/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<?> delete(@PathVariable int id){
        int integer=id;
        productServiceIml.deleteByIdCategory(integer);
        categoryServiceIml.delete(integer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/categorys",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(){
        List<CategoryEntity> list=categoryServiceIml.getAll();
      return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
