package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxSumTraversal {
    class Index {
        private final int x;
        private final int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Traversal.Index index) {
                return this.x == index.getX() && this.y == index.getY();
            } else {
                return false;
            }
        }
    }

    public int getMaxSumTraversal(List<List<Integer>> matrix) {
        int maxY = matrix.get(0).size();
        int maxX = matrix.size();
        int maxSum = 0;
        for (int i = 0; i < maxY; i++) {
            List<Integer> allSum = new ArrayList<>();
            allSum.add(0);
            getMaxValFromOrigin(matrix, new Index(0, i), new Index(maxX - 1, maxY - 1), matrix.get(0).get(i), allSum);
            int maxSumOrigin = allSum.get(0);
            if (maxSumOrigin > maxSum) {
                maxSum = maxSumOrigin;
            }
        }
        return maxSum;
    }

    private void getMaxValFromOrigin(List<List<Integer>> matrix, Index startIndex, Index maxIndex, int currSum, List<Integer> allSum) {
        if (maxIndex.getX() == startIndex.getX() && allSum.get(0) < currSum) {
            allSum.set(0, currSum);
            return;
        }
        if (startIndex.getX() + 1 <= maxIndex.getX()) {
            Index nextIndex = null;
            if (startIndex.getY() + 1 <= maxIndex.getY()) {
                nextIndex = new Index(startIndex.getX() + 1, startIndex.getY() + 1);
                getMaxValFromOrigin(matrix, nextIndex, maxIndex, currSum + matrix.get(nextIndex.getX()).get(nextIndex.getY()), allSum);
            }
            if (startIndex.getY() - 1 >= 0) {
                nextIndex = new Index(startIndex.getX() + 1, startIndex.getY() - 1);
                getMaxValFromOrigin(matrix, nextIndex, maxIndex, currSum + matrix.get(nextIndex.getX()).get(nextIndex.getY()), allSum);
            }
            if (startIndex.getY() >= 0 && startIndex.getY() <= maxIndex.getY()) {
                nextIndex = new Index(startIndex.getX() + 1, startIndex.getY());
                getMaxValFromOrigin(matrix, nextIndex, maxIndex, currSum + matrix.get(nextIndex.getX()).get(nextIndex.getY()), allSum);
            }
        }
    }
}
