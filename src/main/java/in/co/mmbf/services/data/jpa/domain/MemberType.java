package in.co.mmbf.services.data.jpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MemberType implements Serializable {

	private static final long serialVersionUID = -6964665559628221232L;

	@Id
	private String name;

	@Column(length = 3)
	private Integer maxLiveLoans;

	@Column(precision=10, scale=2)
	private BigDecimal maxOutstandingLimit;

	@Column(nullable = false)
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMaxLiveLoans() {
		return maxLiveLoans;
	}

	public void setMaxLiveLoans(Integer maxLiveLoans) {
		this.maxLiveLoans = maxLiveLoans;
	}

	public BigDecimal getMaxOutstandingLimit() {
		return maxOutstandingLimit;
	}

	public void setMaxOutstandingLimit(BigDecimal maxOutstandingLimit) {
		this.maxOutstandingLimit = maxOutstandingLimit;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
