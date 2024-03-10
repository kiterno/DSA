package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public class Knight extends Piece {
    public Knight(Position position, Color color) {
        super(position, color);
    }

    @Override
    public boolean move(Position position) {
        return (Math.abs(this.position.x - position.x) == 2 && Math.abs(this.position.y - position.y) == 1) || (Math.abs(this.position.x - position.x) == 1 && Math.abs(this.position.y - position.y) == 2);
    }
}
