package de.tekup.rst.entities;

public enum TableType {
	
	OUTSIDE("Outside"), INSIDE_SMOKER("Inside smoker area"), INSIDE_NO_SMOKER("Inside no smoker area");
	
	private String displayName;
	
	private TableType(String name) {
		this.displayName = name;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
