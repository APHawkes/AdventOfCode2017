import com.aphoot.adventofcode2017.Application;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

public class Test {
    /*
You come across an experimental new kind of memory stored on an infinite two-dimensional grid.

Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then counting up while
spiraling outward. For example, the first few squares are allocated like this:

17  16  15  14  13
18   5   4   3  12
19   6   1   2  11
20   7   8   9  10
21  22  23---> ...
While this is very space-efficient (no squares are skipped), requested data must be carried back to square 1
(the location of the only access port for this memory system) by programs that can only move up, down, left, or right.
They always take the shortest path: the Manhattan Distance between the location of the data and square 1.

For example:

Data from square 1 is carried 0 steps, since it's at the access port.
Data from square 12 is carried 3 steps, such as: down, left, left.
Data from square 23 is carried only 2 steps: up twice.
Data from square 1024 must be carried 31 steps.
How many steps are required to carry the data from the square identified in your puzzle input all the way to the access port?
 */

    public static void main(String[] args) throws IOException {
        System.out.println(Application.process(1));
        System.out.println(Application.process(12));
        System.out.println(Application.process(23));
        System.out.println(Application.process(1024));

    }

    /*


    Going South, add: 7, 15, 23
                    8-1,16-1, 24-1
    Sequence: 1,8,23,46,77
    1
    1 + (1 * 8 - 1)                               = 1 +  1 * 8 - 1
    1 + (1 * 8 - 1) + (2 * 8 - 1)                 = 1 +  3 * 8 - 2
    1 + (1 * 8 - 1) + (2 * 8 - 1) + (3 * 8 - 1)   = 1 +  6 * 8 - 3
                                                  = 1 + 10 * 8 - 4



    Going West,  add: 5, 13, 21
                    8-3, 16-3, 24-3
    Sequence: 1,6,19,40,69

    Going north, add: 3, 11, 19
                     8-5, 16-5, 24-5
    Sequence: 1,4,15,34

    Going East,  add: 1, 9, 17
                    8-7, 16-7, 24-7
    Sequence: 1,2,11,28,53



    Going South-East, the diagonal increments by odds: (2x+1)^2 : 1,9,25,49,...
    distance a each radius increases by 8x, 8, 16, 24, 32, ...


    Step 1, determine which "ring" it's on. Take square root, round up to nearest odd. Call this SquareWidth.

    Step 2. Square the value SquareWidth. This gives the numeric value in lower-right corner. Call this CornerValue.

    Step 3. X = squareWidth/2 (integer division), Y = - squarewidth/2

    Step 4. Move left, decreasing, up to SquareWidth, until match is found, updating X and Y.

    Step 5. Repeat going up, then right, then down


     */
}
