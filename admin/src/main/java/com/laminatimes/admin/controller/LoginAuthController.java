package com.laminatimes.admin.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.laminatimes.admin.entity.Role;
import com.laminatimes.admin.exception.handle.UserNotFoundRuntimeException;
import com.laminatimes.admin.model.login.request.AuthenticationRequest;
import com.laminatimes.admin.model.login.request.LoginRequest;
import com.laminatimes.admin.model.login.response.AuthenticationResponse;
import com.laminatimes.admin.model.login.response.LoginResponse;
import com.laminatimes.admin.service.CustomUserDetailsService;
import com.laminatimes.admin.util.JwtUtil;
import com.laminatimes.admin.util.RoleEnum;

@RestController
public class LoginAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAuthController.class);
    
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

    
    
   	@CrossOrigin
    @PostMapping(value={"/login"},  consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@RequestParam(value = "error", required = false) boolean error,
                        Map<String, Object> model,
			HttpServletRequest httpServletRequest, @RequestBody LoginRequest loginReq) throws Exception {
		LoginResponse loginRes = null;
		boolean isUser = false;
		boolean isAdmin = false;

		LOGGER.debug("USER LOGIN DETAILS IS : ", loginReq.toString());
		Authentication authentication;
		loginRes = new LoginResponse();
		try {
			authentication = authenticate(loginReq.getUserName(), loginReq.getPassword());

		} catch (DisabledException e) {
				throw new DisabledException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
				throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		} catch (Exception e) {
				throw new Exception("INVALID_CREDENTIALS", e);
		}

	
		if (authentication != null) {

			if (authentication instanceof UsernamePasswordAuthenticationToken) {
				LOGGER.info("logged in user:" + authentication.getName());
				Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

				for (GrantedAuthority grantedAuthority : authorities) {
					if (grantedAuthority.getAuthority().equals("USER")) {
						isUser = true;
						break;
					} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
						isAdmin = true;
						break;
					}
				}

				if (isAdmin) {
					Role role = new Role();
					role.setId(1);
					role.setRole("ADMIN");
					loginRes.setRole(role);
					loginRes.setEmpId("1");
					loginRes.setFirstName("Tobi");
					loginRes.setLastName("Hoffman");
					loginRes.setEmail("Tobi@ths-bs.de");
					loginRes.setPosition("Manager");
				} else if (isUser) {
					Role role = new Role();
					role.setId(2);
					role.setRole("USER");
					loginRes.setRole(role);
					loginRes.setEmpId("21");
					loginRes.setFirstName("Sravan");
					loginRes.setLastName("Palakala");
					loginRes.setEmail("s.palakala@ths-bs.de");
					loginRes.setPosition("Senior Software Developer");
				} else {
					// loginRes.setRole("ANONYMOUS");
				}
				HttpSession session = httpServletRequest.getSession(true);

				loginRes.setStatus(HttpStatus.OK);
				loginRes.setDescription("login is successfull");
				loginRes.setSessionKey(session.getId());

			}

		}
		return ResponseEntity.ok(loginRes);

	}

    @RequestMapping(value={"/home"}, method = RequestMethod.GET)
    public String home(HttpServletRequest request) throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LOGGER.info(authentication.getName());
        if(request.isUserInRole(RoleEnum.ADMIN.name())) {
            return "th_admin_home";
        } else {
            return "th_home";
        }
    }

    @RequestMapping(value={"/accessdenied"}, method = RequestMethod.GET)
    public String accessdenied() throws IOException {
        return "access_denied";
    }

    
	private Authentication authenticate(String username, String password) throws Exception {
		Authentication  authentication = null;
		try {
			authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (DisabledException e) {
			 LOGGER.error("Disable Exception:"+e.getMessage());
			throw new DisabledException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			 LOGGER.error("bad Credential Exception:"+e.getMessage());
			throw new  BadCredentialsException( e.getMessage());
		}catch(IllegalArgumentException e) {
			 LOGGER.error("IllegalArgumentException:"+e.getMessage());
			throw new IllegalArgumentException("INVALID_CREDENTIALS", e);
		}	catch(InternalAuthenticationServiceException e) {
			 LOGGER.error("InternalAuthenticationServiceException:"+e.getMessage());
			throw new UserNotFoundRuntimeException( e.getMessage());
		}
		catch (Exception e) {
			 LOGGER.error("Exception:"+e.getMessage());
			return authentication;
			
		}
		return authentication;
	}
}
