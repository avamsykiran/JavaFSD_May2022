package in.tp.incomestatement.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import in.tp.incomestatement.exception.OperationFailedException;
import in.tp.incomestatement.model.Txn;

public class TxnDAOMongoDbImpl implements TxnDAO {

	@Override
	public Txn add(Txn txn) throws OperationFailedException {
		try {
			MongoCollection<Txn> col = MongoDBProvider.getInstance().getDB().getCollection("txns", Txn.class);
			txn.setTxnId(col.countDocuments()+1);
			col.insertOne(txn);
		} catch (IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return txn;
	}

	@Override
	public Txn save(Txn txn) throws OperationFailedException {
		try {
			MongoCollection<Txn> col = MongoDBProvider.getInstance().getDB().getCollection("txns", Txn.class);
			col.replaceOne(Filters.eq("txnId", txn.getTxnId()), txn);
		} catch (IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return txn;
	}

	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		try {
			MongoCollection<Txn> col = MongoDBProvider.getInstance().getDB().getCollection("txns", Txn.class);
			col.deleteOne(Filters.eq("txnId", txnId));
		} catch (IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
	}

	@Override
	public List<Txn> getAll() throws OperationFailedException {
		List<Txn> txns = new ArrayList<Txn>();
		try {
			MongoCollection<Txn> col = MongoDBProvider.getInstance().getDB().getCollection("txns", Txn.class);
			col.find().forEach((Consumer<Txn>) t -> txns.add(t));
		} catch (IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return txns;
	}

	@Override
	public Txn getById(long txnId) throws OperationFailedException {
		Txn txn = null;
		try {
			MongoCollection<Txn> col = MongoDBProvider.getInstance().getDB().getCollection("txns", Txn.class);
			txn = col.find(Filters.eq("txnId", txnId)).first();
		} catch (IOException e) {
			throw new OperationFailedException(e.getMessage());
		}
		return txn;
	}

}
