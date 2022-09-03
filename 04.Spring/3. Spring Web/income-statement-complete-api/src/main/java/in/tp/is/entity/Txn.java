package in.tp.is.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ah_txns")
public class Txn implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="txnid")
	private Long txnId;
	@NotBlank(message = "Description can not be blank")
	@Column(name="desp",nullable = false)
	private String desp;
	@NotNull(message = "Amount can not be skipped")
	@PositiveOrZero(message = "Amount can not be negative")
	@Column(name="amount",nullable = false)
	private Double amount;
	@NotNull(message = "Transaction Date can not be skipped")
	@PastOrPresent(message = "Transaction Date can not be of future")
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="txndate",nullable = false)
	private LocalDate txnDate;
	@NotNull(message = "Transaction Type can not be skipped")
	@Column(name="type",nullable = false)
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	private AccountHolder holder;
	
	public Txn() {
		// TODO Auto-generated constructor stub
	}

	public Txn(Long txnId, String desp, Double amount, LocalDate txnDate, TxnType type,AccountHolder holder) {
		super();
		this.txnId = txnId;
		this.desp = desp;
		this.amount = amount;
		this.txnDate = txnDate;
		this.type = type;
		this.holder=holder;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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
	
	public AccountHolder getHolder() {
		return holder;
	}

	public void setHolder(AccountHolder holder) {
		this.holder = holder;
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