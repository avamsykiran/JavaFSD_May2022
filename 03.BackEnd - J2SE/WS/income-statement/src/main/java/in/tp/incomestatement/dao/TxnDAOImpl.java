package in.tp.incomestatement.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;

public class TxnDAOImpl implements TxnDAO {

	public static final String DATA_FILE = "./txns.data";
	
	private Map<Long,Txn> txns;
	
	public TxnDAOImpl() throws OperationFailedException {
		if(Files.exists(Paths.get(DATA_FILE))) {
			try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(DATA_FILE))){
				this.txns = (Map<Long, Txn>) objInput.readObject();
			} catch (IOException | ClassNotFoundException e) {
				throw new OperationFailedException("Unable to open the data file");
			}
		}else {
			this.txns=new TreeMap<>();	
		}
	}
	
	private void writeData() throws OperationFailedException {
		try(ObjectOutputStream objOutput=new ObjectOutputStream(new FileOutputStream(DATA_FILE))){
			objOutput.writeObject(txns);
		} catch (IOException e) {
			throw new OperationFailedException("Unable to save the data file");
		}
	}
	
	private long nextTxnId() {
		long txnId=1;
		if(!txns.isEmpty()) {
			txnId = (Long)((TreeMap)txns).lastKey() + 1;
		}
		return txnId;
	}
	
	@Override
	public Txn add(Txn txn) throws OperationFailedException {
		if(txn!=null) {
			long txnId = nextTxnId();
			txn.setTxnId(txnId);
			txns.put(txnId, txn);
			writeData();
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws OperationFailedException {
		if(txn!=null) {
			txns.replace(txn.getTxnId(), txn);
			writeData();
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		txns.remove(txnId);
		writeData();
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
