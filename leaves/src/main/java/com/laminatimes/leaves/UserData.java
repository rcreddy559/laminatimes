package com.laminatimes.leaves;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.laminatimes.leaves.entity.Project;
import com.laminatimes.leaves.entity.User;
import com.laminatimes.repository.ProjectRepsoitory;
import com.laminatimes.repository.UserRepository;
@Component
public class UserData {
	@Autowired
	private ProjectRepsoitory projectRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = false)
	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		System.out.println("begin inside user data class ");
		User emp = new User();
		emp.setFirstName("sravan");
		emp.setWorkEmail("s.palakala@ths-bs.de");
		emp.setPassword("12345");
		emp.setActiv(1);
		emp.setPersonalEmail("s.palakala@ths-bs.de");

		userRepository.save(emp);

		User mgr = new User();
		mgr.setFirstName("ravi");
		mgr.setWorkEmail("ravichandra@ths-bs.de");
		mgr.setPassword("12345");
		mgr.setActiv(1);
		mgr.setPersonalEmail("ravichandra@ths-bs.de");

		userRepository.save(mgr);

		System.out.println("end inside user data  ");

		System.out.println("begin inside project data class ");

		Project pro = new Project();
		pro.setProjectName("thools");

		try (Stream<User> foundEmpUserstrm = userRepository.findByFirstName("sravan")) {
			User empUser = foundEmpUserstrm.filter((user) -> user.getId() > 1).reduce(null, (u, v) -> {
				if (u != null && v != null)
					throw new IllegalStateException("More than one ID found");
				else
					return u == null ? v : u;
			});

			pro.setEmployeeUser(empUser);

			Stream<User> foundMgrUserstrm = userRepository.findByFirstName("ravi");
			User mgrUser = foundMgrUserstrm.filter((user) -> user.getId() > 1).reduce(null, (u, v) -> {
				if (u != null && v != null)
					throw new IllegalStateException("More than one ID found");
				else
					return u == null ? v : u;
			});
			pro.setManagerUser(mgrUser);
			foundEmpUserstrm.close();
			foundMgrUserstrm.close();

		}

		projectRepository.save(pro);

		System.out.println("end inside project data  ");

	}

}
