package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class LtCondition extends SingleValueCondition implements Logical {

	protected LtCondition(String columnName, float value) {
		super(columnName, value);
	}
	
	protected LtCondition(String columnName, Date value, DateFormat format) {
		super(columnName, value, format);
	}
	
	protected LtCondition(String columnName, Date value, DateFormat format, int dateFieldToInclude) {
		super(columnName, value, format, dateFieldToInclude);
	}	
	

	@Override
	protected boolean evaluateString(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {			
			if (strValue.compareTo(stringValue) < 0) {
				return true;
			}
		}
		
		return false;
	}
	

	@Override
	protected boolean evaluateFloat(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {
			Float recordValue = getFloatFromRecordValue(strValue);
			if (recordValue < floatValue) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	protected boolean evaluateDate(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {
			Date recordDate = getDateFromRecordValue(strValue);
			
			if (dateValue.before(recordDate)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	protected String toStringForString() {
		return columnName + " < " + stringValue;
	}

	@Override
	protected String toStringForDate() {
		return columnName + " is before " + dateValue;
	}

	@Override
	protected String toStringForFloat() {
		return columnName + " < " + floatValue;
	}

}
