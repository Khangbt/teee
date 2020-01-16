package sapo.ex.ex5_framwork.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class AuthorValidator implements ConstraintValidator<Test, Integer> {


    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value <=0){
            return false;
        }
        return true;

    }
}