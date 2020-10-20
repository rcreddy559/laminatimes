package com.laminatimes.service;

import java.io.IOException;
import java.util.Optional;
import com.laminatimes.entity.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service("customUserDetailsService")
public class CustomUserDetailsService  {

	@Autowired
	HttpService service;

   public UserDetails loadUserByUsername(String username) throws IOException, InterruptedException {
	   Optional<UserResponse> optionalUser = Optional.of(service.getUserDetails(username));
	   System.out.println("isPresent: "+optionalUser.isPresent());

	   return  null;
//	   return optionalUser.orElse(new UserResponse());
//   	 	 return new org.springframework.security.core.userdetails.User(optionalUser.get().getWorkEmail(),
//				 optionalUser.get().getPassword(),
//				 getAuthorities(optionalUser.get()));
     }

	public UserResponse getByUserName(String username) throws IOException, InterruptedException {
		Optional<UserResponse> optionalUser = Optional.of(service.getUserDetails(username));
		System.out.println("isPresent: "+optionalUser.isPresent());

		return optionalUser.orElse(new UserResponse());
//   	 	 return new org.springframework.security.core.userdetails.User(optionalUser.get().getWorkEmail(),
//				 optionalUser.get().getPassword(),
//				 getAuthorities(optionalUser.get()));
	}
   
//	 public Collection<? extends GrantedAuthority> getAuthorities(User user){
//		    return user.getRoles().stream()
//		        .map(role -> new SimpleGrantedAuthority("ROLE_"+user.getRoles()))
//		        .collect(Collectors.toList());
//		}

}
