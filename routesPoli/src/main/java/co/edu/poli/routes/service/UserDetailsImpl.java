package co.edu.poli.routes.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import co.edu.poli.routes.model.User;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = -6855979919718350058L;
	private Integer id;
	private String password;
	
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(User user) {
		this.id = user.getId();
		this.password = user.getPassword();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
		.collect(Collectors.toList());
	}

	public UserDetailsImpl() {
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public Integer getId() {
		return id;
	}



}
