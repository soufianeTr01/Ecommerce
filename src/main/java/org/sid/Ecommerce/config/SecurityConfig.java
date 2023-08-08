package org.sid.Ecommerce.config;


import org.sid.Ecommerce.Services.auth.ApplicationDetailservice;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ApplicationDetailservice applicationDetailservice;

    public SecurityConfig(ApplicationDetailservice applicationDetailservice) {
        this.applicationDetailservice = applicationDetailservice;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                .authorizeRequests().antMatchers("/**/login").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // mon service qui permet de chercher les infos de user
        auth.userDetailsService(applicationDetailservice);
    }
}
