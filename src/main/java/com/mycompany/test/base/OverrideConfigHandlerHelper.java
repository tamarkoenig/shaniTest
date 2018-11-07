package com.mycompany.test.base;

public class OverrideConfigHandlerHelper {
	
	private boolean useLocalDb = false;
	
	public void setUseLocalDb(boolean useLocalDb) {
		this.useLocalDb = useLocalDb;
	}
	
	public boolean isUseLocalDb() {
		return useLocalDb;
	}
	
}
