package com.cee.file.csv.criteria.condition;

import java.io.Reader;

import org.junit.After;

import com.cee.file.csv.test.BaseCsvTest;

/**
 * 
 * Haha! I did it! I created a conditional test!
 * I mean, who would have thought that a test 
 * could be conditional? 
 * @author chuck
 *
 */
public class ConditionalTest extends BaseCsvTest {

	protected Reader reader;
	
	@Override
	public void setup() {
		reader = createFileReader(path);
	}
	
	@After
	public void teardown() {
		closeReader(reader);
	}

}
