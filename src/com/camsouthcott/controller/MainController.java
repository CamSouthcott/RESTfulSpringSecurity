package com.camsouthcott.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camsouthcott.jsonresponse.JSONResponseFactory;

@Controller
@RequestMapping(value="/")
public class MainController {
	
	@Autowired
	JSONResponseFactory responseFactory;
	
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> publicMethod(){
		return responseFactory.successful().toResponseEntity();
	}
	
	@RequestMapping(value="/secure", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> privateMethod(){
		return responseFactory.successful().toResponseEntity();
	}
}
