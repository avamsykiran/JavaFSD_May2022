package in.tp.incomestatement.dao;

import java.util.List;

import in.tp.incomestatement.model.Txn;

public interface TxnDAO {
	Txn	add(Txn txn);
	Txn save(Txn txn);
	void deleteById(long txnId);
	List<Txn> getAll();
	Txn getById(long txnId);
}
