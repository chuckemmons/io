package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public abstract class BaseCondition {

	private static final String MULTI_VALUE_DELIMITER = ";";
	
	protected String columnName;
	protected DateFormat dateFormat;
	protected Integer dateFieldToInclude;
	
	protected BaseCondition(String columnName) {
		this.columnName = columnName;
	}
	
	protected BaseCondition(String columnName, DateFormat dateFormat) {
		this.columnName = columnName;
		this.dateFormat = dateFormat;
	}
	
	protected BaseCondition(String columnName, DateFormat dateFormat, Integer dateFieldToInclude) {
		this.columnName = columnName;
		this.dateFormat = dateFormat;
		this.dateFieldToInclude = dateFieldToInclude;
	}
	
	protected Float getFloatFromRecordValue(String recordValue) {		
		if (isMultiValue(recordValue)) {
			return getFloatFromMultiValueString(recordValue);
		}
		
		return Float.valueOf(recordValue);
		
	}	
	
	
	/**
	 * Gets the date from the recordValue. <br>
	 * 
	 * If multivalue ( ';' delimited) record value, will parse for a date.<br>
	 * 
	 * Note, will return null if the recordValue does not represent a valid date
	 * given the dateFormat.
	 * 
	 * @param recordValue
	 * @return
	 */
	protected Date getDateFromRecordValue(String recordValue) {
		Date date = null;
		
		if (isMultiValue(recordValue) ) {
			date = getDateFromMultiValueString(recordValue);
		}		
		else {	
			
			try {				
				date = dateFormat.parse(recordValue);
				
				if (dateFieldToInclude != null) {
					date = DateUtils.truncate(date, dateFieldToInclude);
				}
			}
			
			catch (ParseException pe) {
				// Do nothing, because date wasn't found...
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
	}

}
