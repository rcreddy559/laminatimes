package com.laminatimes.controller;


import com.laminatimes.utils.DBDetails;
import org.apache.log4j.Logger;
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

import com.laminatimes.leaves.entity.Leaves;
import com.laminatimes.payload.ApiResponse;
import com.laminatimes.payload.LeavesResponse;
import com.laminatimes.payload.PagedResponse;
import com.laminatimes.payload.request.LeavesRequest;
import com.laminatimes.service.LeavesService;
import com.laminatimes.utils.AppConstants;
import com.laminatimes.utils.AppUtils;

import java.util.Map;

@RestController
@RequestMapping("/leaves")
public class LeavesController {
    static final Logger logger = Logger.getLogger(LeavesController.class);

    @Autowired
    private LeavesService service;

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${spring.env.prod: default value }")
	private String defaultValue;

	@Value("This is static value")
	private String staticValue;

	@Value("#{${sping.map.dbvalues}}")
	private Map<String, String> dbValues;

	@Autowired
	private DBDetails dbDetails;


	@PostMapping
    public ResponseEntity<Leaves> create(@RequestBody LeavesRequest leaveRequest) {
		System.out.println("applicationName: "+applicationName);
		System.out.println("defaultValue: "+defaultValue);
		System.out.println("staticValue: "+staticValue);
		System.out.println("dbValues:"+dbValues);
		System.out.println(dbDetails.toString());
        service.createLeaves(leaveRequest);
        return new ResponseEntity<Leaves>(HttpStatus.ACCEPTED);
    }
    
    @GetMapping
	public PagedResponse<LeavesResponse> getAllLeaves(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		AppUtils.validatePageNumberAndSize(page, size);
		
		return service.getAllLeaves(page, size);
	}


	@GetMapping("/{id}")
	public ResponseEntity<Leaves> getLeave(@PathVariable(name = "id") Integer id) {
		return service.getLeave(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<LeavesResponse> updateLeave(@PathVariable(name = "id") Integer id,  @RequestBody LeavesRequest newLeave
			) {
		return service.updateLeaves(id, newLeave);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteLeave(@PathVariable(name = "id") Integer id) {
		return service.deleteLeave(id);
	}



}
