package com.aphoot.adventofcode2017;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application {
    public static void main(String [] args) throws IOException {
        //Get input into a LinkedList<int>
        File inputFile = new File("src/main/resources/input.txt");
        List<CSVRecord> records = CSVParser.parse(inputFile, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withDelimiter('\t')).getRecords();

        int result = processRecords(records);

        System.out.println(result);
    }

    public static List<CSVRecord> convert(String line) throws IOException {
        return CSVParser.parse(line, CSVFormat.DEFAULT.withDelimiter('\t')).getRecords();
    }

    public static int processRecords(List<CSVRecord> records){
        int hash = 0;

        for(CSVRecord record : records){
            hash += processRecord(record);
        }

        return hash;
    }

    public static int processRecord(CSVRecord record){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Iterator<String> itr = record.iterator();
        while (itr.hasNext()){
            int intValue = Integer.parseInt(itr.next());
            if (intValue > max){
                max = intValue;
            }
            if (intValue < min){
                min = intValue;
            }
        }

        return max-min;
    }

}
