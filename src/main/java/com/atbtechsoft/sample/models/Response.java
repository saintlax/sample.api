package com.atbtechsoft.sample.models;

public class Response {
	private String error;
	private int statusCode;
	private Object payload;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getPayload() {
		return payload;
	}
	public void setPayload(Object payload) {
		this.payload = payload;
	}

}
