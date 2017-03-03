package in.co.mmbf.services.data.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Collateral implements Serializable {

	private static final long serialVersionUID = 5607580390902334715L;

	@Id
	private Integer code;

	@Column(length = 20)
	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name="COLLATERAL_TYPE", nullable=false, updatable=false)
	private CollateralType collateralType;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CollateralType getCollateralType() {
		return collateralType;
	}

	public void setCollateralType(CollateralType collateralType) {
		this.collateralType = collateralType;
	}
}
