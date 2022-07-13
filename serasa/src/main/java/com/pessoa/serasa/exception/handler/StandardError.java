package com.pessoa.serasa.exception.handler;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError(Integer status, String message, String error, String path) {
		super();
		this.timestamp = System.currentTimeMillis();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public StandardError(Integer status, String message, String path) {
		super();
		this.timestamp = System.currentTimeMillis();
		this.status = status;
		this.message = message;
		this.path = path;
	}
	
	public StandardError() {
		super();
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StandardError [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
	
}