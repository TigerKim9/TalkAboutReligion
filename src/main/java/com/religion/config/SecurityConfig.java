package com.religion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.religion.user.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	private CustomUserDetailsService customUserDetailsService;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/design","orders")
//                .hasRole("USER")
                .antMatchers("/","/**").permitAll()
                .and()
                .httpBasic()
                .and()
                .formLogin()
				.loginPage("/login")
				.usernameParameter("userid")
				.passwordParameter("userpassword")
				.loginProcessingUrl("/loginOk")
				.defaultSuccessUrl("/")
				.and()
				.rememberMe()
				.key("secret")
				.rememberMeParameter("autoLogin")
				.tokenValiditySeconds(86400)
				.userDetailsService(customUserDetailsService)
				.and()
				.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
                ;

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = CustomUserDetails
//                .getUsername()
//                .getPassword()
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

//	// PasswordEncoder 를 bean 으로 IoC 에 등록
//		@Bean
//		public BCryptPasswordEncoder encoder() {
//			return new BCryptPasswordEncoder();
//		}
//		
//		
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable();   // CSRF 비활성화
//			http.authorizeRequests()
//				.antMatchers("/landing/user/**").authenticated()
//				.antMatchers("/landing/admin/**").access("hasRole('ROLE_ADMIN')")
//				.anyRequest().permitAll()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.usernameParameter("userid")
//				.passwordParameter("userpassword")
//				.loginProcessingUrl("/loginOk")
//				.defaultSuccessUrl("/")
//				.and()
//				.rememberMe()
//				.key("secret")
//				.rememberMeParameter("autoLogin")
//				.tokenValiditySeconds(86400)
//				
////				.userDetailsService()
//				.and()
//				.logout()
//				.logoutUrl("/logout")
//				.invalidateHttpSession(true)
//				
//				
//				
//				;
//		}

}
