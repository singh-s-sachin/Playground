package interview.birdeye;

import java.util.AbstractMap;
import java.util.Map;

public class TraverseMatrix {
    /**
     * [0,0,0]
     * [0,0,0]
     * [0,0,0]
     */

    public static void main(String[] args) {
        System.out.println("Possible path count : " + getPathCount(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0,}, new int[]{0, 0, 0}}));
    }

    public static int getPathCount(int[][] matrix) {
        Map.Entry<String, Integer> countEntry = new AbstractMap.SimpleEntry<>("count", 0);
        getPathCountRec(matrix, new Index(0, 0), new Index(matrix.length-1, matrix[0].length-1), "", countEntry);
        return countEntry.getValue();
    }

    private static void getPathCountRec(int[][] matrix, Index currIndex, Index endIndex, String path, Map.Entry<String, Integer> countEntry) {
        if (currIndex.equals(endIndex)) {
            countEntry.setValue(countEntry.getValue() + 1);
            System.out.println(path);
        }
        if (currIndex.y < endIndex.y) {//0,0 - 0,1 - 0,2
            getPathCountRec(matrix, new Index(currIndex.x, currIndex.y + 1), endIndex, path + "R", countEntry);
        }
        if (currIndex.x < endIndex.x) { // 0,2 - 1,2 - 2,2
            getPathCountRec(matrix, new Index(currIndex.x + 1, currIndex.y), endIndex, path + "D", countEntry);
        }
    }
}

class Index {
    int x;
    int y;

    public Index(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Index && ((Index) object).x == this.x && ((Index) object).y == this.y;
    }
}