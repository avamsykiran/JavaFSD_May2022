package in.tp.incomestatement.service;

import java.util.List;

import in.tp.incomestatement.exception.InvalidTxnException;
import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;

public interface TxnService {
	Txn	add(Txn txn) throws InvalidTxnException,OperationFailedException;
	Txn save(Txn txn) throws InvalidTxnException,OperationFailedException;
	void deleteById(long txnId) throws OperationFailedException;
	List<Txn> getAll() throws OperationFailedException;
	Txn getById(long txnId) throws OperationFailedException;
	double getTotalValue(List<Txn> txns,TxnType type);
}
