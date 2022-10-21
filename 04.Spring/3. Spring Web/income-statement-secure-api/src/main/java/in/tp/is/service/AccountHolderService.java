package in.tp.is.service;

import java.util.List;

import in.tp.is.entity.AccountHolder;

public interface AccountHolderService {
	List<AccountHolder> findAll();
	AccountHolder findById(Long ahId);
	AccountHolder getByUserName(String userName);
	AccountHolder save(AccountHolder ah);
	boolean exists(Long ahId);
}
