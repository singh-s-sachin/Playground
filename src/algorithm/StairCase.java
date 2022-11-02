package algorithm;

import java.util.AbstractMap;
import java.util.Map;

public class StairCase {
    /*

     ** There is a staircase with 'n' number of steps. A child
     ** walks by and wants to climb up the stairs, starting at
     ** the bottom step and ascending to the top.instead
     ** of taking 1 step at a time, it will vary between taking
     ** either 1, 2 or 3 steps at a time.
     ** Given 'n' number of steps below method should find
     ** number of
     ** unique combinations the child could traverse.
     ** An example would be countSteps(3) == 4:
     ** 1 1 1
     ** 2 1
     ** 1 2
     ** 3
     */

    public static int getPossibleWays(int stepCount) {
        Map.Entry<String, Integer> possibleCount = new AbstractMap.SimpleEntry<>("possibleCount", 0);
        getPossibleWaysRec(0, stepCount, possibleCount);
        return possibleCount.getValue();
    }

    private static void getPossibleWaysRec(int currentPosition, int destination, Map.Entry<String, Integer> possibleCount) {
        if (currentPosition == destination) {
            possibleCount.setValue(possibleCount.getValue() + 1);
        }
        if (currentPosition <= destination) {
            getPossibleWaysRec(currentPosition + 1, destination, possibleCount);
            getPossibleWaysRec(currentPosition + 2, destination, possibleCount);
            getPossibleWaysRec(currentPosition + 3, destination, possibleCount);
        }
    }
}
