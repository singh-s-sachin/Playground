package lld.snakeladder;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    static final int BOARD_SIZE = 100;

    Deque<Player> players;
    Dice dice;
    Board board;


    public Game(int numberOfPlayers) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (numberOfPlayers > 4) {
            throw new Exception("GAME ERROR :::: Only four players allowed");
        }
        dice = new Dice();
        board = new Board(BOARD_SIZE, new int[]{34, 78, 65, 76, 92, 97}, new int[]{6, 16, 22, 35, 57, 82});
        players = new LinkedList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("::::::::::: Enter player " + (i + 1) + " name :::::::::::");
            String playerName = sc.nextLine();
            players.add(new Player(playerName));
        }
    }

    public static void main(String args[]) throws Exception {
        Game game = new Game(2);

        Player winningPlayer = null;

        while (winningPlayer == null) {

            //Player peeked
            Player player = game.players.peek();


            System.out.println(player.getName().concat(" with position ")
                    .concat(String.valueOf(player.getCurrentPosition()))
                    .concat(" roll the dice"));

            //Player rolls the dice
            int diceValue = game.dice.roll();

            System.out.println(player.getName().concat(" gets ")
                    .concat(String.valueOf(diceValue))
                    .concat(" in dice roll"));

            //Player get his next position includes snake bites and ladder.
            int nextPosition = game.board.getNextPos(player.getCurrentPosition(), diceValue);

            //Player changes his position
            player.changePosition(nextPosition);

            System.out.println(player.getName()
                    .concat(" new position is ")
                    .concat(String.valueOf(nextPosition)));

            //System decides whether player reached top.
            if (nextPosition == BOARD_SIZE) {
                winningPlayer = player;
            }

            //Player removed from top and added to last
            game.players.removeFirst();
            game.players.add(player);
        }

        System.out.println("\n\n\n::::::::::: WINNER :::::::::::"
                .concat("\n")
                .concat(winningPlayer.getName()));

    }
}
