package lld.tictaktoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    //Game -> Board, Players[2]

    //Board -> Cells
    //Cell -> Ball
    //Player -> Name, Balls
    //Ball -> Type [ENUM (O,X)]
    /**
     * [1,2,3]
     * [4,5,6]
     * [7,8,9]
     */
    Board board;
    Deque<Player> players;

    public Game() {
        Scanner sc = new Scanner(System.in);
        this.board = new Board();
        this.players = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter Player "
                    .concat(String.valueOf(i + 1)).concat(" name"));
            String playerName = sc.nextLine();
            players.add(new Player(playerName, i % 2 == 0 ? BallType.X : BallType.O));
        }
    }

    private boolean checkWinner(int position, BallType ballType) {
        boolean isWinner = false;
        Index index = Index.getIndexForPosition(position);
        isWinner = checkLinear(index, ballType);
        if (isWinner) {
            return true;
        }
        isWinner = checkTangent(index, ballType);
        return isWinner;
    }

    private boolean checkTangent(Index index, BallType ballType) {
        int row = index.row;
        int col = index.col;

        boolean isWinner = false;


        boolean isLeftDiagnol = row == col;
        boolean isRightDiagnol = Math.abs(row - col) == 2 || (row == 1 && col == 1);

        //r++, c++
        if (isLeftDiagnol) {
            int tempRow = row;
            int tempCol = col;
            while (tempRow > 0) {
                tempRow--;
            }
            while (tempCol > 0) {
                tempCol--;
            }
            while (tempRow < 3) {
                if (this.board.cells[tempRow][tempCol].hasBall() && this.board.cells[tempRow][tempCol].getBallType() == ballType) {
                    isWinner = true;
                } else {
                    isWinner = false;
                    break;
                }
                tempRow++;
                tempCol++;
            }
        }
        if (isWinner) {
            return true;
        }

        //r++, c--
        if (isRightDiagnol) {
            int tempRow = row;
            int tempCol = col;
            while (tempRow > 0) {
                tempRow--;
            }
            while (tempCol < 2) {
                tempCol++;
            }
            while (tempRow < 3) {
                if (this.board.cells[tempRow][tempCol].hasBall() && this.board.cells[tempRow][tempCol].getBallType() == ballType) {
                    isWinner = true;
                } else {
                    isWinner = false;
                    break;
                }
                tempRow++;
                tempCol--;
            }
        }
        return isWinner;
    }

    private boolean checkLinear(Index index, BallType ballType) {
        int row = index.row;
        int col = index.col;

        boolean isWinner = false;

        int tempRow = row;
        while (tempRow > 0) {
            tempRow--;
        }
        while (tempRow < 3) {
            if (this.board.cells[tempRow][col].hasBall() && this.board.cells[tempRow][col].getBallType() == ballType) {
                isWinner = true;
            } else {
                isWinner = false;
                break;
            }
            tempRow++;
        }
        if (isWinner) {
            return true;
        }
        int tempCol = col;
        while (tempCol > 0) {
            tempCol--;
        }
        while (tempCol < 3) {
            if (this.board.cells[row][tempCol].hasBall() && this.board.cells[row][tempCol].getBallType() == ballType) {
                isWinner = true;
            } else {
                isWinner = false;
                break;
            }
            tempCol++;
        }
        return isWinner;
    }


    public static void main(String[] args) throws TicTakToeException {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();

        boolean isWinner = false;

        Player activePlayer = null;

        while (!isWinner) {

            activePlayer = game.players.peek();
            System.out.println(activePlayer.getName().concat(" comes to action"));

            game.board.printBoard();

            System.out.println(activePlayer.getName().concat(" ::::: Position your attempt"));
            int position = sc.nextInt();

            Ball playerBall = activePlayer.getBall();
            game.board.addBall(position, playerBall);

            game.players.removeFirst();
            game.players.addLast(activePlayer);

            isWinner = game.checkWinner(position, playerBall.ballType);
        }

        game.board.printBoard();
        System.out.println("Hurrah !!".concat("\n").concat(activePlayer.getName()).concat(" is a winner"));
    }

}
