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
        for(int i = 0; i < record.size(); i++){
            int firstValue = Integer.parseInt(record.get(i));
            for (int j = i+1; j < record.size(); j++){
                int currValue = Integer.parseInt(record.get(j));

                //Divisibility check
                if (currValue%firstValue == 0){
                    return currValue/firstValue;
                } else if (firstValue%currValue == 0){
                    return firstValue/currValue;
                }

            }


        }
        return 0; //should never get here.
    }

}
