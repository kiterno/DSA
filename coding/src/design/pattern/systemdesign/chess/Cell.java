package design.pattern.systemdesign.chess;

import design.pattern.systemdesign.chess.piece.Piece;
import design.pattern.systemdesign.chess.piece.PieceType;

public class Cell {
    private Position position;
    private Piece piece;

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    private PieceType pieceType;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell(Position position, Piece piece, PieceType pieceType) {
        this.position = position;
        this.piece = piece;
        this.pieceType = pieceType;
    }
}
