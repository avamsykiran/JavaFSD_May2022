package in.tp.is.service;

import java.util.List;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderService {
	List<AccountHolder> findAll();
	AccountHolder findById(Long ahId);
	AccountHolder findByMobile(String mobile);
	AccountHolder findByMailId(String mailId);
	AccountHolder save(AccountHolder ah);
	boolean exists(Long ahId);
}
