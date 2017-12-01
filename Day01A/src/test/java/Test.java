import com.aphoot.adventofcode2017.Application;

public class Test {
    /*
    The captcha requires you to review a sequence of digits (your puzzle input) and find the sum of all digits that match the next digit in the list.
    .The list is circular, so the digit after the last digit is the first digit in the list.

For example:

1122 produces a sum of 3 (1 + 2) because the first digit (1) matches the second digit and the third digit (2) matches the fourth digit.
1111 produces 4 because each digit (all 1) matches the next.
1234 produces 0 because no digit matches the next.
91212129 produces 9 because the only digit that matches the next one is the last digit, 9.
 */

    public static void main(String[] args){
        System.out.println(Application.process(Application.convert("1122")));
        System.out.println(Application.process(Application.convert("1111")));
        System.out.println(Application.process(Application.convert("1234")));
        System.out.println(Application.process(Application.convert("91212129")));

    }
}
/*

final String input = "";
int answer = 0;
for (int i = 0; i < input.length() - 2; i++) {
  if (input.substring(i, i + 1).equals(input.substring(i + 1, i + 2))) {
    answer += new Integer(input.substring(i, i + 1));
  }
}
if (input.substring(0,1).equals(input.substring(input.length()-1))) {
  answer += new Integer(input.substring(0,1));
}
System.out.println(answer);
 */