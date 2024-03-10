package design.pattern.systemdesign.connect4.model;

public abstract class Piece {
    private PieceType pieceType;

    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                '}';
    }
}
