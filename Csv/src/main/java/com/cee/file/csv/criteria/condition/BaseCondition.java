package com.cee.file.csv.criteria.condition;

import com.cee.file.csv.CSVRecord;

public abstract class BaseCondition {
	protected String columnName;
	protected String value;
	
	protected BaseCondition(String columnName, String value) {
		this.columnName = columnName;
		this.value = value;
	}
	
	public abstract boolean isTrue(CSVRecord record);
	
	public boolean isFalse(CSVRecord record) {
		return !isTrue(record);
	}
	
	
}
