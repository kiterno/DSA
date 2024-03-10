package design.pattern.systemdesign.tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame();

        System.out.println("The game winner is: " + ticTacToeGame.startGame());
    }
}
