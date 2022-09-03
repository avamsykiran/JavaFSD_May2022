package in.tp.is.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.is.entity.Txn;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.service.TxnService;

@RestController
@RequestMapping("/txns")
public class TxnsController {
	
	@Autowired
	private TxnService txnService;
	
	@GetMapping("/byAccount/{ahId}")
	public ResponseEntity<List<Txn>> sendTxns(@PathVariable("ahId")Long ahId) throws OperationFailedException {
		return new ResponseEntity<>(txnService.getAllByHolder(ahId), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Txn> sendTxn(@PathVariable("id") Long txnId) throws OperationFailedException {
		Txn t = txnService.getById(txnId);
		return t==null? new ResponseEntity<>(HttpStatus.NOT_FOUND):new ResponseEntity<>(t,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> doDelete(@PathVariable("id") long txnId) throws OperationFailedException {
		txnService.deleteById(txnId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping
	public ResponseEntity<Txn> doAdd(@RequestBody @Valid Txn txn,BindingResult bindingResult)
			throws InvalidTxnException, OperationFailedException {
		
		if(bindingResult.hasErrors()) {
			throw new InvalidTxnException(bindingResult.getAllErrors().stream().
					map(e->e.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse(""));
		}
		
		return new ResponseEntity<Txn>(txnService.add(txn),HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Txn> doUpdate(@RequestBody @Valid Txn txn,BindingResult bindingResult)
			throws InvalidTxnException, OperationFailedException {
		
		if(bindingResult.hasErrors()) {
			throw new InvalidTxnException(bindingResult.getAllErrors().stream().
					map(e->e.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse(""));
		}
		
		return new ResponseEntity<Txn>(txnService.save(txn),HttpStatus.ACCEPTED);
	}
	

}
