package in.tp.is.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.tp.is.entity.StatementUser;
import in.tp.is.repo.StatementUserRepo;

@Service
public class UserDeatilsServiceImpl implements UserDetailsService{

	@Autowired
	private StatementUserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user =userRepo.findByUserName(username).orElse(null);
		
		if(user==null) {
			throw new UsernameNotFoundException("User with the usernameis not found");
		}
		
		return user;
	}

	public StatementUser createUser(StatementUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return user;
	}
}
