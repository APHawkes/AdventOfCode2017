import com.aphoot.adventofcode2017.Application;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class Test {
    /*
    A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a
    password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

To ensure security, a valid passphrase must contain no duplicate words.

For example:

aa bb cc dd ee is valid.
aa bb cc dd aa is not valid - the word aa appears more than once.
aa bb cc dd aaa is valid - aa and aaa count as different words.
The system's full passphrase list is available as your puzzle input. How many passphrases are valid?
*/

    public static void main(String[] args) throws IOException {
        String lines = "aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa";
        CSVParser parser = CSVParser.parse(lines, CSVFormat.DEFAULT.withDelimiter(' '));

        List<CSVRecord> records = parser.getRecords();
        System.out.println(Application.processRecord(records.get(0)));
        System.out.println(Application.processRecord(records.get(1)));
        System.out.println(Application.processRecord(records.get(2)));

    }

    //Just start building the thing in memory, then calculation is super-easy. What was I thinking before?


}
