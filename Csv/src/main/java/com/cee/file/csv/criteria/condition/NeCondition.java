package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class NeCondition extends SingleValueCondition implements Logical {

	
	protected NeCondition(String columnName, String value) {
		super(columnName, value);
	}
	
	
	protected NeCondition(String columnName, float value) {
		super(columnName, value);
	}
	
	
	/**
	 * Compares the date without time fields. 
	 * Meaning that two dates are not equal if they represent 
	 * different calendar days.
	 * 
	 * @param columnName
	 * 			the column name of the value to compare.
	 * @param value
	 * 			the value to compare against.
	 * @param dateFormat
	 * 			the format of the date contained in the record.
	 */
	protected NeCondition(String columnName, Date value, DateFormat dateFormat) {
		super(columnName, value, dateFormat);
	}
	
	
	/**
	 * Compares the dates truncated after the dateFieldToInclude.
	 * For example, passing in Calendar.DAY_OF_MONTH will compare the dates
	 * down to the day and the time fields will not be taken into account.
	 * 
	 * @param columnName
	 * 			the column name of the value to compare.
	 * @param value
	 * 			the value to compare against.
	 * @param dateFormat
	 * 			the format of the date contained in the record.
	 * @param dateFieldToInclude
	 * 			the date field to include in the comparison. null value meaning all date fields will be compared.
	 */
	protected NeCondition(String columnName, Date value, DateFormat dateFormat, int dateFieldToInclude) {
		super(columnName, value, dateFormat, dateFieldToInclude);
	}

	
	@Override	
	protected boolean evaluateDate(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {
			Date recordDate = getDateFromRecordValue(strValue);
			if (recordDate.equals(this.dateValue)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	@Override
	protected boolean evaluateFloat(CSVRecord record) {
		List<String> strValues = record.getAllValuesFor(columnName);
		
		for (String strValue : strValues) {
			Float recordValue = getFloatFromRecordValue(strValue);
			if (recordValue == floatValue) {
				return false;
			}
		}
		
		return true;
	}
	
	
	@Override
	protected boolean evaluateString(CSVRecord record) {
		List<String> values = record.getAllValuesFor(columnName);
		
		for (String oValue : values) {
			if (stringValue.equals(oValue)) {
				return false;
			}
		}
		
		return true;
	}

}
