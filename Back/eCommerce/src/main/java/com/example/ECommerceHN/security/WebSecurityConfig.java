package com.example.ECommerceHN.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Configuration
    public class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {

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
            http
                    .antMatcher("/api/**")
                    .cors()
                    .and().csrf().ignoringAntMatchers("/api/**")
                    .and()
                    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/auth/**").permitAll()
                    .antMatchers("/signin").permitAll()
                    .anyRequest().authenticated();
        }
    }

}
