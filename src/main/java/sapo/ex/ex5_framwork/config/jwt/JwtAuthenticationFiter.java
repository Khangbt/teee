package sapo.ex.ex5_framwork.config.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import sapo.ex.ex5_framwork.config.MyUserDetailsService;
import sapo.ex.ex5_framwork.config.UserPrincipal;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFiter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUnit jwtTokenUnit;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = httpServletRequest.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            new Exception("lõif");
        } else {
            String token = authHeader.substring(7);
            Claims claims = jwtTokenUnit.validateToKen(token);
            String name = claims.getSubject();
            UserPrincipal principal = (UserPrincipal) myUserDetailsService.loadUserByUsername(name);
            if (StringUtils.hasText(token)) {
                //    System.err.println("vao quyen");
                UsernamePasswordAuthenticationToken authReq
                        = new UsernamePasswordAuthenticationToken(principal.getUsername(), principal.getPassword(), principal.getAuthorities());
                Authentication auth = authenticationManager.authenticate(authReq);
                SecurityContext sc = SecurityContextHolder.getContext();
                sc.setAuthentication(auth);
            } else {
                new Exception("lỗi");
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
