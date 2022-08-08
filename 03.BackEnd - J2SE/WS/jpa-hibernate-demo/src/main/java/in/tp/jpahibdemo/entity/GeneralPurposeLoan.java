package in.tp.jpahibdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity

/*@Table(name = "all_loans")
 @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "loan_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("general")*/

//@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name="gls")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="gls_only")
public class GeneralPurposeLoan {

	@Id
	private Long loanId;
	@Column(name = "p")
	private Double principal;
	@Column(name = "r")
	private Double interest;
	@Column(name = "t")
	private Double term;

	public GeneralPurposeLoan() {
		// TODO Auto-generated constructor stub
	}

	public GeneralPurposeLoan(Long loanId, Double principal, Double interest, Double term) {
		super();
		this.loanId = loanId;
		this.principal = principal;
		this.interest = interest;
		this.term = term;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getTerm() {
		return term;
	}

	public void setTerm(Double term) {
		this.term = term;
	}

}
