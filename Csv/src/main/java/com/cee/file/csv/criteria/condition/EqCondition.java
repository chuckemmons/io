package com.cee.file.csv.criteria.condition;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class EqCondition extends BaseCondition implements Logical {
	
	private String columnName;
	private String value;
	
	public EqCondition(String columnName, String value) {
		super(columnName, value);
	}
	
	@SuppressWarnings("rawtypes")
	public EqCondition(Enum columnName, String value) {
		super(columnName.toString(), value);
	}
	
	@Override
	public boolean isTrue(CSVRecord record) {
		return value.equals(record.getSingleValueFor(columnName));
	}
}
