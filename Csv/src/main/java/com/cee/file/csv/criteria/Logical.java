package com.cee.file.csv.criteria;

import com.cee.file.csv.CSVRecord;

public interface Logical {
	boolean isTrue(CSVRecord record);
	boolean isFalse(CSVRecord record);
}
