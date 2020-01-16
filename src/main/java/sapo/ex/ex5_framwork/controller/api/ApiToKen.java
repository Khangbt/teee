package sapo.ex.ex5_framwork.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sapo.ex.ex5_framwork.config.jwt.JwtTokenUnit;

import java.util.Map;
import java.util.Set;

@Controller
@CrossOrigin(origins = { "*" })

public class ApiToKen {
    @Autowired
private AuthenticationManager authenticationManager;
    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody Map<String,String> map){
   //     Set<String> set=map.keySet();
        System.out.println(map.toString());
        String name=map.get("name");
        String pass=map.get("pass");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        name, pass
                )
        );
        // SecurityContextHolder.getContext().setAuthentication(authentication);
        //   final TestEntity entity1=userSevice.findByName(entity.getTen()).get(0);


        return new ResponseEntity<>(new JwtTokenUnit().generateToKen(authentication), HttpStatus.OK);
    }

}
