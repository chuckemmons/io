package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import com.cee.file.csv.criteria.Logical;

/**
 * Factory for creating different Logical conditions.
 * @author chuck
 *
 */
public abstract class Condition {
	
	public static Logical containsOne(String columnName, Collection<String> values) {
		return new ContainsOneCondition(columnName, values);
	}
	
	public static Logical containsOne(Enum columnName, Collection<String> values) {
		return new ContainsOneCondition(columnName.toString(), values);
	}

	public static Logical eq(String columnName, String value) {
		return new EqCondition(columnName, value);
	}
	
	@SuppressWarnings("rawtypes")
	public static Logical eq(Enum columnName, String value) {
		return new EqCondition(columnName.toString(), value);
	}
	
	public static Logical eq(String columnName, float value) {
		return new EqCondition(columnName, value);
	}
	
	public static Logical eq(String columnName, Date value, DateFormat dateFormat) {
		return new EqCondition(columnName, value, dateFormat);
	}
	
	public static Logical eq(String columnName, Date value, DateFormat dateFormat, int dateFieldToInclude) {
		return new EqCondition(columnName, value, dateFormat, dateFieldToInclude);
	}
	
	public static Logical ne(String columnName, String value) {
		return new NeCondition(columnName, value);
	}
	
	public static Logical ne(String columnName, float value) {
		return new NeCondition(columnName, value);
	}
	
	public static Logical ne(String columnName, Date value, DateFormat dateFormat) {
		return new NeCondition(columnName, value, dateFormat);
	}

	public static Logical ne(String columnName, Date value, DateFormat dateFormat, int dateFieldToInclude) {
		return new NeCondition(columnName, value, dateFormat, dateFieldToInclude);
	}
	
	public static Logical gt(String columnName, float value) {
		return new GtCondition(columnName, value);
	}
	
	public static Logical gt(String columnName, Date value, DateFormat format) {
		return new GtCondition(columnName, value, format);
	}
	
	public static Logical gt(String columnName, Date value, DateFormat format, int dateFieldToInclude) {
		return new GtCondition(columnName, value, format, dateFieldToInclude);
	}	
	
	public static Logical between(String columnName, Date beginDate, Date endDate, DateFormat format) {
		return new BetweenCondition(columnName, beginDate, endDate, format);
	}
	
	public static Logical between(String columnName, Date beginDate, Date endDate, DateFormat format, int dateFieldToInclude) {
		return new BetweenCondition(columnName, beginDate, endDate, format, dateFieldToInclude);
	}		
	
	@SuppressWarnings("rawtypes")
	public static Logical between(Enum columnName, Date beginDate, Date endDate, DateFormat format) {
		return new BetweenCondition(columnName.toString(), beginDate, endDate, format);
	}
	
	@SuppressWarnings("rawtypes")
	public static Logical between(Enum columnName, Date beginDate, Date endDate, DateFormat format, int dateFieldToInclude) {
		return new BetweenCondition(columnName.toString(), beginDate, endDate, format, dateFieldToInclude);
	}	
	
	


}
