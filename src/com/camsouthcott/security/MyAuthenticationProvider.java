package com.camsouthcott.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

//Authentication can also be done in a class called UserDetailsService
//Most projects I have seen use this method
//however, in order to use salts with UserDetailsService, I have to create another provider class for salts
//My implementation is much more clean, is implemented in a single file and allows for more control over authentication 

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		if(username != null ||  password != null){
			
			//Normally, this section would pull user data a DAO class, hash the password, etc and compare it to the credentials provided for authentication
			//I'm not implementing a data layer for this project, so there is only 1 user ("cameron", with password "password")
			if(username.equals("cameron") && password.equals("password")){
				List<GrantedAuthority> authoritiesList = getUserAuthorities();
				return new UsernamePasswordAuthenticationToken(username,password,authoritiesList);
			}
		}
		
		throw new BadCredentialsException("Bad Credentials");
	}
	
	private List<GrantedAuthority> getUserAuthorities(){
		
		Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
		
		//For this project all users have 1 authority level, replace this section with authority granting logic if you require more
		authoritiesSet.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		return new ArrayList<GrantedAuthority>(authoritiesSet);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
