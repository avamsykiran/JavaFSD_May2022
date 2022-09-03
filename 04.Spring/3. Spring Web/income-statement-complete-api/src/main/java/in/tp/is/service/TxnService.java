package in.tp.is.service;

import java.util.List;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;

public interface TxnService {
	Txn	add(Txn txn) throws InvalidTxnException,OperationFailedException;
	Txn save(Txn txn) throws InvalidTxnException,OperationFailedException;
	void deleteById(long txnId) throws OperationFailedException;
	List<Txn> getAllByHolder(Long ahId) throws OperationFailedException;
	Txn getById(long txnId) throws OperationFailedException;
	double getTotalValue(List<Txn> txns,TxnType type);
}
