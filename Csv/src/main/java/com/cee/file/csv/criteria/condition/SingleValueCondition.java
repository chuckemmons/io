package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.cee.file.csv.CSVRecord;


public abstract class SingleValueCondition extends BaseCondition {
	//private static final String MULTI_VALUE_DELIMITER = ";";
	
	
	protected String stringValue;
	protected Float floatValue;
	
	protected Date dateValue;
	/*protected DateFormat dateFormat;
	protected Integer dateFieldToInclude;*/
	
	
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
	
	
	protected abstract boolean evaluateString(CSVRecord record);
	
	
	protected abstract boolean evaluateFloat(CSVRecord record);
	
	
	protected abstract boolean evaluateDate(CSVRecord record);
	
	
	/*protected Float getFloatFromRecordValue(String recordValue) {		
		if (isMultiValue(recordValue)) {
			return getFloatFromMultiValueString(recordValue);
		}
		
		return Float.valueOf(recordValue);
		
	}
	
	
	protected Date getDateFromRecordValue(String recordValue) {
		Date date;
		
		if (isMultiValue(recordValue)) {
			date = getDateFromMultiValueString(recordValue);
		}		
		else {		
			try {				
				date = dateFormat.parse(recordValue);
				if (dateFieldToInclude != null) {
					return DateUtils.truncate(date, dateFieldToInclude);
				}
			} 
			catch (ParseException pe) {
				throw new RuntimeException("Unable to parse date: " + recordValue 
						+ " with format: " + dateFormat.toString());
			}
		}
		
		return date;
	}
	
	
	private boolean isMultiValue(String string) {
		return string.contains(MULTI_VALUE_DELIMITER);
	}
	
	
	private Float getFloatFromMultiValueString(String multiValueStringFromRecord) {
		Float value = null;
		
		if(multiValueStringFromRecord.contains(MULTI_VALUE_DELIMITER)) {
			String[] values = multiValueStringFromRecord.split(MULTI_VALUE_DELIMITER);
			
			for (String string : values) {
				try {
					value = Float.valueOf(string);
					break;
				}
				catch (NumberFormatException nfe) {
					// do nothing, just continue because number wasn't found.
				}
			}
		}
		return value;
	}
	
	
	private Date getDateFromMultiValueString(String multiValueStringFromRecord) {
		Date date = null;
		
		if(multiValueStringFromRecord.contains(MULTI_VALUE_DELIMITER)) {
			String[] values = multiValueStringFromRecord.split(MULTI_VALUE_DELIMITER);
			
			for (String string : values) {
				try {
					date = dateFormat.parse(string);
					if (dateFieldToInclude != null) {
						return DateUtils.truncate(date, dateFieldToInclude);
					}
					break;
				}
				catch (ParseException pe) {
					// do nothing, just continue because date wasn't found.
				}
			}
		}
		return date;
	}*/
}
