package com.laminatimes.admin;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.laminatimes.admin.repository.RoleRepository;
import com.laminatimes.admin.repository.UserRepository;
import com.laminatimes.filter.JwtRequestFilter;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableJpaRepositories(basePackageClasses = { UserRepository.class , RoleRepository.class})
@Configuration
@EntityScan(basePackages = "com.laminatimes.admin.entity")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return super.userDetailsService();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	


	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	AlwaysSendUnauthorized401AuthenticationEntryPoint alwaysSendUnauthorized401AuthenticationEntryPoint = new AlwaysSendUnauthorized401AuthenticationEntryPoint();

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/user").permitAll()
				.antMatchers(HttpMethod.PUT, "/user").permitAll().antMatchers(HttpMethod.DELETE, "/user/*").permitAll()
				.antMatchers(HttpMethod.GET, "/user/*").permitAll().antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/newuser/*").permitAll();
//		httpSecurity.csrf().disable()
//		.authorizeRequests().antMatchers(HttpMethod.POST,"/authenticate").permitAll().antMatchers(HttpMethod.POST, "/user").permitAll().
//				anyRequest().authenticated().and().
//				exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

	public class AlwaysSendUnauthorized401AuthenticationEntryPoint implements AuthenticationEntryPoint {
		@Override
		public final void commence(HttpServletRequest request, HttpServletResponse response,
				AuthenticationException authException) throws IOException {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}

	}
}
