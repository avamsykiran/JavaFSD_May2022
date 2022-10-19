package in.tp.is.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.tp.is.entity.AccountHolder;
import in.tp.is.entity.StatementUser;
import in.tp.is.exceptions.InvalidAccountHolderException;
import in.tp.is.model.JwtToken;
import in.tp.is.security.JwtTokenUtil;
import in.tp.is.service.AccountHolderService;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AccountHolderService ahService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtToken> login(@RequestBody StatementUser user) throws Exception{
		authenticate(user.getUsername(), user.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		JwtToken token = new JwtToken(jwtTokenUtil.generateToken(userDetails));
		return ResponseEntity.ok(token);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<AccountHolder> add(@RequestBody @Valid AccountHolder ah,BindingResult bindingResult) throws InvalidAccountHolderException{
		
		if(bindingResult.hasErrors()) {
			throw new InvalidAccountHolderException(bindingResult.getAllErrors().stream().
					map(e->e.getDefaultMessage()).reduce((m1,m2)->m1+","+m2).orElse("") + "\n" + ah.toString());
		}
		
		return new ResponseEntity<>(ahService.save(ah),HttpStatus.CREATED);
	}
}
