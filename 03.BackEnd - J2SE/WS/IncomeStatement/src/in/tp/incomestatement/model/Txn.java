package in.tp.incomestatement.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Txn implements Serializable {

	private long txnId;
	private String desp;
	private double amount;
	private LocalDate txnDate;
	private TxnType type;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(long txnId, String desp, double amount, LocalDate txnDate, TxnType type) {
		super();
		this.txnId = txnId;
		this.desp = desp;
		this.amount = amount;
		this.txnDate = txnDate;
		this.type = type;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((desp == null) ? 0 : desp.hashCode());
		result = prime * result + ((txnDate == null) ? 0 : txnDate.hashCode());
		result = prime * result + (int) (txnId ^ (txnId >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Txn other = (Txn) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (desp == null) {
			if (other.desp != null)
				return false;
		} else if (!desp.equals(other.desp))
			return false;
		if (txnDate == null) {
			if (other.txnDate != null)
				return false;
		} else if (!txnDate.equals(other.txnDate))
			return false;
		if (txnId != other.txnId)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Txn [txnId=" + txnId + ", desp=" + desp + ", amount=" + amount + ", txnDate=" + txnDate + ", type="
				+ type + "]";
	}
}
