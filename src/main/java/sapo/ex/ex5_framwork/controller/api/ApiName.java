package sapo.ex.ex5_framwork.controller.api;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sapo.ex.ex5_framwork.annotation.CheckType;
import sapo.ex.ex5_framwork.erroe.ApiExceptionHandler;
import sapo.ex.ex5_framwork.model.NameEntity;
import sapo.ex.ex5_framwork.service.NameService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8291" })


public class ApiName {
    @Autowired
    private NameService nameService;
    int i = 0;

    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<?> getAllPage() {
        Pageable pageable = PageRequest.of(i, 3);
        Page<NameEntity> page = nameService.entities(pageable);

        if (page.getSize() > 0) {
            System.out.println("looooix");
            // throw new ArithmeticException("fvgb");
            return new ResponseEntity<>(page.iterator(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiExceptionHandler().toString(), HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("/name")
    private ResponseEntity<?> test(@Valid @RequestBody Map<String,?> entity) throws InvalidFormatException {
//       List<String> list=new ArrayList<>();
//        if(errors.hasErrors()){
//           String cc= errors.getAllErrors().get(0).getDefaultMessage();
//           System.out.println(cc);
//        }
        CheckType checkType = new CheckType();

      if(  checkType.check(entity, NameEntity.class)){
        System.out.println(checkType.list);
        //throw new ArithmeticException(checkType.list());
          return new ResponseEntity<>(checkType.list,HttpStatus.OK);
      }
//        NameEntity s = new NameEntity();
//
//        DataBinder binder = new DataBinder(s);
//        binder.bind(new MutablePropertyValues(entity));
//        Validator validator = new LocalValidatorFactoryBean();
//        binder.setValidator(validator);
//        binder.validate();
//        binder.getValidators();



//        if (errors.hasErrors()){
//            List<ObjectError>  errors1=errors.getAllErrors();
//            for (ObjectError error: errors1){
//                System.out.println(error.getDefaultMessage());
//            }
//            return new ResponseEntity<>()
//        }

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
