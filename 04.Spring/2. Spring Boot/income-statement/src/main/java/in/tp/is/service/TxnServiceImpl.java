package in.tp.is.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	private boolean isValid(Txn txn) throws InvalidTxnException {
		
		List<String> errMsgs=new ArrayList<String>();
		
		if(txn.getDesp()==null || txn.getDesp().isBlank())
			errMsgs.add("Txn Description can not be blank");
		
		if(txn.getAmount()<0)
			errMsgs.add("Txn amount cna not be negative");
	
		if(txn.getTxnDate()==null ||txn.getTxnDate().isAfter(LocalDate.now()))
			errMsgs.add("Txn Date can not be a future date");
		
		if(txn.getType()==null)
			errMsgs.add("Txn Type is a mandatory field");
		
		if(!errMsgs.isEmpty()) {
			throw new InvalidTxnException(errMsgs.toString());
		}
		
		return errMsgs.isEmpty();
	}
	
	@Override
	public Txn add(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null && isValid(txn)) {
			txnRepo.save(txn);
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null && isValid(txn)) {
			
			if(!txnRepo.existsById(txn.getTxnId())) {
				throw new OperationFailedException("No Such Txn Found");
			}
			
			txnRepo.save(txn);
		}
		return txn;
	}

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