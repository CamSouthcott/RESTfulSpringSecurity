package com.camsouthcott.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camsouthcott.jsonresponse.JSONResponseFactory;

//Overrides the default tomcat error handling, which is too verbose
@Controller
public class ErrorController {

	@Autowired
	JSONResponseFactory responseFactory;
	
	@RequestMapping(value="/error")
	public ResponseEntity<String> error(HttpServletRequest request){
		
		try{
			//Gets the requestCode of the internal request that sent the servlet here
			Integer requestCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
			
			switch(requestCode){
				case 401:
					return responseFactory.accessDenied().toResponseEntity();
				case 404:
					return responseFactory.resourceNotFound().toResponseEntity();
				default:
					return responseFactory.error().toResponseEntity();
			}
			
			
				
		}catch(Exception e){
			
		}
		
		return responseFactory.error().toResponseEntity();
	}
	
}
