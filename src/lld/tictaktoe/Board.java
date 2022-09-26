package lld.tictaktoe;

public class Board {
    Cell[][] cells;

    public Board() {
        this.cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public void addBall(int position, Ball ball) throws TicTakToeException {
        Index index = Index.getIndexForPosition(position);
        cells[index.row][index.col].addBall(ball);
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((cells[i][j].hasBall() ? cells[i][j].getBallType() : "-") + "\t");
            }
            System.out.println("");
        }
    }
}
