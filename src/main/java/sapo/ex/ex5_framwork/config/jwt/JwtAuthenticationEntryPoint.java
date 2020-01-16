package sapo.ex.ex5_framwork.config.jwt;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        System.out.println(httpServletRequest.getMethod());
//         if(httpServletRequest.getMethod().equals("GET")){
//             httpServletResponse.setStatus(200);
//
//         }else
         {
             httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, e.getLocalizedMessage() + " :bạn không có quyền nhé");
         }
    }
}
