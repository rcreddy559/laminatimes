package com.laminatimes.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.laminatimes.payload.request.LeaveVO;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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
import com.laminatimes.payload.LeavesResponse;
import com.laminatimes.payload.PagedResponse;
import com.laminatimes.repository.LeavesRepository;
import com.laminatimes.repository.UserRepository;
import com.laminatimes.utils.AppUtils;

@Service
public class LeavesService {
	static final Logger logger = Logger.getLogger(LeavesService.class);
	@Autowired
	private LeavesRepository leavesRepo;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public LeaveVO createLeaves(LeaveVO leavesRequest) {
		Leaves leaves = new Leaves();
		BeanUtils.copyProperties(leavesRequest, leaves);

		leaves = leavesRepo.save(leaves);
		BeanUtils.copyProperties(leaves, leavesRequest);
		return leavesRequest;
	}

	public List<LeaveVO> getLeaves() {
		List<Leaves> leaves =  leavesRepo.findAll();
		List<LeaveVO> leaveVOS = new ArrayList<>(leaves.size());

		leaves.forEach(l->{
			LeaveVO vo = new LeaveVO();
			BeanUtils.copyProperties(l, vo);
			leaveVOS.add(vo);
		});
		return leaveVOS;
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

	public LeaveVO getLeave(Integer id) {
		Leaves leaves = leavesRepo.findById(id).orElseThrow(() -> new LeavesException("leaves Not found"));
		LeaveVO leavesRequest = new LeaveVO();
		BeanUtils.copyProperties(leaves, leavesRequest);
		return leavesRequest;
	}

	public LeaveVO updateLeaves(LeaveVO newLeave) {
		Leaves leave = new Leaves();
		BeanUtils.copyProperties(newLeave, leave);
		leave = leavesRepo.save(leave);
		BeanUtils.copyProperties(leave, newLeave);
		return newLeave;
	}

	public ResponseEntity<com.laminatimes.payload.ApiResponse> deleteLeave(Integer id) {
		leavesRepo.findById(id).orElseThrow(() -> new LeavesException("Leaves not found"));

		leavesRepo.deleteById(id);
		return new ResponseEntity<>(
				new com.laminatimes.payload.ApiResponse(Boolean.TRUE, "You successfully deleted leave"), HttpStatus.OK);

	}

}
