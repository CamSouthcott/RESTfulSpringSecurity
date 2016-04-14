package com.camsouthcott.jsonresponse.impl;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.camsouthcott.jsonresponse.JSONResponse;
import com.camsouthcott.jsonresponse.JSONResponseFactory;

@Component
public class JSONResponseFactoryImpl  extends JSONResponseFactory{

	private static final String REQUEST_STATUS = "RequestStatus";
	private static final String SUCCESSFUL = "Successful";
	private static final String RESOURCE_CREATED = "Created";
	private static final String DUPLICATE = "Duplicate";
	private static final String ILLEGAL_FORMAT = "IllegalFormat";
	private static final String RESOURCE_NOT_FOUND = "ResourceNotFound";
	private static final String ERROR = "Error";
	private static final String INPUT_MISSING = "InputMissing";
	private static final String ACCESS_DENIED = "AccessDenied";
	private static final String RESOURCE_NOT_OWNED = "ResourceNotOwned";
	
	public JSONResponse successful(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, SUCCESSFUL);
		
		return new JSONResponse(jsonObject,HttpStatus.OK);
	}
	
	public JSONResponse resourceCreated(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, RESOURCE_CREATED);
		
		return new JSONResponse(jsonObject,HttpStatus.CREATED);
	}
	
	public JSONResponse duplicate(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, DUPLICATE);
		
		return new JSONResponse(jsonObject,HttpStatus.CONFLICT);
	}
	
	public JSONResponse inputMissing(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, INPUT_MISSING);
		
		return new JSONResponse(jsonObject,HttpStatus.BAD_REQUEST);
	}
	
	public JSONResponse illegalFormat(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, ILLEGAL_FORMAT);
		
		return new JSONResponse(jsonObject,HttpStatus.BAD_REQUEST);
	}
	
	public JSONResponse resourceNotFound(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, RESOURCE_NOT_FOUND);
		
		return new JSONResponse(jsonObject,HttpStatus.NOT_FOUND);
	}
	
	public JSONResponse error(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, ERROR);
		
		return new JSONResponse(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public JSONResponse accessDenied(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, ACCESS_DENIED);
		
		return new JSONResponse(jsonObject,HttpStatus.UNAUTHORIZED);
	}
	
	public JSONResponse resourceNotOwned(){
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(REQUEST_STATUS, RESOURCE_NOT_OWNED);
		
		return new JSONResponse(jsonObject,HttpStatus.UNAUTHORIZED);
	}
}
