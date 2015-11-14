package com.avi.enums;

import javax.servlet.http.HttpServletResponse;

public enum ErrorType {
	
	GENERAL_ERRROR(1, HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
	TOO_SHORT_PASSWORD(2, HttpServletResponse.SC_BAD_REQUEST),
	TOO_LONG_PASSWORD(3, HttpServletResponse.SC_BAD_REQUEST);
	
	private int internalErrorCode;
	private int httpErrorCode;

	ErrorType(int internalErrorCode, int httpErrorCode){
		this.internalErrorCode = internalErrorCode;
		this.httpErrorCode = httpErrorCode;
	}

	public int getInternalErrorCode() {
		return internalErrorCode;
	}

	public void setInternalErrorCode(int internalErrorCode) {
		this.internalErrorCode = internalErrorCode;
	}

	public int getHttpErrorCode() {
		return httpErrorCode;
	}

	public void setHttpErrorCode(int httpErrorCode) {
		this.httpErrorCode = httpErrorCode;
	}
	
}
