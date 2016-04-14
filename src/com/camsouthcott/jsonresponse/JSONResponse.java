package com.camsouthcott.jsonresponse;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//A class for simplifying json responses for output
public class JSONResponse {
	JSONObject body;
	HttpStatus httpStatus;
	
	public JSONResponse(HttpStatus httpStatus){
		body = new JSONObject();
		this.httpStatus = httpStatus;
	}
	
	public JSONResponse(JSONObject body, HttpStatus httpStatus){
		this.body = body;
		this.httpStatus = httpStatus;
	}
	
	public JSONObject getBody(){
		return body;
	}
	
	//For creating jsonObjects
	public void putBody(String key, String value){
		body.put(key, value);
	}
	
	public void putBody(String key, Map<String,String> values){
		body.put(key, new JSONObject(values));
	}
	
	public void putBody(String key, JSONObject object){
		body.put(key, object);
	}
	
	//For creating JSONArrays
	public void appendBody(String key, String value){
		body.append(key, value);
	}
	
	public void appendBody(String key, Map<String,String> values){
		body.append(key, new JSONObject(values));
	}
	
	public void appendBody(String key, JSONObject object){
		body.append(key, object);
	}
	
	//Converts the JSONResponse for output
	public ResponseEntity<String> toResponseEntity(){
		return new ResponseEntity<String>(body.toString(),httpStatus);
	}
}
