package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class GtCondition extends SingleValueCondition implements Logical {

	
	protected GtCondition(String columnName, float value) {
		super(columnName, value);
	}
	
	protected GtCondition(String columnName, Date value, DateFormat format) {
		super(columnName, value, format);
	}
	
	protected GtCondition(String columnName, Date value, DateFormat format, int dateFieldToInclude) {
		super(columnName, value, format, dateFieldToInclude);
	}	
	
	
	@Override
	protected boolean evaluateFloat(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {
			Float recordValue = getFloatFromRecordValue(strValue);
			if (recordValue > floatValue) {
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
			
			if (dateValue.after(recordDate)) {
				return true;
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.cee.file.csv.criteria.condition.SingleValueCondition#evaluateString(com.cee.file.csv.CSVRecord)
	 */
	@Override
	@Deprecated
	protected boolean evaluateString(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {			
			if (strValue.compareTo(stringValue) > 0) {
				return true;
			}
		}
		
		return false;
	}
	

	@Override
	protected String toStringForString() {		
		return columnName + " > " + stringValue;
	}
	

	@Override
	protected String toStringForDate() {		
		return columnName + " is after " + dateValue;
	}
	

	@Override
	protected String toStringForFloat() {
		return columnName + " > " + floatValue;
	}

}
