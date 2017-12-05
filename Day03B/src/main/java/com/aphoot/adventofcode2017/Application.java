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
        List<CSVRecord> records = CSVParser.parse(inputFile, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withDelimiter('\t')).getRecords();
        long result = process(Integer.parseInt(records.get(0).get(0)));

        System.out.println(result);
    }

    /*
        start facing down
        set current location value to 1

        begin loop
            is there a value on my left?
            If not,
              turn left
            Go forward one
            calculate value at current location
        end loop


         */
    public static long process(Integer input){
        //init
        Map<Point, Long> playfield = new HashMap<>();
        Turtle turtle = new Turtle(new Point(0,0), 0);
        long currentValue = 1L;
        playfield.put(turtle.currentPosition, 1L);

        while (currentValue < input){
            Point pointOnLeft = turtle.getLeftCoordinate();
            long valueOnLeft = playfield.getOrDefault(pointOnLeft, 0L);
            if (valueOnLeft == 0)
                turtle.turnLeft();
            turtle.moveForward();
            currentValue = calcValue(playfield, turtle.currentPosition);
            playfield.put(turtle.currentPosition, currentValue);
        }

        return currentValue;
    }

    public static long calcValue(Map<Point, Long> playfield, Point point){
        return
          playfield.getOrDefault(new Point(point.x-1, point.y+1), 0L)
        + playfield.getOrDefault(new Point(point.x, point.y+1), 0L)
        + playfield.getOrDefault(new Point(point.x+1, point.y+1), 0L)
        + playfield.getOrDefault(new Point(point.x-1, point.y-1), 0L)
        + playfield.getOrDefault(new Point(point.x, point.y-1), 0L)
        + playfield.getOrDefault(new Point(point.x+1, point.y-1), 0L)
        + playfield.getOrDefault(new Point(point.x-1, point.y), 0L)
        + playfield.getOrDefault(new Point(point.x+1, point.y), 0L);
    }
}
