package in.bta.profiles.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bta.profiles.entities.AccountHolder;
import in.bta.profiles.exceptions.AccountHolderException;
import in.bta.profiles.services.AccountHolderService;

@RestController
@RequestMapping("/")
public class ProfilesController {

	@Autowired
	private AccountHolderService ahService;
	
	@GetMapping
	public ResponseEntity<List<AccountHolder>> getAll(){
		return ResponseEntity.ok(ahService.getAll());
	}
	
	@GetMapping("/{ahId}")
	public ResponseEntity<AccountHolder> getById(@PathVariable("ahId")Long ahId){
		AccountHolder ah = ahService.getById(ahId);
		return ah!=null?ResponseEntity.ok(ah):new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{ahId}/exists")
	public ResponseEntity<Boolean> existsById(@PathVariable("ahId")Long ahId){
		return ResponseEntity.ok(ahService.existsById(ahId));
	}
	
	@PostMapping
	public ResponseEntity<AccountHolder> add(
			@RequestBody @Valid AccountHolder ah,BindingResult bindingResult) throws AccountHolderException{
		
		if(bindingResult.hasErrors()) {
			throw new AccountHolderException(bindingResult.getAllErrors().stream()
					.map(err -> err.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse(null));
		}
		
		return new ResponseEntity(ahService.add(ah),HttpStatus.CREATED);
	}
}
