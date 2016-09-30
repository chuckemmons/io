package com.cee.file.csv.criteria.expression;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Logical;

public class NotExpression extends BaseExpression implements Logical {

	protected NotExpression(Logical logical) {
		super(logical, null);
	}
	@Override
	public boolean evaluate(CSVRecord record) {
		return !lhs.evaluate(record);
	}

}
