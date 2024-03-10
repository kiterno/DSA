package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public class Bishop extends Piece {
    public Bishop(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean move(Position position) {

        if (Math.abs(position.y - this.position.y) == Math.abs(position.x - this.position.x) ) {

            int m = (position.y - this.position.y) == (position.x - this.position.x) ? 1 : -1;

            return this.position.y - m * this.position.x == position.y - m * position.x;
        }
        return false;
    }
}
