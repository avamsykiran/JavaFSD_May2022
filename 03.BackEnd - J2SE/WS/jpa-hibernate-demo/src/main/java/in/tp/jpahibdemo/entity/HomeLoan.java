package in.tp.jpahibdemo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("home")
//@Table(name="hls")
@Table(name="hls_only")
public class HomeLoan extends GeneralPurposeLoan {

	private Double marketValue;
	
	public HomeLoan() {
		// TODO Auto-generated constructor stub
	}

	public HomeLoan(Long loanId, Double principal, Double interest, Double term,Double marketValue) {
		super(loanId, principal, interest, term);
		this.marketValue=marketValue;
	}

	public Double getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(Double marketValue) {
		this.marketValue = marketValue;
	}
	
	
}
