package br.com.petrobras.tg.faletg.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//import br.com.petrobras.tg.faletg.security.AutenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService uds;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			//.antMatchers("/chamado").permitAll()
			.antMatchers("/bootstrap/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/login*").permitAll()
			.antMatchers("/lista").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().permitAll();
		
		  //http.addFilter(new AutenticationFilter(authenticationManager()));
		  http.csrf().disable(); 
		  http.headers().frameOptions().sameOrigin();
		  http.headers().contentTypeOptions().disable();
		 	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
		//auth.userDetailsService(uds).passwordEncoder(bCryptPasswordEncoder());
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(bCryptPasswordEncoder());
		authProvider.setUserDetailsService(uds);
		return authProvider;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
