package algorithm;

import java.util.AbstractMap;
import java.util.Map;

class Index {
    int x, y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Index) {
            return ((Index) obj).y == this.y && ((Index) obj).x == this.x;
        } else {
            return false;
        }
    }
}

public class MaxCollectOptimalPath {

    public static int compute(int[][] matrix) {
        Map.Entry<String, Integer> maxEntry = new AbstractMap.SimpleEntry<>("max", Integer.MIN_VALUE);
        computeRec(matrix, new Index(matrix.length-1, 0), new Index(0, matrix[0].length-1), 0, maxEntry);
        return maxEntry.getValue();
    }

    private static void computeRec(int[][] matrix, Index currentIndex, Index destinationIndex, int currentCollection, Map.Entry<String, Integer> maxEntry) {
        currentCollection+=matrix[currentIndex.x][currentIndex.y];
        if (currentIndex.equals(destinationIndex) && (maxEntry.getValue() < currentCollection)) {
            maxEntry.setValue(currentCollection);
        }
        if (currentIndex.x > 0) {
            computeRec(matrix,
                    new Index(currentIndex.x - 1, currentIndex.y),
                    destinationIndex,
                    currentCollection,
                    maxEntry);
        }
        if (currentIndex.y < matrix[0].length - 1) {
            computeRec(matrix,
                    new Index(currentIndex.x, currentIndex.y + 1),
                    destinationIndex,
                    currentCollection,
                    maxEntry);
        }
    }
}
