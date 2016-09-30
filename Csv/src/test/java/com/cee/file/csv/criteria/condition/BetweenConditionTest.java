package com.cee.file.csv.criteria.condition;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Criteria;
import com.cee.file.csv.test.util.DateUtil;
import com.cee.file.csv.test.util.JiraAttribute;

public class BetweenConditionTest extends ConditionalTest {

	
	@Test
	public void testWorkLogDate() {
		DateFormat dateFormater = new SimpleDateFormat(DateUtil.JIRA_WORKLOG_DATE_FORMAT);
		
		Enum<JiraAttribute> columnName = JiraAttribute.LOG_WORK;
		
		Date beginDate = DateUtil.getSprintDate("08/01/2016 00:00");
		Date endDate = DateUtil.getSprintDate("09/01/2016 00:00");
		
		Criteria criteria = new Criteria(
				Condition.between(columnName, beginDate, endDate, dateFormater)
		);
				
		Iterable<CSVRecord> records = parseCsvFileReader(reader, criteria);
		
		Assert.assertNotNull(records);

		/*for (CSVRecord csvRecord : records) {
			System.out.println(csvRecord.getSingleValueFor(JiraAttribute.ISSUE_KEY));
			System.out.println("-----------");
			
			Collection<String> workLogs = 
					csvRecord.getAllValuesFor(JiraAttribute.LOG_WORK.toString());
			for (String workLog : workLogs) {
				System.out.println(workLog);
			}
				
		}*/
	}
	

}
