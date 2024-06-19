package org.pancakes.config;

import org.pancakes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()

//                .antMatchers("/").hasAnyRole("COOKIESELLER", "BAKERYSELLER", "PANCAKESELLER", "ADMIN", "USER")
//                .antMatchers("/pancake").hasAnyRole("COOKIESELLER", "BAKERYSELLER", "PANCAKESELLER", "ADMIN", "USER")
//                .antMatchers("/cookie").hasAnyRole("COOKIESELLER", "BAKERYSELLER", "PANCAKESELLER", "ADMIN", "USER")
//                .antMatchers("/bakery").hasAnyRole("COOKIESELLER", "BAKERYSELLER", "PANCAKESELLER", "ADMIN", "USER")
                .antMatchers("/createBakery").hasAnyRole("BAKERYSELLER", "ADMIN")
                .antMatchers("/createCookie").hasAnyRole("COOKIESELLER", "ADMIN")
                .antMatchers("/createPancake").hasAnyRole("PANCAKESELLER", "ADMIN")
                .antMatchers("/pancake").authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/pancake")
                .and()
                .logout().logoutSuccessUrl("/pancake");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);

        return authenticationProvider;
    }
}
