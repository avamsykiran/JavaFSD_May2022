package in.tp.incomestatement.service;

import java.util.List;

import in.tp.incomestatement.exception.InvalidTxnException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;

public interface TxnService {
	Txn	add(Txn txn) throws InvalidTxnException;
	Txn save(Txn txn) throws InvalidTxnException;
	void deleteById(long txnId);
	List<Txn> getAll();
	Txn getById(long txnId);
	double getTotalValue(List<Txn> txns,TxnType type);
}
