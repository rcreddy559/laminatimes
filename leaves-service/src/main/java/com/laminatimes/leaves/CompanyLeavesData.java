package com.laminatimes.leaves;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.laminatimes.leaves.entity.CompanyLeaves;
import com.laminatimes.repository.CompanyLeavesRepository;

@Component
public class CompanyLeavesData  {
	@Autowired
	private CompanyLeavesRepository companyLeavesRepository;
	
	 @EventListener
	    public void appReady(ApplicationReadyEvent event) {

       System.out.println("begin inside company leaves data class ");
			CompanyLeaves cl = new CompanyLeaves();
			cl.setLeaveType("Annual Leaves");
			cl.setNoOfDays(14);
			cl.setEmployeeType("Permanent Employee");
			cl.setCreateDate(LocalDate.now());
			cl.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl);
			
			CompanyLeaves cl1 = new CompanyLeaves();
			cl1.setLeaveType("Sick Leaves");
			cl1.setNoOfDays(12);
			cl1.setEmployeeType("Permanent Employee");
			cl1.setCreateDate(LocalDate.now());
			cl1.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl1);
			
			CompanyLeaves cl2 = new CompanyLeaves();
			cl2.setLeaveType("Casual Leaves");
			cl2.setNoOfDays(12);
			cl2.setEmployeeType("Permanent Employee");
			cl2.setCreateDate(LocalDate.now());
			cl2.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl2);
			
			CompanyLeaves cl3 = new CompanyLeaves();
			cl3.setLeaveType("Marriage Leaves");
			cl3.setNoOfDays(12);
			cl3.setEmployeeType("Permanent Employee");
			cl3.setCreateDate(LocalDate.now());
			cl3.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl3);
			
			CompanyLeaves cl4 = new CompanyLeaves();
			cl4.setLeaveType("Parental Leaves");
			cl4.setNoOfDays(12);
			cl4.setEmployeeType("Permanent Employee");
			cl4.setCreateDate(LocalDate.now());
			cl4.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl4);
			
			CompanyLeaves cl5 = new CompanyLeaves();
			cl5.setLeaveType("Parental Leaves");
			cl5.setNoOfDays(12);
			cl5.setEmployeeType("Permanent Employee");
			cl5.setCreateDate(LocalDate.now());
			cl5.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl5);
			
			CompanyLeaves cl6 = new CompanyLeaves();
			cl6.setLeaveType("Compensation Leaves");
			cl6.setNoOfDays(12);
			cl6.setEmployeeType("Permanent Employee");
			cl6.setCreateDate(LocalDate.now());
			cl6.setCreatedBy("admin");
			
			companyLeavesRepository.save(cl6);

			System.out.println("end inside company leaves data class ");
		
	    }

	

}

