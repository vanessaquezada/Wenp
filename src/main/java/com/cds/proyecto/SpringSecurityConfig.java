/*
 * Fecha: 09-23-2019
 * @Jaime_Ramirez
 */
package com.cds.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// TODO: Auto-generated Javadoc
/**
 * The Class SpringSecurityConfig.
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailservice;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/vendor/**", "/images/**", "/scss/**","/assets/**", "/add/**", "/fonts/**","/registe/**").permitAll()
				.antMatchers("/usuarios/","/instituciones/","/estudiantes/", "/grupos/", "/grupoestudiante/","/notas/", "/materias/","/actividades/").hasAnyRole("Administrador")
				.antMatchers("/estudiantes/","/estudiantes/", "/grupos/", "/grupoestudiante/","/notas/", "/materias/","/actividades/").hasAnyRole("Docente")
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll()
				.and()
	            .logout()
	            .logoutSuccessUrl("/logout")
	            .invalidateHttpSession(true)
	            .clearAuthentication(true)
	            .permitAll();
		        // http.csrf().disable();

	}
	

	/**
	 * Password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Password encoder.
	 *
	 * @return the b crypt password encoder
	 */
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailservice);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	/**
	 * Configure global.
	 *
	 * @param builder the builder
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		// configuración global de los permisos
		builder.userDetailsService(userDetailservice)
		       .passwordEncoder(passwordEncoder)
		       .and()
			   .authenticationProvider(authenticationProvider());
	}

}