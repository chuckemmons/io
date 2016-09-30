package com.cee.file.csv.criteria.expression;

import com.cee.file.csv.criteria.Logical;

public class BaseExpression {
	
	protected Logical lhs;
	protected Logical rhs;
	
	protected BaseExpression(Logical lhs, Logical rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
}
