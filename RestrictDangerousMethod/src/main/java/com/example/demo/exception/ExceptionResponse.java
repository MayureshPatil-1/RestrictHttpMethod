package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {

	private String status;

	@JsonIgnore
	private String errorCode;
	@JsonProperty("errorCode")
	private String custErrorCode;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonProperty("rcvdOn")
	private LocalDateTime timestamp;
	private List<String> errorMessages;

	
	
	public ExceptionResponse(String status, String errorCode, String custErrorCode, LocalDateTime timestamp,
			List<String> errorMessages) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.custErrorCode = custErrorCode;
		this.timestamp = timestamp;
		this.errorMessages = errorMessages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getCustErrorCode() {
		return custErrorCode;
	}

	public void setCustErrorCode(String custErrorCode) {
		this.custErrorCode = custErrorCode;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}