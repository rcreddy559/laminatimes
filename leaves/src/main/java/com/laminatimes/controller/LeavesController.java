package com.laminatimes.controller;


import com.laminatimes.exception.LeavesException;
import com.laminatimes.utils.DBDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.laminatimes.payload.ApiResponse;
import com.laminatimes.payload.LeavesResponse;
import com.laminatimes.payload.PagedResponse;
import com.laminatimes.payload.request.LeaveVO;
import com.laminatimes.service.LeavesService;
import com.laminatimes.utils.AppConstants;
import com.laminatimes.utils.AppUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leave")
public class LeavesController {
    static final Logger logger = LoggerFactory.getLogger(LeavesController.class);

    @Autowired
    private LeavesService service;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.env.prod: default value }")
	private String defaultValue;

	@Value("This is static value")
	private String staticValue;

//	@Value("${sping.map.dbvalues}")
	private Map<String, String> dbValues;

	@Autowired
	private DBDetails dbDetails;


	@PostMapping
    public ResponseEntity<LeaveVO> create(@RequestBody LeaveVO leaveRequest) {
		logger.debug("applicationName: {} ", applicationName);
		logger.debug("defaultValue:{} ", defaultValue);
		logger.debug("staticValue: {}", staticValue);
		logger.debug("dbValues: {}", dbValues);
		logger.debug(dbDetails.toString());


		leaveRequest = service.createLeaves(leaveRequest);
		logger.debug(leaveRequest.toString());
        return new ResponseEntity<>(leaveRequest, HttpStatus.ACCEPTED);
    }

    @RequestMapping
	public List<LeaveVO> all() throws Exception {
//		Thread.sleep(60*60*360);
//		List<LeaveVO> leaves = service.getLeaves();
//		logger.debug("all leaves size: {} " , leaves.size());
//
//		leaves.forEach(leaveVO -> {
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//			logger.debug("Leave: {}", leaveVO.toString());
//		});
		throw new Exception("test one");
//		return Collections.EMPTY_LIST;
	}

    @GetMapping("/range")
	public PagedResponse<LeavesResponse> getAllLeaves(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		AppUtils.validatePageNumberAndSize(page, size);
		
		return service.getAllLeaves(page, size);
	}


	@GetMapping("/{id}")
	public LeaveVO getLeave(@PathVariable(name = "id") Integer id) {
		LeaveVO leave = service.getLeave(id);
		logger.debug(leave.toString());
		return leave;
	}

	@PutMapping("/{id}")
	public LeaveVO updateLeave( @RequestBody LeaveVO newLeave
			) throws LeavesException {
		if(newLeave.getId() != 0) {
			LeaveVO leave = service.updateLeaves(newLeave);
			logger.debug(leave.toString());
			return leave;
		} else {
			logger.error("No id provided for update Leaves");
			throw new LeavesException("No id");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteLeave(@PathVariable(name = "id") Integer id) {
		return service.deleteLeave(id);
	}

}
