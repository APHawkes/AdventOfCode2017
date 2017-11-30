package com.aphoot.adventofcode2017;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;

public class Application {
    public static void main(String [] args) throws IOException {
        File inputFile = new File("src/main/resources/input.txt");
        CSVParser parser = CSVParser.parse(inputFile, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withIgnoreSurroundingSpaces() );
        for (CSVRecord record : parser.getRecords()) {
            Iterator itr = record.iterator();
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
        }



    }
}
