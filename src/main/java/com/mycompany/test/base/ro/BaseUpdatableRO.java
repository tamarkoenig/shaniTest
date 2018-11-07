package com.mycompany.test.base.ro;

public abstract class BaseUpdatableRO extends BaseRO {

	// ------------------------ Constants -----------------------
	private static final long serialVersionUID = 1L;

	// ------------------------ Fields --------------------------
	private long lastUpdateTime;

	// ------------------------ Public methods ------------------
	// ------------------------ Constructors --------------------
	// ------------------------ Field's handlers ----------------
	public long getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(long lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	// ------------------------ Other public methods ------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (lastUpdateTime ^ (lastUpdateTime >>> 32));
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
		BaseUpdatableRO other = (BaseUpdatableRO) obj;
		if (lastUpdateTime != other.lastUpdateTime)
			return false;
		return true;
	}
	// ------------------------ Private methods -----------------
}
