package design.pattern.systemdesign.connect4.model;

public class Player {
    private String firstName;
    private Piece piece;

    public Player(String firstName, Piece piece) {
        this.firstName = firstName;
        this.piece = piece;
    }

    public String getFirstName() {
        return firstName;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", piece=" + piece +
                '}';
    }
}
