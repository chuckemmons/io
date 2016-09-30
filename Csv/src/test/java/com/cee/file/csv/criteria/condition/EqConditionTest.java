package com.cee.file.csv.criteria.condition;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Criteria;
import com.cee.file.csv.test.util.JiraAttribute;

public class EqConditionTest extends ConditionalTest {
	
	@Test
	public void testEquals() {
		Enum<JiraAttribute> columnName = JiraAttribute.CUSTOM_FIELD_ASSIGNED_DEVELOPER;
		
		Criteria criteria = new Criteria(
				Condition.eq(columnName, "Chuck")
		);
	
		Iterable<CSVRecord> records = parseCsvFileReader(reader, criteria);
		
		Assert.assertNotNull(records); 
		
		for (CSVRecord csvRecord : records) {
			System.out.println(csvRecord.getSingleValueFor(JiraAttribute.ISSUE_KEY));
			System.out.println("-----------");
			
			Collection<String> developers = 
					csvRecord.getAllValuesFor(columnName.toString());
			for (String dev : developers) {
				System.out.println(dev);
			}
				
		}
	}

}
