package br.com.lds.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.
			authorizeRequests()
				.antMatchers(HttpMethod.POST, "/service/**").permitAll()
				.antMatchers(HttpMethod.GET, "/service/**").permitAll()
				.antMatchers("/resources/**", "/imagens/**").permitAll(); 
				
		super.configure(http);
	    http
	    	.formLogin()
	    		.loginPage("/login/login.xhtml").permitAll();
	    http
	    	.logout()
	    		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	    			.clearAuthentication(true)
	    				.logoutSuccessUrl("/")
	    					.deleteCookies("JSESSIONID")
	    						.invalidateHttpSession(true);
	}

}
