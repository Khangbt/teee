package sapo.ex.ex5_framwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sapo.ex.ex5_framwork.config.jwt.JwtAuthenticationEntryPoint;
import sapo.ex.ex5_framwork.config.jwt.JwtAuthenticationFiter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFiter authenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/token","/name","/*").permitAll()
          //      .antMatchers(HttpMethod.OPTIONS).permitAll()
                 .antMatchers(HttpMethod.GET).permitAll()
//              .antMatchers( HttpMethod.GET,"/admin/**").hasRole("ADMIN")
                .and()

               .authorizeRequests().antMatchers( "/admin/**").hasRole("ADMIN").and()
               .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint) .and()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        ;
        http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable().authorizeRequests().anyRequest().authenticated();
        //http.addFilterBefore(a(), UsernamePasswordAuthenticationFilter.class);


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
