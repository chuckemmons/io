package com.cee.file.csv.criteria.expression;

import com.cee.file.csv.criteria.Logical;

/**
 * Factory class to create new expressions.
 * @author chuck
 *
 */
public abstract class Expression {

	public static Logical and(final Logical lhs, final Logical rhs) {
		return new AndExpression(lhs, rhs);
	}
	
	public static Logical not(final Logical logical) {
		return new NotExpression(logical);
	}
	
	public static Logical or(final Logical lhs, final Logical rhs) {
		return new OrExpression(lhs, rhs);
	}
}
