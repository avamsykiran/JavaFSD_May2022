package in.bta.statement.models;

import java.time.LocalDate;

public class Txn implements Comparable<Txn> {

	private Long txnId;
	private String header;
	private LocalDate txnDate;
	private TxnType type;
	private Double amount;
		
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String header, LocalDate txnDate, TxnType type, Double amount) {
		super();
		this.txnId = txnId;
		this.header = header;
		this.txnDate = txnDate;
		this.type = type;
		this.amount = amount;
	}


	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(Txn t) {
		return txnId==null?1:txnId.compareTo(t.txnId);
	}
	
	
}
