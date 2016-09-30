package com.cee.file.csv.criteria.condition;

import java.util.Collection;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public abstract class MultiValueCondition extends BaseCondition implements Logical {

	protected Collection<String> stringValues;
	
	protected MultiValueCondition(String columnName, Collection<String> stringValues) {
		super(columnName);
		this.stringValues = stringValues;
	}
	
	@Override
	public boolean evaluate(CSVRecord record) {
		if (stringValues != null) {
			return evaluateString(record);
		}
		/*if (dateValue != null) {
			return evaluateDate(record);
		}
		if (floatValue != null) {
			return evaluateFloat(record);
		}*/
		// to make the compiler happy...
		return false;
	}
	
	
	protected abstract boolean evaluateString(CSVRecord record);
	
	
	//protected abstract boolean evaluateFloat(CSVRecord record);
	
	
	//protected abstract boolean evaluateDate(CSVRecord record);

}
