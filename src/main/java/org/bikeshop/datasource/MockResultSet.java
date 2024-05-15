package org.bikeshop.datasource;

import java.io.*;

import static java.util.Objects.isNull;

public class MockResultSet {

    private static final String COMMENT_FLAG = ";";

    private BufferedReader reader;

    public MockResultSet(File inputTable) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(inputTable));
    }

    public String readRow() throws IOException{
        String line = reader.readLine();

        if(isNull(line)){
            return null;
        }

        return line.contains(COMMENT_FLAG) ? reader.readLine() : line;
    }
}
