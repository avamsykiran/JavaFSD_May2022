package in.tp.is.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.tp.is.entity.AccountHolder;
import in.tp.is.entity.Txn;
import in.tp.is.exceptions.InvalidAccountHolderException;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.service.AccountHolderService;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountHolderController {

	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private TxnsController txnsCtrl;
	
	@GetMapping
	public ResponseEntity<List<AccountHolder>> sendAccounts(){
		//return new ResponseEntity<>(ahService.findAll(),HttpStatus.OK);
		return ResponseEntity.ok(ahService.findAll());
	}
	
	@GetMapping("/{ahId}")
	public ResponseEntity<AccountHolder> sendAccount(@PathVariable("ahId")Long ahId){
		AccountHolder holder = ahService.findById(ahId);
		//return holder!=null? new ResponseEntity<>(holder,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return holder!=null? ResponseEntity.ok(holder) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/userName/{unm}")
	public ResponseEntity<AccountHolder> sendAccountByUserName(@PathVariable("unm")String unm){
		AccountHolder holder = ahService.getByUserName(unm);
		return holder!=null? ResponseEntity.ok(holder) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{ahId}/txns")
	public ResponseEntity<List<Txn>> sendTxns(@PathVariable("ahId")Long ahId) throws OperationFailedException{
		return txnsCtrl.sendTxns(ahId);
	}
	
	@PutMapping
	public ResponseEntity<AccountHolder> update(@RequestBody @Valid AccountHolder ah,BindingResult bindingResult) throws InvalidAccountHolderException, OperationFailedException{
		
		if(!ahService.exists(ah.getAhId())){
			throw new OperationFailedException("No Such Record Found To Update");
		}
		
		if(bindingResult.hasErrors()) {
			throw new InvalidAccountHolderException(bindingResult.getAllErrors().stream().
					map(e->e.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse(""));
		}
		
		return new ResponseEntity<>(ahService.save(ah),HttpStatus.ACCEPTED);
	}
}
