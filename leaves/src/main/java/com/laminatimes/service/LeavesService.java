package com.laminatimes.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.laminatimes.exception.LeavesException;
import com.laminatimes.leaves.entity.Leaves;
import com.laminatimes.leaves.entity.User;
import com.laminatimes.payload.LeavesResponse;
import com.laminatimes.payload.PagedResponse;
import com.laminatimes.payload.request.LeavesRequest;
import com.laminatimes.repository.LeavesRepository;
import com.laminatimes.repository.UserRepository;
import com.laminatimes.utils.AppUtils;

@Service
public class LeavesService {
	static final Logger logger = Logger.getLogger(LeavesService.class);
	private static final String NAME = "leaveName";
	@Autowired
	private LeavesRepository leavesRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public void createLeaves(LeavesRequest leavesRequest) {

		Leaves leaves = new Leaves();
		leaves.setLeaveName(leavesRequest.getLeaveName());
		leaves.setStartDate(leavesRequest.getStartDate());
		leaves.setEndDate(leavesRequest.getEndDate());
		leaves.setComments(leavesRequest.getComments());

		leaves.setEmployeeUser(getEmployee(leavesRequest.getEmployeeId()));
		leaves.setCreatedBy(leavesRequest.getCreatedBy());

		leavesRepo.save(leaves);

	}

	private User getEmployee(Integer empID) {
		return userRepository.findById(empID)
				.orElseThrow(() -> new LeavesException("Employee not found with id" + empID));

	}

	public PagedResponse<LeavesResponse> getAllLeaves(int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);

	//	Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, NAME);
		
		Pageable pageable = PageRequest.of(page, size, Sort.by("leaveName"));

		Page<Leaves> leaves = leavesRepo.findAll(pageable);

		if (leaves.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), leaves.getNumber(), leaves.getSize(),
					leaves.getTotalElements(), leaves.getTotalPages(), leaves.isLast());
		}
		
		List<LeavesResponse> leaveResponses = Arrays
				.asList(modelMapper.map(leaves.getContent(), LeavesResponse[].class));

		return new PagedResponse<>(leaveResponses, leaves.getNumber(), leaves.getSize(), leaves.getTotalElements(),
				leaves.getTotalPages(), leaves.isLast());
	}

	public ResponseEntity<Leaves> getLeave(Integer id) {
		Leaves leaves = leavesRepo.findById(id).orElseThrow(() -> new LeavesException("leaves Not found"));
		return new ResponseEntity<>(leaves, HttpStatus.OK);
	}

	public ResponseEntity<LeavesResponse> updateLeaves(Integer id, LeavesRequest newLeave) {
		Leaves leave = leavesRepo.findById(id).orElseThrow(() -> new LeavesException("Leaves not found"));

		leave.setLeaveName(newLeave.getLeaveName());
		leave.setStartDate(newLeave.getStartDate());
		leave.setEndDate(newLeave.getEndDate());
		Leaves updatedLeaves = leavesRepo.save(leave);

		LeavesResponse leavesResponse = new LeavesResponse();

		modelMapper.map(updatedLeaves, leavesResponse);

		return new ResponseEntity<>(leavesResponse, HttpStatus.OK);

	}

	public ResponseEntity<com.laminatimes.payload.ApiResponse> deleteLeave(Integer id) {
		leavesRepo.findById(id).orElseThrow(() -> new LeavesException("Leaves not found"));

		leavesRepo.deleteById(id);
		return new ResponseEntity<>(
				new com.laminatimes.payload.ApiResponse(Boolean.TRUE, "You successfully deleted leave"), HttpStatus.OK);

	}

}
