package org.ddmed.ris.configuration;

import org.ddmed.ris.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/patients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/patients").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/patients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/patients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/patients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                .antMatchers("/calendar").anonymous()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}