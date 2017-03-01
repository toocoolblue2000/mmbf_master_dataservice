package in.co.mmbf.services.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CollateralGrade implements Serializable {

	private static final long serialVersionUID = 4292916079984654075L;

	@Id
	private String gradePurityCode;

	@Column(scale = 2, precision = 2)
	private Float loanPercentPerUnit;

	@Column(scale = 6, precision = 2)
	private Float addLessAmount;

	@ManyToOne(optional = false)
	@JoinColumn(name="COLLATERAL_TYPE", nullable=false, updatable=false)
	private CollateralType collateralType;

	public String getGradePurityCode() {
		return gradePurityCode;
	}

	public void setGradePurityCode(String gradeName) {
		this.gradePurityCode = gradeName;
	}

	public Float getLoanPercentPerUnit() {
		return loanPercentPerUnit;
	}

	public void setLoanPercentPerUnit(Float loanPercentPerUnit) {
		this.loanPercentPerUnit = loanPercentPerUnit;
	}

	public Float getAddLessAmount() {
		return addLessAmount;
	}

	public void setAddLessAmount(Float addLessAmount) {
		this.addLessAmount = addLessAmount;
	}

	public CollateralType getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(CollateralType collateralType) {
		this.collateralType = collateralType;
	}
}
