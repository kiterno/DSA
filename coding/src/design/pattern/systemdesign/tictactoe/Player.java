package design.pattern.systemdesign.tictactoe;

public class Player {
    private String name;
    private PlayingPiece piece;

    public String getName() {
        return name;
    }

    public PlayingPiece getPiece() {
        return piece;
    }

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }
}
