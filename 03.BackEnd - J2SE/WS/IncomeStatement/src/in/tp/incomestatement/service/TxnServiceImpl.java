package in.tp.incomestatement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.tp.incomestatement.dao.TxnDAO;
import in.tp.incomestatement.dao.TxnDAOImpl;
import in.tp.incomestatement.exception.InvalidTxnException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;

public class TxnServiceImpl implements TxnService {

	private TxnDAO txnDao;
	
	public TxnServiceImpl() {
		this.txnDao=new TxnDAOImpl();
	}
	
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
	public Txn add(Txn txn) throws InvalidTxnException {
		if(txn!=null && isValid(txn)) {
			txnDao.add(txn);
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws InvalidTxnException {
		if(txn!=null && isValid(txn)) {
			txnDao.save(txn);
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) {
		txnDao.deleteById(txnId);
	}

	@Override
	public List<Txn> getAll() {
		return txnDao.getAll();
	}

	@Override
	public Txn getById(long txnId) {
		return txnDao.getById(txnId);
	}

	@Override
	public double getTotalValue(List<Txn> txns, TxnType type) {
		double totalValue=0;
		
		for(Txn t : txns) {
			if(t.getType()==type) {
				totalValue+=t.getAmount();
			}
		}
		
		return totalValue;
	}

}
