package com.cee.file.csv.poc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cee.file.csv.CSVFormat;
import com.cee.file.csv.CSVRecord;


public class ParseMultiValueCsvTest {
	
	Iterable<CSVRecord> records;
	
	@Before
	public void setup() {
		String path = "JIRA1.csv";
		
		Reader reader = null;
		
		try {
			reader = new FileReader(path);
		} catch (FileNotFoundException fnfe) {
			System.out.println("Could not find file: " + path);
			fnfe.printStackTrace();
		}
		
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader();
		try {
			records = csvFormat.parse(reader);
		} catch (IOException ioe) {
			System.out.println("Unable to parse file: " + path);
			ioe.printStackTrace();
		}
	}
	
	@Test
	public void testParserPOC() {
		Assert.assertNotNull(records);
		Assert.assertTrue(records.iterator().hasNext());
		for (CSVRecord csvRecord : records) {
			System.out.println("CSVRecord: " + csvRecord.getSingleValueFor("Issue key"));
			List<String> workLog = csvRecord.getAllValuesFor("Log Work");
			System.out.println("\tworkLog:");
			for (String string : workLog) {
				System.out.println("\t\t" + string);
			}
			List<String> developers = csvRecord.getAllValuesFor("Custom field (Assigned Developer)");
			System.out.println("\tdeveloper(s):");
			for (String string : developers) {
				System.out.println("\t\t" + string);
			}
		}
	}
}
