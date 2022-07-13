package in.tp.incomestatement.dao;

import java.util.List;

import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;

public interface TxnDAO {
	Txn add(Txn txn) throws OperationFailedException;
	Txn save(Txn txn) throws OperationFailedException;
	void deleteById(long txnId) throws OperationFailedException;
	List<Txn> getAll() throws OperationFailedException;
	Txn getById(long txnId) throws OperationFailedException;
}
