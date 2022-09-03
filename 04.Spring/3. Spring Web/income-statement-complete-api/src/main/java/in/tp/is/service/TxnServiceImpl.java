package in.tp.is.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.tp.is.entity.AccountHolder;
import in.tp.is.entity.Txn;
import in.tp.is.entity.TxnType;
import in.tp.is.exceptions.InvalidTxnException;
import in.tp.is.exceptions.OperationFailedException;
import in.tp.is.repo.TxnRepo;

@Service
public class TxnServiceImpl implements TxnService {

	@Autowired
	private AccountHolderService ahService;

	@Autowired
	private TxnRepo txnRepo;

	@Transactional
	@Override
	public Txn add(Txn txn) throws InvalidTxnException, OperationFailedException {
		if (txn == null || txn.getHolder() == null || txn.getHolder().getAhId() == null
				|| !ahService.exists(txn.getHolder().getAhId())) {
			throw new OperationFailedException("Txn can not be added to non existing Account Holder");
		}
		AccountHolder holder = ahService.findById(txn.getHolder().getAhId());
		double diffAmt = txn.getType() == TxnType.DEBIT ? -txn.getAmount() : txn.getAmount();
		holder.setCurrentBalance(holder.getCurrentBalance() + diffAmt);
		txn.setHolder(holder);
		txnRepo.save(txn);
		ahService.save(holder);
		return txn;
	}

	@Transactional
	@Override
	public Txn save(Txn txn) throws InvalidTxnException, OperationFailedException {
		if (txn != null || !txnRepo.existsById(txn.getTxnId())) {
			throw new OperationFailedException("No Such Txn Found");
		}
		Txn oldTxn = getById(txn.getTxnId());
		
		AccountHolder holder = ahService.findById(txn.getHolder().getAhId());
		double oldDiffAmt = oldTxn.getType() == TxnType.DEBIT ? -oldTxn.getAmount() : oldTxn.getAmount();
		double diffAmt = (txn.getType() == TxnType.DEBIT ? -txn.getAmount() : txn.getAmount())-oldDiffAmt;
		holder.setCurrentBalance(holder.getCurrentBalance() + diffAmt);
		oldTxn=null;
		txn.setHolder(holder);
		txnRepo.save(txn);
		ahService.save(holder);
		return txn;
	}

	@Transactional
	@Override
	public void deleteById(long txnId) throws OperationFailedException {
		if (!txnRepo.existsById(txnId)) {
			throw new OperationFailedException("No Such Txn Found");
		}
		
		Txn oldTxn = getById(txnId);
		
		AccountHolder holder = oldTxn.getHolder();
		double oldDiffAmt = oldTxn.getType() == TxnType.DEBIT ? -oldTxn.getAmount() : oldTxn.getAmount();
		holder.setCurrentBalance(holder.getCurrentBalance() - oldDiffAmt);
		oldTxn=null;
		ahService.save(holder);
		
		txnRepo.deleteById(txnId);
	}

	@Override
	public List<Txn> getAllByHolder(Long ahId) throws OperationFailedException {
		return txnRepo.findAllByAccountHolderId(ahId);
	}

	@Override
	public Txn getById(long txnId) throws OperationFailedException {
		return txnRepo.findById(txnId).orElse(null);
	}

	@Override
	public double getTotalValue(List<Txn> txns, TxnType type) {
		return txns.stream().filter(t -> t.getType() == type).mapToDouble(t -> t.getAmount()).reduce(0,
				(a1, a2) -> a1 + a2);
	}

}