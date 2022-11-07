package in.bta.txns.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.bta.txns.exceptions.AccountHolderException;
import in.bta.txns.exceptions.TxnException;

@RestControllerAdvice
public class ExceptionsAdvice {

	Logger logger;
	
	public ExceptionsAdvice() {
		logger=LoggerFactory.getLogger(this.getClass());
	} 
	
	@ExceptionHandler(AccountHolderException.class)
	public ResponseEntity<String> handleAccountHolderException(AccountHolderException exception){
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TxnException.class)
	public ResponseEntity<String> handleTxnException(TxnException exception){
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleUnhandledException(Exception exception){
		logger.error(exception.getMessage(), exception);
		return new ResponseEntity<String>("Internal Server Issue", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
