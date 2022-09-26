package lld.tictaktoe;

class Index {
    int row;
    int col;

    Index(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public static Index getIndexForPosition(int position) {
        position--;
        int row = position / 3;
        int column = position % 3;
        return new Index(row, column);
    }
}
