package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public class Pawn extends Piece {

    public Pawn(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean move(Position position) {
        return position.y - this.position.y == 1 || (position.y - this.position.y  == 1 && Math.abs(position.x - this.position.x) == 1);
    }
}
