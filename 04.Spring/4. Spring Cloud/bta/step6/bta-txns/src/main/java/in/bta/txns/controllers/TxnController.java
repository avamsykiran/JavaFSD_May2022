package in.bta.txns.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bta.txns.entities.Txn;
import in.bta.txns.exceptions.AccountHolderException;
import in.bta.txns.exceptions.TxnException;
import in.bta.txns.exceptions.UnreachableException;
import in.bta.txns.services.TxnService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/")
public class TxnController {

	@Autowired
	private TxnService txnService;
	
	@GetMapping("/{ahId}/balance")
	public ResponseEntity<Double> getBalance(@PathVariable("ahId")Long ahId) throws AccountHolderException{
		return ResponseEntity.ok(txnService.getBalance(ahId));
	}
	
	@GetMapping("/{ahId}/{start}/{end}")
	public ResponseEntity<List<Txn>> getTxns(
			@PathVariable("ahId")Long ahId,
			@PathVariable("start") @DateTimeFormat(iso=ISO.DATE)LocalDate start,
			@PathVariable("end") @DateTimeFormat(iso=ISO.DATE)LocalDate end) throws AccountHolderException{
		return ResponseEntity.ok(txnService.getPeriodicTxnsByAhId(ahId, start, end));
	}
	
	@PostMapping
	@CircuitBreaker(name="cb1",fallbackMethod = "profilesFallBack")
	public ResponseEntity<Txn> addTxn(@RequestBody @Valid Txn txn,BindingResult results) throws TxnException, AccountHolderException{
		return saveTxn(txn,results,"ADD");
	}
	
	@PutMapping
	@CircuitBreaker(name="cb2",fallbackMethod = "profilesFallBack")
	public ResponseEntity<Txn> updateTxn(@RequestBody @Valid Txn txn,BindingResult results) throws TxnException, AccountHolderException{
		return saveTxn(txn,results,"UPDATE");
	}

	public ResponseEntity<Txn> profilesFallBack(@RequestBody @Valid Txn txn,BindingResult results,Throwable t) throws TxnException, AccountHolderException{
		throw new UnreachableException("Seems like a few serivce components are not reachable, please retry later");
	}
	
	private ResponseEntity<Txn> saveTxn(Txn txn, BindingResult results, String operation) throws TxnException, AccountHolderException {
		if(results.hasErrors())
			throw new TxnException(results.getAllErrors().stream()
					.map(err->err.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse(null));
	
		ResponseEntity<Txn> re = null;
		if(operation.equals("ADD"))
			re = new ResponseEntity<Txn>(txnService.add(txn),HttpStatus.CREATED);
		else
			re = new ResponseEntity<Txn>(txnService.update(txn),HttpStatus.ACCEPTED);
		return re;
	}
	
	
}
