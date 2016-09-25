package com.cee.file.csv.criteria.expression;

public interface Expression {

	boolean isFalse();
	boolean isTrue();
	
	void addCondition();
}
