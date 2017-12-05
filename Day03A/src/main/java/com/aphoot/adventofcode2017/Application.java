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
        long result = process(Integer.parseInt(records.get(0).get(0)));

        System.out.println(result);
    }

    /*

    Step 1, determine which "ring" it's on. Take square root, round up to nearest odd. Call this SquareWidth.

    Step 2. Square the value SquareWidth. This gives the numeric value in lower-right corner. Call this CornerValue.

    Step 3. X = squareWidth/2 (integer division), Y = - squarewidth/2

    Step 4. Move left, decreasing, up to SquareWidth, until match is found, updating X and Y.

    Step 5. Repeat going up, then right, then down

     */
    public static long process(Integer input){
        double sqrt = Math.sqrt(input);
        long squareWidth = Math.round(Math.ceil(sqrt));
        if (squareWidth%2 == 0) //If squareWidth is even
            squareWidth++;      //round up to an odd number

        long currentX = squareWidth/2;
        long currentY = -squareWidth/2;

        long cornerValue = squareWidth * squareWidth;
        long currentValue = cornerValue;

        //Move left in ring
        for(int i = 0; i < squareWidth-1; i++){
            if (currentValue == input){
                return Math.abs(currentX) + Math.abs(currentY);
            } else {
                currentX--;
                currentValue--;
            }
        }

        //Move up in ring
        for(int i = 0; i < squareWidth-1; i++){
            if (currentValue == input){
                return Math.abs(currentX) + Math.abs(currentY);
            } else {
                currentY++;
                currentValue--;
            }
        }

        //Move right in ring
        for(int i = 0; i < squareWidth-1; i++){
            if (currentValue == input){
                return Math.abs(currentX) + Math.abs(currentY);
            } else {
                currentX++;
                currentValue--;
            }
        }

        //Move down in ring
        for(int i = 0; i < squareWidth-1; i++){
            if (currentValue == input){
                return Math.abs(currentX) + Math.abs(currentY);
            } else {
                currentY--;
                currentValue--;
            }
        }

        return 0;
    }




}
