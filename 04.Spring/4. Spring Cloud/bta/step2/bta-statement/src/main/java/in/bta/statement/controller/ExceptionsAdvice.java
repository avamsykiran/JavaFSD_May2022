package in.bta.statement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.bta.statement.exceptions.StatementException;

@RestControllerAdvice
public class ExceptionsAdvice {

	Logger logger;
	
	public ExceptionsAdvice() {
		logger=LoggerFactory.getLogger(this.getClass());
	} 
	
	@ExceptionHandler(StatementException.class)
	public ResponseEntity<String> handleStatementException(StatementException exception){
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledException(Exception exception){
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>("Internal Server Issue", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
