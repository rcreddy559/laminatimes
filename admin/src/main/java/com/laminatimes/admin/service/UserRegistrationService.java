package com.laminatimes.admin.service;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.laminatimes.admin.entity.Role;
import com.laminatimes.admin.entity.User;
import com.laminatimes.admin.entity.UserRole;
import com.laminatimes.admin.model.user.registration.request.UserRegRequest;
import com.laminatimes.admin.repository.RoleRepository;
import com.laminatimes.admin.repository.UserRepository;
import com.laminatimes.admin.repository.UserRoleRepository;
import com.laminatimes.admin.util.RoleEnum;


@Service
public class UserRegistrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);

	@Autowired
	UserRepository usrRepo;

	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private UserRoleRepository userRoleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User save(UserRegRequest userReq) {
		// convert from model request to user entity
		encodePassword(userReq);

		User user = setRole(userReq, new User());
		try {
			BeanUtils.copyProperties(user, userReq);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(" in user registoran repo: " + user.toString());

		try {
			int id = (int) usrRepo.save(user).getId();
			int roleId = 0;
			UserRole usrRole = new UserRole();
			for (Role role : user.getRoles()) {
				roleId = role.getId();
				break;
			}
			usrRole.setRole_id(roleId);
			usrRole.setUserId(id);
			userRoleRepo.save(usrRole);
		} catch (Exception e) {
					e.printStackTrace();
		}

		return user;
	}

	private void encodePassword(UserRegRequest user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	}

	private User setRole(UserRegRequest userReg, com.laminatimes.admin.entity.User user) {
		RoleEnum roleEn = null;
		if (userReg.getRoleId().equalsIgnoreCase("ADMIN")) {
			roleEn = RoleEnum.ADMIN;
		} else if (userReg.getRoleId().equalsIgnoreCase("USER")) {
			roleEn = RoleEnum.USER;
		}
		HashSet<Role> roles = new HashSet<Role>();
        //test comment
		List<Role> roleList = roleRepo.findAll();

		Role role = roleRepo.findByRole(roleEn.toString());
		roles.add(role);
		user.setRoles(roles);

		return user;
	}

	public List<UserRegRequest> getUsers() {
		LOGGER.info("Start of getusers()");

		List<User> users = usrRepo.findAll();
		System.out.println("Users--------->" + users.size());

		List<UserRegRequest> userList = new ArrayList<UserRegRequest>();
		users.forEach(user -> {
			UserRegRequest newUser = new UserRegRequest();
			try {
				BeanUtils.copyProperties(newUser, user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			userList.add(newUser);
		});
		return userList;
	}

	public UserRegRequest getUserByEmpNo(String userId) {
		LOGGER.info("getUserById start userId" + userId);
		Optional<User> optional = usrRepo.findByEmpNumber(userId);
		UserRegRequest regRequest = null;

		System.out.println("---------->>>>> " + optional.toString());
		if (optional.isPresent()) {
			regRequest = new UserRegRequest();
			User User = optional.get();
			try {
				System.out.println("User: " + User.toString());
				BeanUtils.copyProperties(regRequest, User);
				System.out.println(regRequest.toString());

			} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
			}
		}

		return regRequest;
	}

	// @Transactional()
	public UserRegRequest update(UserRegRequest userRegProfile) {
		Optional<User> UserOptional = usrRepo.findByEmpNumber(userRegProfile.getEmpNumber());
		try {
			User User = null;
			if (UserOptional.isPresent()) {
				User = usrRepo.getOne(UserOptional.get().getId());
				User.setAboutUser(userRegProfile.getAboutUser() != null ? userRegProfile.getAboutUser() : "");
				User.setActiv(userRegProfile.getActive());
				User.setAddress(userRegProfile.getAddress() != null ? userRegProfile.getAddress() : "");
				User.setBirthDay(userRegProfile.getBirthDay() != null ? userRegProfile.getBirthDay() : "");
				User.setCity(userRegProfile.getCity() != null ? userRegProfile.getCity() : "");
				User.setClientName(User.getClientName() != null ? User.getClientName() : "");
				User.setCountry(User.getCountry() != null ? User.getCountry() : "");
				User.setEmpNumber(User.getEmpNumber() != null ? User.getEmpNumber() : "");
				User.setEndDate(User.getEndDate() != null ? User.getEndDate() : "");
				User.setFirstName(User.getFirstName() != null ? User.getFirstName() : "");
				User.setGendar(User.getGender() != null ? User.getGender() : "");
				User.setHireDate(User.getHireDate() != null ? User.getHireDate() : "");
				User.setHomePhoneNumber(User.getHomePhoneNumber() != null ? User.getHomePhoneNumber() : "");
				User.setInsuranceNumber(User.getInsuranceNumber() != null ? User.getInsuranceNumber() : "");
				User.setLastName(User.getLastName() != null ? User.getLastName() : "");
				User.setPassportNumber(User.getPassportNumber() != null ? User.getPassportNumber() : "");
				User.setPassword(User.getPassword() != null ? User.getPassword() : "");
				User.setPersonalEmail(User.getPersonalEmail() != null ? User.getPersonalEmail() : "");
				User.setPosition(User.getPosition() != null ? User.getPosition() : "");
				User.setPostCode(User.getPostCode() != null ? User.getPostCode() : "");
				User.setPrefix(User.getPrefix() != null ? User.getPrefix() : "");
				User.setProjectEndDate(User.getProjectEndDate() != null ? User.getProjectEndDate() : "");
				User.setProjectName(User.getProjectName() != null ? User.getProjectName() : "");
				User.setProjectStartDate(User.getProjectStartDate() != null ? User.getProjectStartDate() : "");
				User.setRoleId(User.getRoleId() != null ? User.getRoleId() : "");
				User.setSkills(User.getSkills() != null ? User.getSkills() : "");
				User.setSocialSecurityNumber(
						User.getSocialSecurityNumber() != null ? User.getSocialSecurityNumber() : "");
				User.setSuffix(User.getSuffix() != null ? User.getSuffix() : "");
				User.setTaxId(User.getTaxId() != null ? User.getTaxId() : "");
				User.setUserName(User.getUserName() != null ? User.getWorkEmail() : "");
				User.setWorkPhoneNumber(User.getWorkPhoneNumber() != null ? User.getWorkPhoneNumber() : "");
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
				Date hireDate = formatter.parse(User.getHireDate() != null ? User.getHireDate() : "");
				Date endDate = null;
				if (User.getEndDate() != null) {
					System.out.println(" equals:" + User.getEndDate().equalsIgnoreCase("null"));
					endDate = formatter
							.parse(User.getEndDate().equalsIgnoreCase("null") ? "00-00-0000" : User.getEndDate());
				}

				usrRepo.updateUser(User.getId(), User.getUserName(), User.getPassword(), User.getWorkEmail(),
						User.getFirstName(), User.getLastName(), User.getEmpNumber(), User.getAddress(),
						User.getPosition(), User.getRoleId(), hireDate, endDate, User.getAboutUser(),
						User.getWorkPhoneNumber(), User.getSocialSecurityNumber(), User.getProjectStartDate(),
						User.getProjectName(), User.getProjectEndDate(), User.getSuffix(), User.getPrefix(),
						User.getPostCode(), User.getPersonalEmail(), User.getPassportNumber(),
						User.getInsuranceNumber(), User.getHomePhoneNumber(), User.getCountry(), User.getClientName(),
						User.getCity(), User.getTaxId(), User.getSkills(), User.getActive(), User.getGender(),
						User.getBirthDay());

				try {
					BeanUtils.copyProperties(userRegProfile, User);
				} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		}

		return userRegProfile;
	}

	public boolean delete(String empNumber) {
		boolean result = false;
		try {
			Optional<User> optional = usrRepo.findByEmpNumber(empNumber);
			if (optional.isPresent()) {
				Optional<UserRole> userRoleOpt = userRoleRepo.findByUserId(optional.get().getId());
				if (userRoleOpt.isPresent()) {
					userRoleRepo.delete(userRoleOpt.get());
				}
				usrRepo.delete(optional.get());
				result = true;
			}
		} catch (Exception e) {
			return result;
		}

		return result;
	}

}
