/*
 * Fecha: 09-24-2019
 * @Jaime_Ramirez
 */
package com.cds.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cds.proyecto.entidades.Usuario;
import com.cds.proyecto.repositorios.IUsuarioRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class JpaUserDetailService.
 */
@Service("jpaUserDetailService")
public class JpaUserDetailService implements UserDetailsService {

	/** The password encoder. */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/** The iuser. */
	@Autowired
	
	private IUsuarioRepository iuser;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		User userResponse = null;
		//interfaz usuario(BD)
		Usuario user = null;
		user = iuser.findByUsuario(usuario);
		//listado donde van guardando los roles
		//como hacer la lista cuando hay mas de 1 rol, va a dentro de for each(para que recorra la lista de los roles)		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		//si el usuario es diferente de nulo
		if (user != null) {
			// Agregamos el rol
			roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRol().getRol()));
			// Consruimos los datos del usuario para comparación
			userResponse = new User(user.getUsuario(),user.getPassword(), roles);
		}
		return userResponse;
	}

}
