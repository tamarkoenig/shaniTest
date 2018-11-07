package com.mycompany.test.base.ro;

import java.io.Serializable;

public abstract class BaseRO implements Serializable {
	// ------------------------ Constants -----------------------
	private static final long serialVersionUID = 1L;

	// ------------------------ Fields --------------------------
	private long id;

	private long creationTime;

	// ------------------------ Public methods ------------------
	// ------------------------ Constructors --------------------
	public BaseRO() {

	}

	public BaseRO(long id) {
		this.id = id;
	}

	// ------------------------ Field's handlers ----------------
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}

	// ------------------------ Other public methods ------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (creationTime ^ (creationTime >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
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
		BaseRO other = (BaseRO) obj;
		if (creationTime != other.creationTime)
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	// ------------------------ Private methods -----------------
}
