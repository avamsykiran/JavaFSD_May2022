package in.bta.txns.services;

import java.time.LocalDate;
import java.util.List;

import in.bta.txns.entities.Txn;
import in.bta.txns.exceptions.AccountHolderException;
import in.bta.txns.exceptions.TxnException;

public interface TxnService {
	double getBalance(Long ahId) throws AccountHolderException;
	List<Txn> getPeriodicTxnsByAhId(Long ahId,LocalDate start,LocalDate end) throws AccountHolderException;
	Txn getById(Long txnId);
	Txn add(Txn txn) throws AccountHolderException,TxnException;
	Txn update(Txn txn) throws AccountHolderException,TxnException;
	void deleteById(Long txnId) throws TxnException;
}
