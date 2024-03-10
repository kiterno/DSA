package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public class PieceGeneratorFactory {
    public static Piece getPiece(PieceType pieceType, Position position, Color color) {
        switch (pieceType) {
            case KING -> {
                return new King(position, color);
            }
            case KNIGHT -> {
                return new Knight(position, color);
            }
            case ROOK -> {
                return new Rook(position, color);
            }
            case QUEEN -> {
                return new Queen(position, color);
            }
            case BISHOP -> {
                return new Bishop(position, color);
            }
            default -> {
                return new Pawn(position, color);
            }
        }
    }
}
