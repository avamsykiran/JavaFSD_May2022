package in.bta.statement.services;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bta.statement.exceptions.StatementException;
import in.bta.statement.models.AccountHolder;
import in.bta.statement.models.Statement;
import in.bta.statement.models.Txn;
import in.bta.statement.models.TxnType;

@Service
public class StatementServiceImpl implements StatementService {
	
	@Autowired
	private ProfilesClient profilesClient;
	
	@Autowired
	private TxnsClient txnsClient;

	private double computeTotal(List<Txn> txns,TxnType type) {
		return txns.stream().filter(t->t.getType()==type).map(Txn::getAmount).reduce((s1,s2)->s1+s2).orElse(0.0);
	}
	
	@Override
	public Statement getStatement(long ahid, LocalDate start, LocalDate end) throws StatementException {
		if(!profilesClient.checkAccountHolderExists(ahid))
			throw new StatementException("Account does not exists");
		
		AccountHolder ah = profilesClient.getAccountHolder(ahid);
		List<Txn> txns = txnsClient.getTxns(ahid, start, end);
		ah.setCurrentBalance(txnsClient.getBalance(ahid));
		double totalCredit=computeTotal(txns, TxnType.CREDIT);
		double totalDebit=computeTotal(txns, TxnType.DEBIT);
		double statementBalance = totalCredit-totalDebit;
		
		return new Statement(ah,new TreeSet<>(txns), totalCredit, totalDebit, statementBalance, start, end);
	}

}
