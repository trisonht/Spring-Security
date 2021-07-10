package com.example.loginspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        try {
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}nguyentri1").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/users").hasRole("USER")
                    .antMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/showMyLoginPage")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
                .and()
                    .logout().permitAll()
                .and()
                    .exceptionHandling().accessDeniedPage("/access-denied");
    }
}












