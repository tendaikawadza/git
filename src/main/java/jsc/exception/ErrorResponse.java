package jsc.exception;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

}
