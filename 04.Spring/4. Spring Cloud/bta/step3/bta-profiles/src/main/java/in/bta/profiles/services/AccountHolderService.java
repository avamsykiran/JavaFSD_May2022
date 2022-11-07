package in.bta.profiles.services;

import java.util.List;

import in.bta.profiles.entities.AccountHolder;
import in.bta.profiles.exceptions.AccountHolderException;

public interface AccountHolderService {
	AccountHolder add(AccountHolder ah) throws AccountHolderException;
	AccountHolder getById(Long ahId);
	List<AccountHolder> getAll();
	boolean existsById(Long ahId);	
}
