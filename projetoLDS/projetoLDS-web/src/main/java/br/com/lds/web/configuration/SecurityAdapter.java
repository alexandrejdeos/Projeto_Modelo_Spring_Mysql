package br.com.lds.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
		http.
			authorizeRequests()
				.antMatchers(HttpMethod.POST, "/service/**").permitAll()
				.antMatchers(HttpMethod.GET, "/service/**").permitAll()
				.antMatchers("/resources/**", "/imagens/**").permitAll() 
				
				.anyRequest()
					.authenticated()
						.and()
							.formLogin()
								//.loginPage("/login/login.xhtml").permitAll() Preciso de verificar alguns detalhes
						.and()
							.httpBasic()
						.and()
							.logout()
								.deleteCookies("JSESSIONID")
									.invalidateHttpSession(true)
										.logoutSuccessUrl("/login/login.xhtml");
	}

}
