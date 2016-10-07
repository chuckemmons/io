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
		
	
	protected abstract boolean evaluateStrings(CSVRecord record);
	
	
	//protected abstract boolean evaluateFloat(CSVRecord record);
	
	
	//protected abstract boolean evaluateDate(CSVRecord record);
	
	protected abstract String toStringForStrings();
	
	
	protected abstract String toStringForFloat();
	
	
	protected abstract String toStringForDate();
	
	
	@Override
	public String toString() {
		if (stringValues != null) {
			return toStringForStrings();
		}
		/*if (dateValue != null) {
			return evaluateDate(record);
		}
		if (floatValue != null) {
			return evaluateFloat(record);
		}*/
		// to make the compiler happy...
		return null;
	}
	
	@Override
	public boolean evaluate(CSVRecord record) {
		if (stringValues != null) {
			return evaluateStrings(record);
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

}
