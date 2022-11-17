package lld.snakeladder;

public class Board {
    private final int boardSize;
    private final Cell[][] cells;

    public Board(int boardSize, int[] snakePos, int[] ladderPos) throws Exception {
        this.boardSize = (int) Math.sqrt(boardSize);
        this.cells = new Cell[this.boardSize][this.boardSize];
        int pos = 1;
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                this.cells[i][i % 2 == 0 ? j : (this.boardSize - j - 1)] = new Cell(pos++);
            }
        }
        addSnakes(snakePos);
        addLadders(ladderPos);
    }

    private void addLadders(int[] ladderPos) throws Exception {
        int ladderCount = ladderPos.length;
        for (int i = 0; i < ladderCount; i++) {
            Index cellIndex = getIndexForPosition(ladderPos[i]);
            this.cells[cellIndex.row][cellIndex.col].addLadder();
        }
    }

    private void addSnakes(int[] snakePos) throws Exception {
        int snakeCount = snakePos.length;
        for (int i = 0; i < snakeCount; i++) {
            Index cellIndex = getIndexForPosition(snakePos[i]);
            this.cells[cellIndex.row][cellIndex.col].addSnake();
        }
    }

    private Index getIndexForPosition(int position) {
        position--;
        int row = position / 10;
        int col = row % 2 == 0 ? position % 10 : (this.boardSize - position % 10) -1;
        return new Index(row, col);
    }

    class Index {
        int row;
        int col;

        Index(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int getNextPos(int currentPosition, int diceValue) throws Exception {
        int nextPosition = currentPosition + diceValue;
        if (nextPosition <= Game.BOARD_SIZE) {
            Index cellIndex = getIndexForPosition(nextPosition);
            Cell cell = cells[cellIndex.row][cellIndex.col];
            if (cell.hasJump()) {
                nextPosition = cell.jumpToPosition();
                System.out.println("::::::::" + (nextPosition < currentPosition ? "SNAKE" : "LADDER") + "::::::::");
            }
            return nextPosition;
        } else {
            return currentPosition;
        }
    }
}
