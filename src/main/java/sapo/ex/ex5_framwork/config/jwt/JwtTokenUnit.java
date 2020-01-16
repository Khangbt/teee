package sapo.ex.ex5_framwork.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import sapo.ex.ex5_framwork.config.UserPrincipal;
import sapo.ex.ex5_framwork.model.JwtToken;

import java.io.Serializable;
import java.util.Date;
@Component
public class JwtTokenUnit implements Serializable {
    private String jwtSecret = "hello";
    private int jwtExpirationInMs = 3000000;

    public JwtToken generateToKen(Authentication authentication) {
        JwtToken jwtToken=new JwtToken();
        Date date = new Date();
        Date endDate = new Date(date.getTime() + jwtExpirationInMs);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
        claims.put("password", userPrincipal.getPassword());
        claims.put("role", userPrincipal.getAuthorities());

        String toKen= Jwts.builder().setClaims(claims).setIssuedAt(date).setExpiration(endDate).signWith(SignatureAlgorithm.HS256, "hello").compact();
        jwtToken.setToken(toKen);
        jwtToken.setQuyen(userPrincipal.getAuthorities().toString());
        return jwtToken;

    }
    public Claims validateToKen(String token) {

        Claims body = null;
        try {
            body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        } catch (Exception e) {


            return null;
        }

        return body;
    }


}
