package in.tp.jpahibdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assets")
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetId;
	private String config;
	
	@OneToOne
	@JoinColumn
	private Employee owner;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(Long assetId, String config, Employee owner) {
		super();
		this.assetId = assetId;
		this.config = config;
		this.owner = owner;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	
	
}
