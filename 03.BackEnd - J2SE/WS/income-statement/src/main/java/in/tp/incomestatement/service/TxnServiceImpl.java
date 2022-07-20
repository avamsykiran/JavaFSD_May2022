package in.tp.incomestatement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import in.tp.incomestatement.dao.TxnDAO;
import in.tp.incomestatement.dao.TxnDAOJdbcImpl;
import in.tp.incomestatement.dao.TxnDAOMongoDbImpl;
import in.tp.incomestatement.exception.InvalidTxnException;
import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;
import in.tp.incomestatement.model.TxnType;

public class TxnServiceImpl implements TxnService {

	private TxnDAO txnDao;
	
	public TxnServiceImpl() throws OperationFailedException {
		//this.txnDao=new TxnDAOImpl();
		//this.txnDao=new TxnDAOJdbcImpl();
		this.txnDao=new TxnDAOMongoDbImpl();
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
	public Txn add(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null && isValid(txn)) {
			txnDao.add(txn);
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws InvalidTxnException, OperationFailedException {
		if(txn!=null && isValid(txn)) {
			txnDao.save(txn);
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		txnDao.deleteById(txnId);
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		return txnDao.getAll();
	}

	@Override
	public Txn getById(long txnId) throws OperationFailedException {
		return txnDao.getById(txnId);
	}

	@Override
	public double getTotalValue(List<Txn> txns, TxnType type) {
		/*
		 * double totalValue=0;
		 * 
		 * for(Txn t : txns) { if(t.getType()==type) { totalValue+=t.getAmount(); } }
		 * 
		 * return totalValue;
		 */
		
		return txns.stream().filter(t -> t.getType()==type).mapToDouble(t -> t.getAmount()).reduce(0, (a1,a2)->a1+a2);
	}

}
