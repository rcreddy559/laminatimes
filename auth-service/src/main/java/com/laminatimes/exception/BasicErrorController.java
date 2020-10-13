package com.laminatimes.exception;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController extends AbstractErrorController {

	public BasicErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
		
	}

	@RequestMapping
	public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
		@SuppressWarnings("deprecation")
		Map<String, Object> body = getErrorAttributes(request,	isIncludeStackTrace(request, MediaType.ALL));
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(body, status);
	}

	private boolean isIncludeStackTrace(HttpServletRequest request, MediaType all) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
}
