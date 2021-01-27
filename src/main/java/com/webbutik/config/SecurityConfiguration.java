package com.webbutik.config;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableWebSecurity //kaze spring boot securiti  da je ovo web securiti konfiguracija
@Profile("production")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//super.configure(auth);
		//set configuration on the auth object
		//tip of authoration
		//trebamo osigurati user i password
		auth.inMemoryAuthentication()
			.withUser("danijela")
				.password("erik")
					.roles("ADMIN")
					.and()
						.withUser("erik")
						.password("danijela")
						.roles("USER");
			//här man kan skriva mer användare och password
	}
	
	// password saved i en encored format, da bi bili neotkriveni u slucaju provale
	//to set password encored, use @Bean of type PasswordEncoder
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		//ovo je encoder koji ne radi nista, znaci da
		//se bavimo sa cistim texstom (deal with clear text
		//to sto je prekrizeno znaci da je za mene ok a
		//da je pasvord cisti tekst
		return NoOpPasswordEncoder.getInstance();
	
	}
	

		
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//	     http
//	.authorizeRequests()
//	  .anyRequest().authenticated()
//	    .and()
//	     .formLogin()
//	       .and()
//	       .httpBasic();

		
		
		//super.configure(http);
		http.authorizeRequests()
			
		.antMatchers("/admin").hasRole("ADMIN")  /*all paths*/
		.antMatchers("/**").hasAnyRole("USER", "ADMIN")
		.and().formLogin()
		.and()
	       .httpBasic(); //typ av login
		
	
	//	http.csrf ().disable ().authorizeRequests ().anyRequest ();
	}
}
