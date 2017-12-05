package com.aphoot.adventofcode2017;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Application {
    public static void main(String [] args) throws IOException {
        //Get input into a LinkedList<int>
        File inputFile = new File("src/main/resources/input.txt");
        List<CSVRecord> records = CSVParser.parse(inputFile, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withDelimiter(' ')).getRecords();

        System.out.println(records.stream().mapToInt(x -> {return processRecord(x)?1:0;}).sum());
    }


    public static boolean processRecord(CSVRecord input){
        //init
        for (int i = 0; i < input.size()-1; i++){
            String currentValue = input.get(i);
            for (int j = i+1; j < input.size(); j++){
                String nextValue = input.get(j);
                if (currentValue.equals(nextValue))
                    return false;
            }
        }
        return true;
    }


}
