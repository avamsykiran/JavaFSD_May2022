package in.tp.is.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private TxnRepo txnRepo;
	
	@Transactional
	@Override
	public Txn add(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null) {
			txnRepo.save(txn);
		}
		return txn;
	}

	@Transactional
	@Override
	public Txn save(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null) {
			
			if(!txnRepo.existsById(txn.getTxnId())) {
				throw new OperationFailedException("No Such Txn Found");
			}
			
			txnRepo.save(txn);
		}
		return txn;
	}

	@Transactional
	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		if(!txnRepo.existsById(txnId)) {
			throw new OperationFailedException("No Such Txn Found");
		}
		txnRepo.deleteById(txnId);
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		return txnRepo.findAll();
	}

	@Override
	public Txn getById(long txnId) throws OperationFailedException {
		return txnRepo.findById(txnId).orElse(null);
	}

	@Override
	public double getTotalValue(List<Txn> txns, TxnType type) {		
		return txns.stream().filter(t -> t.getType()==type).mapToDouble(t -> t.getAmount()).reduce(0, (a1,a2)->a1+a2);
	}

}