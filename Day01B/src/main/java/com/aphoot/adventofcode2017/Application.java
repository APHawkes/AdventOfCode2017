package com.aphoot.adventofcode2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String [] args) throws IOException {
        //Get input into a LinkedList<int>
        File inputFile = new File("src/main/resources/input.txt");
        BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile));
        String line = reader.readLine();
        List<Integer> intList = convert(line);
        int result = process(intList);

        System.out.println(result);
    }

    public static List<Integer> convert(String line){
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < line.length(); i++){
            intList.add(Integer.parseInt(line.substring(i, i+1)));
        }
        return intList;
    }

    public static int process(List<Integer> intList){
        //Starting at the front of the list, identify sequences and add digits
        int offset = intList.size()/2;
        int sum = 0;

        for(int i = 0; i < intList.size(); i++){
            int currentDigit = intList.get(i);
            int offsetDigit = intList.get((i+offset)%intList.size());
            if (currentDigit == offsetDigit){
                sum += currentDigit;
            }
        }

        return sum;
    }
}
