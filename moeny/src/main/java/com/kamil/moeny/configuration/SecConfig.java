package com.kamil.moeny.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private MyUsrDetailService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
		         .antMatchers("/VAADIN/**", "/PUSH/**", "/UIDL/**", "/login", "/login/**", "/register", "/environment").permitAll()
		         .antMatchers("/main", "/main/**").authenticated()
	         .and()    
		         .csrf().disable()
		         .exceptionHandling()
		         .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
	         .and()
	         	.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	        
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider()).userDetailsService(userDetailsService);
		
	}
	
	
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
