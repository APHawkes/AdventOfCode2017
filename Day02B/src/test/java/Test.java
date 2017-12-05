import com.aphoot.adventofcode2017.Application;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class Test {
    /*
It sounds like the goal is to find the only two numbers in each row where one evenly divides the other - that is,
where the result of the division operation is a whole number.
They would like you to find those numbers on each line, divide them, and add up each line's result.

For example, given the following spreadsheet:

5 9 2 8
9 4 7 3
3 8 6 5
In the first row, the only two numbers that evenly divide are 8 and 2; the result of this division is 4.
In the second row, the two numbers are 9 and 3; the result is 3.
In the third row, the result is 2.
In this example, the sum of the results would be 4 + 3 + 2 = 9.
 */

    public static void main(String[] args) throws IOException {
        String testData = "5\t9\t2\t8\n" +
                "9\t4\t7\t3\n" +
                "3\t8\t6\t5";

        System.out.println(Application.processRecords(Application.convert(testData)));


    }
}
