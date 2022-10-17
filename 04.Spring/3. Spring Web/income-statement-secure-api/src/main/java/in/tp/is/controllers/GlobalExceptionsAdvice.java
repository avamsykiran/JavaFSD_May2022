package in.tp.is.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.tp.is.exceptions.InvalidAccountHolderException;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;

@RestControllerAdvice
public class GlobalExceptionsAdvice {

	Logger logger ;
	
	public GlobalExceptionsAdvice() {
		this.logger = LoggerFactory.getLogger(this.getClass());
	}
	
	@ExceptionHandler({InvalidTxnException.class,InvalidAccountHolderException.class,OperationFailedException.class})
	public ResponseEntity<String> handleUserDefiendException(Throwable err){
		logger.error(err.getMessage(), err);
		return new ResponseEntity<>(err.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleTheUnHanledException(Throwable err){
		logger.error(err.getMessage(), err);
		return new ResponseEntity<>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
