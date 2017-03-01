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
	private int maxLiveLoans;

	@Column(scale=10, precision=2)
	private BigDecimal max;

	@Column(nullable = false)
	private boolean active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxLiveLoans() {
		return maxLiveLoans;
	}

	public void setMaxLiveLoans(int maxLiveLoans) {
		this.maxLiveLoans = maxLiveLoans;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
