package com.example.ecommerce.security;


import com.example.ecommerce.entities.RoleNameEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;



        @Bean
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Bean
        public AuthTokenFilter authenticationJwtTokenFilter(){
            return new AuthTokenFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            /*
            http.csrf()
                    .ignoringAntMatchers("/api/auth/**");
            http.authorizeRequests()
                    .antMatchers("/api/get/**").hasRole("USER");*/

            http
                    .cors()
                    .and().csrf().ignoringAntMatchers("/api/**")
                    .and()
                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                    .and()
                    .authorizeRequests()
                   //.antMatchers("/api/products/**").hasRole("USER")
                    .antMatchers("/api/products/**").permitAll()
                   // .antMatchers("/api/users/**").hasAnyRole("USER","ADMIN")
                    .antMatchers("/api/auth/**").permitAll()
 
                    .antMatchers("/api/users/**").permitAll() 
                    //.antMatchers(HttpMethod.POST,"/api/users/users/new_user").permitAll()
                    .antMatchers("/api/auth/signin").permitAll()
                    .anyRequest().authenticated();

            http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        }
    }


