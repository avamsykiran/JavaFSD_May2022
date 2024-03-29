package in.tp.is.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="ahs")
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ahId;
	@NotBlank(message="full name can not be left blank")
	@Size(min=4,max=50,message = "full name is expected to be between 4 and 50 in length")
	private String fullName;
	@NotBlank(message="mobile number can not be left blank")
	@Pattern(regexp = "[1-9][0-9]{9}",message = "mobile number is a 10 digit number starting with a non-zero")
	private String mobile;
	@NotBlank(message="mail id can not be left blank")
	@Email(message="expecting a valid mail id")
	private String mailId;
	@Column(name="cb", nullable = true)
	@PositiveOrZero(message = "No negative values expected as currentBalance")
	private Double currentBalance;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn
	@JsonProperty(access = Access.WRITE_ONLY)
	private StatementUser userAccount;
	
	@Transient
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	public AccountHolder() {}
	
	public AccountHolder(Long ahId,
			@NotBlank(message = "full name can not be left blank") @Size(min = 4, max = 50, message = "full name is expected to be between 4 and 50 in length") String fullName,
			@NotBlank(message = "mobile number can not be left blank") @Pattern(regexp = "[1-9][0-9]{9}", message = "mobile number is a 10 digit number starting with a non-zero") String mobile,
			@NotBlank(message = "mail id can not be left blank") @Email(message = "expecting a valid mail id") String mailId,
			@PositiveOrZero(message = "No negative values expected as currentBalance") Double currentBalance,
			StatementUser userAccount) {
		super();
		this.ahId = ahId;
		this.fullName = fullName;
		this.mobile = mobile;
		this.mailId = mailId;
		this.currentBalance = currentBalance;
		this.userAccount = userAccount;
	}


	public Long getAhId() {
		return ahId;
	}

	public void setAhId(Long ahId) {
		this.ahId = ahId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public StatementUser getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(StatementUser userAccount) {
		this.userAccount = userAccount;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ahId == null) ? 0 : ahId.hashCode());
		result = prime * result + ((currentBalance == null) ? 0 : currentBalance.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((mailId == null) ? 0 : mailId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		AccountHolder other = (AccountHolder) obj;
		if (ahId == null) {
			if (other.ahId != null)
				return false;
		} else if (!ahId.equals(other.ahId))
			return false;
		if (currentBalance == null) {
			if (other.currentBalance != null)
				return false;
		} else if (!currentBalance.equals(other.currentBalance))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (mailId == null) {
			if (other.mailId != null)
				return false;
		} else if (!mailId.equals(other.mailId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountHolder [ahId=" + ahId + ", fullName=" + fullName + ", mobile=" + mobile + ", mailId=" + mailId
				+ ", currentBalance=" + currentBalance + "]";
	}
	
	
}
