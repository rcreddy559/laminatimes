package com.laminatimes.admin.service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.laminatimes.admin.entity.User;
import com.laminatimes.admin.exception.handle.UserNotFoundRuntimeException;
import com.laminatimes.admin.repository.UserRepository;


@Service("customUserDetailsService")
public class CustomUserDetailsService extends User implements UserDetailsService {
    
    @Autowired
    UserRepository  userRepo;
    
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       	Optional<User>  optionalUser =  userRepo.findByWorkEmail(username);
    	optionalUser.orElseThrow(() -> new UserNotFoundRuntimeException("user name not found"));
   	 	 return new org.springframework.security.core.userdetails.User(optionalUser.get().getWorkEmail(), optionalUser.get().getPassword(), getAuthorities(optionalUser.get()));
     }
   
	 public Collection<? extends GrantedAuthority> getAuthorities(User user){
		    return user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority("ROLE_"+user.getRoles()))
		        .collect(Collectors.toList());
		}

}
