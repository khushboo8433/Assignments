package com.example.project1.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET,"/couponapi/coupons","/index","/showGetCoupon","/getCoupon","/couponDetails").hasAnyRole("USER","ADMIN")
                .mvcMatchers(HttpMethod.GET,"/viewCustomers","/viewSellers").hasRole("ADMIN")
                .mvcMatchers("/activateCustomer/**","/deactivateCustomer/**").hasRole("ADMIN")
                .mvcMatchers("/activateSeller/**","deactivateSeller/**").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.GET,"/viewMyProfile","/viewMyAddresses","/getCategoriesWithChildByCategoryId/{id}").hasRole("CUSTOMER")
                .mvcMatchers(HttpMethod.DELETE, "/deleteAddress/{id}").hasRole("CUSTOMER")
                .mvcMatchers("/register","/seller/register","/login","/logout","/confirm-account","/reset-password","/forgot-password").permitAll()
                .anyRequest().denyAll().and().csrf().disable().logout().logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

