import com.aphoot.adventofcode2017.Application;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.util.List;

public class Test {
    /*
    For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two
    words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to
    form any other word in the passphrase.

For example:

abcde fghij is a valid passphrase.
abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
iiii oiii ooii oooi oooo is valid.
oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
Under this new system policy, how many passphrases are valid?
*/

    public static void main(String[] args) throws IOException {
        String lines = "abcde fghij\n" +
                "abcde xyz ecdab\n" +
                "a ab abc abd abf abj\n" +
                "iiii oiii ooii oooi oooo\n" +
                "oiii ioii iioi iiio";
        CSVParser parser = CSVParser.parse(lines, CSVFormat.DEFAULT.withDelimiter(' '));

        List<CSVRecord> records = parser.getRecords();
        System.out.println(Application.processRecord(records.get(0)));
        System.out.println(Application.processRecord(records.get(1)));
        System.out.println(Application.processRecord(records.get(2)));
        System.out.println(Application.processRecord(records.get(3)));
        System.out.println(Application.processRecord(records.get(4)));

    }

    //Just start building the thing in memory, then calculation is super-easy. What was I thinking before?


}
