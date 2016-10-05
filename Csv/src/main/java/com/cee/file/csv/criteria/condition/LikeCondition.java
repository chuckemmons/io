package com.cee.file.csv.criteria.condition;

import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class LikeCondition extends SingleValueCondition implements Logical{
	
	protected LikeCondition(String columnName, String value) {
		super(columnName, value);
	}	
	
	
	@SuppressWarnings("rawtypes")
	protected LikeCondition(Enum columnName, String value) {
		super(columnName.toString(), value);
	}

	@Override
	protected boolean evaluateString(CSVRecord record) {
		List<String> recordValues = record.getAllValuesFor(columnName);
		for (String recordValue : recordValues) {
			if (stringValue.contains(recordValue)) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean evaluateFloat(CSVRecord record) {
		// TODO Auto-generated method stub
		throw new RuntimeException("This exception will never be reached because float isn't implemented.");
	}

	@Override
	protected boolean evaluateDate(CSVRecord record) {
		throw new RuntimeException("This exception will never be reached because date isn't implemented.");
	}

}
