package in.tp.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("education")
//@Table(name="els")
@Table(name="els_only")
public class EducationLoan extends GeneralPurposeLoan {

	private String qual;
	
	public EducationLoan() {
		// TODO Auto-generated constructor stub
	}

	public EducationLoan(Long loanId, Double principal, Double interest, Double term,String qual) {
		super(loanId, principal, interest, term);
		this.qual=qual;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}
	
	
}
