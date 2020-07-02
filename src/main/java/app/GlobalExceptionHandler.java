package app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import app.constants.ErrorCode;
import app.constants.ErrorGravity;
import app.exception.DataNotFoundInDatabaseException;
import app.exception.FileNotFoundInDatabase;
import app.exception.response.ExceptionResponse;

@RestControllerAdvice(basePackages = "app")

public class GlobalExceptionHandler {

	@ExceptionHandler(value = DataNotFoundInDatabaseException.class)
	public ResponseEntity<ExceptionResponse> dataNotFound() {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder()
				.errcode(ErrorCode.NOTFOUND.name())
				.errmessage("Entity Not Found")
				.errgravity(ErrorGravity.FATAL.name())
				.build(),
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = FileNotFoundInDatabase.class)
	public ResponseEntity<ExceptionResponse> filenotfound() {
		return new ResponseEntity<ExceptionResponse>(ExceptionResponse.builder()
				.errcode(ErrorCode.NOTFOUND.name())
				.errmessage("File not Found")
				.errgravity(ErrorGravity.FATAL.name()).build(),
				HttpStatus.BAD_REQUEST
				);
	}

}
