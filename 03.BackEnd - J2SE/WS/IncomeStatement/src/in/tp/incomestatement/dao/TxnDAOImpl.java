package in.tp.incomestatement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import in.tp.incomestatement.model.Txn;

public class TxnDAOImpl implements TxnDAO {

	private Map<Long,Txn> txns;
	
	public TxnDAOImpl() {
		this.txns=new TreeMap<>();
	}
	
	private long nextTxnId() {
		long txnId=1;
		if(!txns.isEmpty()) {
			txnId = (Long)((TreeMap)txns).lastKey() + 1;
		}
		return txnId;
	}
	
	@Override
	public Txn add(Txn txn) {
		if(txn!=null) {
			long txnId = nextTxnId();
			txn.setTxnId(txnId);
			txns.put(txnId, txn);
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) {
		if(txn!=null) {
			txns.replace(txn.getTxnId(), txn);
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) {
		txns.remove(txnId);
	}

	@Override
	public List<Txn> getAll() {
		return new ArrayList<Txn>(txns.values());
	}

	@Override
	public Txn getById(long txnId) {
		return txns.get(txnId);
	}

}
