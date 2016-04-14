package com.camsouthcott.jsonresponse;

import com.camsouthcott.jsonresponse.JSONResponse;

public abstract class JSONResponseFactory {
	
	public abstract JSONResponse successful();
	
	public abstract JSONResponse resourceCreated();
	
	public abstract JSONResponse duplicate();
	
	public abstract JSONResponse inputMissing();
	
	public abstract JSONResponse illegalFormat();
	
	public abstract JSONResponse resourceNotFound();
	
	public abstract JSONResponse error();
	
	public abstract JSONResponse accessDenied();
	
	public abstract JSONResponse resourceNotOwned();
}

