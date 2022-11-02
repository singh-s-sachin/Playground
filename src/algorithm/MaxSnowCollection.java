package algorithm;

import java.util.List;

public class MaxSnowCollection {
    //https://www.csestack.org/snow-between-hills-coding-challenge/

    public static int compute(int[] elevations) {
        int maxElevation = Integer.MIN_VALUE;
        int[] leftToRight = new int[elevations.length];
        int snowCollected = 0;
        for (int i = 0; i < elevations.length; i++) {
            if (maxElevation < elevations[i]) {
                maxElevation = elevations[i];
            }
            leftToRight[i] = maxElevation;
        }
        maxElevation = Integer.MIN_VALUE;
        for (int i = elevations.length - 1; i > 0; i--) {
            if (maxElevation < elevations[i]) {
                maxElevation = elevations[i];
            }
            int diff = Math.min(maxElevation, leftToRight[i]) - elevations[i];
            if (diff >= 0) {
                snowCollected += diff;
            }
        }
        return snowCollected;
    }
}
