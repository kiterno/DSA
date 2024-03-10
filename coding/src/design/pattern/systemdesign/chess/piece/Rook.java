package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public class Rook extends Piece {
    public Rook(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean move(Position position) {
        return (this.position.x == position.x && this.position.y != position.y) || (this.position.x != position.x && this.position.y == position.y);
    }
}
