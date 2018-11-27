package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService(){
        return new CustomUserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/amqp").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/security/login")
                    .failureUrl("/security/login?error")
                    .defaultSuccessUrl("/security/index")
//                    .loginProcessingUrl("/security/toLogin")
                    .successForwardUrl("/security/index")
                    .permitAll()
                .and()
                .logout().logoutUrl("/security/logout").permitAll();

    }
}
