package com.laminatimes.admin.repository;

import java.util.Date;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.laminatimes.admin.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User>  findByEmpNumber(String empNumber);
	
	Optional<User>  findByUserName(String userName);
	
	Optional<User> findByPersonalEmail(String personalEmail);
	
	Optional<User> findByWorkEmail(String workEmail);

	// @Modifying(clearAutomatically = true)
	 @Query(value="UPDATE User u SET u.USER_NAME = ?2,u.PASSWORD = ?3, "
		   		+ " u.WORK_EMAIL = ?4, U.FIRST_NAME = ?5"
		   		+ " u.LAST_NAME = ?6, u.EMP_NUMBER = ?7,"
		   		+ " u.ADDRESS = ?8, u.POSITION = ?9,"
		   		+ " u.ROLE_ID = ?10, u.HIRE_DATE =?11,"
		   		+ " u.END_DATE = ?12, u.ABOUT_USER= ?13,"
		   		+ " u.WORK_PHONE_NUMBER = ?14, u.SOCIAL_SECURITY_NUMBER=?15,"
		   		+ " u.PROJECT_START_DATE= ?16, u.PROJECT_NAME= ?17,"
		   		+ " u.PROJECT_END_DATE=?18, u.SUFFIX =?19,"
		   		+ " u.PREFIX = ?20, u.POST_CODE= ?21,"
		   		+ " u.PERSONAL_EMAIL = ?22, u.PASSPORT_NUMBER = ?23"
		   		+ " u.INSURANCE_NUMBER = ?24, u.HOME_PHONE_NUMBER = ?25"
		   		+ " u.COUNTRY = ?26, u.CLIENT_NAME = ?27,"
		   		+ " u.CITY = ?28, u.TAX_ID = ?29,"
		   		+ " u.SKILLS = ?30, u.ACTIVE = ?31,"
		   		+ " u.GENDAR = ?32, u.BIRTH_DAY =?33   WHERE u.ID = ?1", nativeQuery = true)
	    int updateUser(
	    		 int userId,  String userName,
	    		String password, String workEmail,
	    		 String firstName,  String lastName,
	    		 String empNo, String address,
	    		 String position,  String roleId,
	    		 Date hireDate,  Date endDate,
	    		 String abtUsr,  String workPhoneNo,
	    		 String socialSecurityNo, String projectStartDate,
	    		 String projectName,  String projectEndDate,
	    		 String suffix,  String prefix,
	    		 String postCode,  String personalEmail,
	    		 String passportNo,  String insuranceNo,
	    		 String homePhoneNo,  String country,
	    		 String clientName,  String city,
	    		 String taxId,  String skills,
	    		 int active,  String GENDAR,
	    		 String birthDay);		
	    	
}
