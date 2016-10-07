package com.cee.file.csv.criteria.condition;

import java.util.Collection;
import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class ContainsOneCondition extends MultiValueCondition implements Logical {

	public ContainsOneCondition(String columnName, Collection<String> values) {
		super(columnName, values);
	}

	/*public ContainsOneCondition(String columnName, Date value, DateFormat dateFormat) {
		super(columnName, value, dateFormat);
		// TODO Auto-generated constructor stub
	}

	public ContainsOneCondition(String columnName, Date value, DateFormat dateFormat,
			int dateFieldToInclude) {
		super(columnName, value, dateFormat, dateFieldToInclude);
		// TODO Auto-generated constructor stub
	}

	public ContainsOneCondition(String columnName, float value) {
		super(columnName, value);
		// TODO Auto-generated constructor stub
	}*/
	
	@Override
	protected boolean evaluateStrings(CSVRecord record) {
		for (String stringValue : stringValues) {			
			List<String> recordValues = record.getAllValuesFor(columnName);
			
			for (String recordValue : recordValues) {				
				if (stringValue.equals(recordValue)) {
					return true;
				}
			}
		}
		
		return false;
	}

	/*@Override
	protected boolean evaluateFloats(CSVRecord record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean evaluateDates(CSVRecord record) {
		// TODO Auto-generated method stub
		return false;
	}*/

	@Override
	protected String toStringForStrings() {
		return columnName + " contains one of the following: " + stringValues.toString();
	}

	@Override
	protected String toStringForFloat() {
		// TODO Auto-generated method stub
		throw new RuntimeException("This exception will never be reached because float isn't implemented.");
	}

	@Override
	protected String toStringForDate() {
		// TODO Auto-generated method stub
		throw new RuntimeException("This exception will never be reached because date isn't implemented.");
	}

}
