package in.tp.is.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.is.entity.AccountHolder;
import in.tp.is.repo.AccountHolderRepo;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {

	@Autowired
	private AccountHolderRepo ahRepo;
	
	@Override
	public List<AccountHolder> findAll() {
		return ahRepo.findAll();
	}

	@Override
	public AccountHolder findById(Long ahId) {
		return ahRepo.findById(ahId).orElse(null);
	}

	@Override
	public AccountHolder save(AccountHolder ah) {
		return ahRepo.save(ah);
	}

	@Override
	public boolean exists(Long ahId) {
		return ahRepo.existsById(ahId);
	}

	@Override
	public AccountHolder findByMobile(String mobile) {
		return ahRepo.findByMobile(mobile).orElse(null);
	}

	@Override
	public AccountHolder findByMailId(String mailId) {
		return ahRepo.findByMailId(mailId).orElse(null);
	}

}
