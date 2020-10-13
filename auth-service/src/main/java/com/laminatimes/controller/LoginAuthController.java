package com.laminatimes.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.laminatimes.login.request.AuthenticationRequest;
import com.laminatimes.login.response.AuthenticationResponse;
import com.laminatimes.service.CustomUserDetailsService;
import com.laminatimes.util.JwtUtil;

@RestController
public class LoginAuthController {


	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAuthController.class);
    
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {


		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
