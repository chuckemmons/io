package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class BetweenCondition extends BaseCondition implements Logical {
	
	private Date beginDate;
	private Date endDate;
	
	protected BetweenCondition(
					String columnName, Date beginDate,	Date endDate, 
					DateFormat dateFormat, int dateFieldToInclude) {
		
		super(columnName, dateFormat, dateFieldToInclude);
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	protected BetweenCondition(String columnName, Date beginDate, 
									Date endDate, DateFormat dateFormat) {
		super(columnName, dateFormat);
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	@Override
	public boolean evaluate(CSVRecord record) {
		if (beginDate != null && endDate != null) {
			return evaluateDate(record);
		}
		return false;
	}
	
	

	/**
	 * Evaluates the columnName of the record for <em>any</em> matches that 
	 * 		are between the given dates.
	 * @param record the record to evaluate.
	 * @return <code>true</code> if a date is found between the start and 
	 * 		endDate for the given columnName.
	 */
	private boolean evaluateDate(CSVRecord record) {
		List<String> recordValues = record.getAllValuesFor(columnName);
		
		for (String recordValue: recordValues) {
			//System.out.println(this.getClass().getName() );
			Date recordDate = getDateFromRecordValue(recordValue);
			
			if (recordDate != null) {
				
				if (isOnOrAfterBeginDate(recordDate)
						&& isOnOrBeforeEndDate(recordDate)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public boolean isOnOrAfterBeginDate(Date date) {
		
		return date.equals(beginDate) || date.after(beginDate);
	}
	
	
	public boolean isOnOrBeforeEndDate(Date date) {
		
		return date.equals(endDate) || date.before(endDate);
	}

}
