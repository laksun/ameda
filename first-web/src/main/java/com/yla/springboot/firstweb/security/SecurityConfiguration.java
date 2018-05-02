package com.yla.springboot.firstweb.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${ldap.urls}")
	private String ldapUrls;
	
	@Value("${ldap.base.dn}")
	private String ldapBaseDn;
	
	@Value("${ldap.username}")
	private String ldapSecurityPrincipal;
	
	@Value("${ldap.password}")
	private String ldapPrincipalPassword;
	
	@Value("${ldap.user.dn.pattern}")
	private String ldapUserDnPattern;
	
	@Value("${ldap.enabled}")
	private String ldapEnabled;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login**").permitAll()
		.antMatchers("/profile/**").fullyAuthenticated()
		.antMatchers("*todo*/**").fullyAuthenticated()
		.antMatchers("/").permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
    	.failureUrl("/login?error")
    	.permitAll()
    	.and()
    .logout()
    	.invalidateHttpSession(true)
    	.deleteCookies("JSESSIONID")
    	.permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		if(Boolean.parseBoolean(ldapEnabled)) {
			auth
				.ldapAuthentication()
				.contextSource()
					.url(ldapUrls + ldapBaseDn)
						.managerDn(ldapSecurityPrincipal)
						.managerPassword(ldapPrincipalPassword)
					.and()
						.userDnPatterns(ldapUserDnPattern);
		} else {
	        auth
	        .inMemoryAuthentication()
	            .withUser("user").password("password").roles("USER")
	            .and()
	            .withUser("admin").password("admin").roles("ADMIN");
		}
	}
	
	 @Bean
	    public LdapTemplate ldapTemplate(ContextSource contextSource) {
	        return new LdapTemplate(contextSource);
	    }
	
	
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.inMemoryAuthentication().withUser("yusuf").password("12345678")
//				.roles("USER", "ADMIN");
//	}

	
	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/login").permitAll()
//				.antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
//				.formLogin();
//	}
//	
//	@SuppressWarnings("deprecation")
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
	
	
}
