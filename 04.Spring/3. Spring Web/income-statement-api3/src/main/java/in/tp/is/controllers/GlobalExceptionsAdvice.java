package in.tp.is.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.tp.is.exceptions.InvalidAccountHolderException;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;

@RestControllerAdvice
public class GlobalExceptionsAdvice {

	@ExceptionHandler({InvalidTxnException.class,InvalidAccountHolderException.class,OperationFailedException.class})
	public ResponseEntity<String> handleUserDefiendException(Throwable err){
		return new ResponseEntity<String>(err.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleTheUnHanledException(Throwable err){
		return new ResponseEntity<String>(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
