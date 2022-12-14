package com.oa.pma.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
	
	@GetMapping("/error")
	public String handlerError(HttpServletRequest request){
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null){
			Integer statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()){
				return "errors/404";
			}else if (statusCode == HttpStatus.FORBIDDEN.value())
				return "errors/403";
		}
		
		return "errors/error";
	}
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
}
