package sapo.ex.ex5_framwork.annotation;

import sapo.ex.ex5_framwork.dto.ProductDto;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/// can phai nang cap ban nay cho hop ly hon
public class CheckType<T>  {
    public List<String> list = new ArrayList<>();

    public boolean check(Map<String, ?> map, Class aClass) {
        Field[] fields = aClass.getDeclaredFields();
        Set<String> set = map.keySet();
        for (String key : set) {
            for (Field field : fields) {
                if (key.equalsIgnoreCase(field.getName())) {
                    if ((map.get(key) instanceof String) && (field.getType().isAssignableFrom(String.class))) {
                        System.out.println("sậiasjiasjdisad");
                        System.out.println(field.getName());
                    }
                    else if ((map.get(key) instanceof Integer) && (field.getType().isAssignableFrom(int.class))) {
                        System.out.println("dm đây là số");
                        System.out.println(field.getName());
                    } else  {
                        list.add("lỗi kiểu dữ liệu ở trường" + key );
                    }
                }
            }
        }


        return true;
    }

    public void tea(T t){
        ValidatorFactory validatorFactory= Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();
        ProductDto productDto=new ProductDto();
        productDto.setIdCategory(1);
        productDto.setNameprouct("ádasad");
        productDto.setProductprice(2);
        Set<ConstraintViolation<T>> set=validator.validate(t);
        for (ConstraintViolation<T> violation : set) {
           System.out.println(violation.getMessage());
        }
    }
    public String list(){
        StringBuffer buffer=new StringBuffer();
        for (String s:list){
            buffer.append(s);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
