package algorithm;

import java.util.List;

public class Traversal {
    class Index {
        private int x;
        private int y;

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
            if (obj instanceof Index) {
                Index index = (Index) obj;
                return this.x == index.getX() && this.y == index.getY();
            } else {
                return false;
            }
        }
    }

    public boolean hasPathToDestination(List<List<Integer>> matrix) {
        return hasPathToDestinationRec(matrix, new Index(0, 0), new Index(matrix.size() - 1, matrix.get(0).size() - 1));
    }

    private boolean hasPathToDestinationRec(List<List<Integer>> matrix, Index fromIndex, Index toIndex) {
        boolean isDestinationReached = false;
        if (fromIndex.equals(toIndex)) {
            return true;
        }
        if (fromIndex.getY() < toIndex.getY() && matrix.get(fromIndex.getX()).get(fromIndex.getY() + 1) == 0) {
            isDestinationReached = hasPathToDestinationRec(matrix, new Index(fromIndex.getX(), fromIndex.getY() + 1), toIndex);
            if (isDestinationReached) {
                return true;
            }
        }
        if (fromIndex.getX() < toIndex.getX() && matrix.get(fromIndex.getX() + 1).get(fromIndex.getY()) == 0) {
            isDestinationReached = hasPathToDestinationRec(matrix, new Index(fromIndex.getX() + 1, fromIndex.getY()), toIndex);
            if (isDestinationReached) {
                return true;
            }
        }
        return isDestinationReached;
    }
}
