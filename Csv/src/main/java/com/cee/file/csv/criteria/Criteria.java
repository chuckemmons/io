package com.cee.file.csv.criteria;

import com.cee.file.csv.CSVRecord;

public class Criteria {
	
	private Logical expression;
	
	public Criteria(Logical expression){
		this.expression = expression;
	}
	
	public boolean isMet(CSVRecord record) {
		if (record == null || expression == null) {
			return false;
		}

		return expression.evaluate(record);
	}
}
