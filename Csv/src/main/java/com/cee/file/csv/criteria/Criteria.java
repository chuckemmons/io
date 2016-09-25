package com.cee.file.csv.criteria;

import java.util.List;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.expression.Expression;

public class Criteria {
	
	public List<Expression> expressions;
	
	public boolean meetsCriteria(CSVRecord record) {
		if (record == null || expressions == null) {
			return false;
		}
		/*for (Expression expression : expressions) {
			if (expression.isFalse(record)) {
				return false;
			}
		}*/
		return true;
	}
}
