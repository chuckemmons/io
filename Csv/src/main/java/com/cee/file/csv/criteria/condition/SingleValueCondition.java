package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.cee.file.csv.CSVRecord;


public abstract class SingleValueCondition extends BaseCondition {	
	protected String stringValue;
	protected Float floatValue;
	
	protected Date dateValue;
	
	
	protected SingleValueCondition(String columnName, String value) {
		super(columnName);
		this.stringValue = value;
	}
	
	protected SingleValueCondition(String columnName, float value) {
		super(columnName);
		this.floatValue = value;
	}	
	
	protected SingleValueCondition(String columnName, Date value, DateFormat dateFormat) {
		super(columnName, dateFormat);
		this.dateValue = value;
	}
	
	protected SingleValueCondition(String columnName, Date value, DateFormat dateFormat, int dateFieldToInclude) {
		super(columnName, dateFormat, dateFieldToInclude);
		// truncate here so don't have to do it everywhere else;
		this.dateValue = DateUtils.truncate(value, dateFieldToInclude); 
	}
	
	
	protected abstract boolean evaluateString(CSVRecord record);
	
	
	protected abstract boolean evaluateFloat(CSVRecord record);
	
	
	protected abstract boolean evaluateDate(CSVRecord record);	

	
	public boolean evaluate(CSVRecord record) {
		if (stringValue != null) {
			return evaluateString(record);
		}
		if (dateValue != null) {
			return evaluateDate(record);
		}
		if (floatValue != null) {
			return evaluateFloat(record);
		}
		// to make the compiler happy...
		return false;
	}
}
