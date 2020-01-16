package sapo.ex.ex5_framwork.erroe;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;


public class ErrorMessgae {

    private HttpStatus message;
    private String name;
    private Date date=new Date();

    public ErrorMessgae(HttpStatus message, String name) {
        this.message = message;
        this.name = name;
    }
}
