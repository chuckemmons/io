package com.cee.file.csv.criteria;

import com.cee.file.csv.CSVRecord;

public interface Logical {
	boolean evaluate(CSVRecord record);
}
