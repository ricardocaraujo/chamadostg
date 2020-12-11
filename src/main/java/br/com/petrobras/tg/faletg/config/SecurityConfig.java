package br.com.petrobras.tg.faletg.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	/*
	 * @Autowired private Environment env;
	 * 
	 * private static final String[] PUBLIC_MATCHERS = { "/h2-console/**", "/" };
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/chamado", "/registra").permitAll()
				.antMatchers("/h2-console/**").permitAll();		
		http.csrf().disable();
        http.headers().frameOptions().disable();
				/*.anyRequest().authenticated()
			.and()
			.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/chamado", true)
				.permitAll());	*/
			
		/*
		 * if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
		 * http.headers().frameOptions().disable(); }
		 * 
		 * http.cors().and().csrf().disable();
		 * http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().
		 * anyRequest().authenticated();
		 * http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
		 * STATELESS);
		 */
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
	}
	
	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { final
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * new CorsConfiguration().applyPermitDefaultValues()); return source; }
	 */
	
	/*
	 * @Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
}
