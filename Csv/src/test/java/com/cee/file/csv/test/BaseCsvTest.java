package com.cee.file.csv.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Before;

import com.cee.file.csv.CSVFormat;
import com.cee.file.csv.CSVRecord;
import com.cee.file.csv.criteria.Criteria;

public class BaseCsvTest {

	protected String path = "JIRA1.csv";
	
	Iterable<CSVRecord> records;
	
	
	@Before
	public void setup() {		
		Reader reader = createFileReader(path);
		
		records = parseCsvFileReader(reader);
		
		closeReader(reader);
	}
	
	/**
	 * Parses the reader 
	 * @param reader
	 * @return
	 */
	protected Iterable<CSVRecord> parseCsvFileReader(Reader reader, Criteria criteria) {
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader();
		
		try {
			records = csvFormat.parse(reader, criteria);
		} 
		catch (IOException ioe) {
			closeReader(reader);
			throw new RuntimeException("Cannot create CSV records. Unable to parse the given csv reader.", ioe);
		}
		
		return records;
	}
	
	
	/**
	 * Parses the reader 
	 * @param reader
	 * @return
	 */
	protected Iterable<CSVRecord> parseCsvFileReader(Reader reader) {
		CSVFormat csvFormat = CSVFormat.EXCEL.withHeader();
		
		try {
			records = csvFormat.parse(reader);
		} 
		catch (IOException ioe) {
			closeReader(reader);
			throw new RuntimeException("Cannot create CSV records. Unable to parse the given csv reader.", ioe);
		}
		
		return records;
	}
	
	
	protected Reader createFileReader(String path) {
		Reader reader = null;
		
		try {
			reader = new FileReader(path);
		} 
		catch (FileNotFoundException fnfe) {
			throw new RuntimeException("Unable to create file reader with the given path: [" + path + "]", fnfe);
		}
		
		return reader;
	}
	
	
	protected void closeReader(Reader reader) {
		try {
			reader.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
