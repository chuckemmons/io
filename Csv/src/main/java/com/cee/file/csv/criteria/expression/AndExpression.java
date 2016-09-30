package com.cee.file.csv.criteria.expression;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class AndExpression extends BaseExpression implements Logical {

	protected AndExpression(Logical lhs, Logical rhs) {
		super(lhs, rhs);
	}

	@Override
	public boolean evaluate(CSVRecord record) {
		return lhs.evaluate(record) && rhs.evaluate(record);
	}

}
