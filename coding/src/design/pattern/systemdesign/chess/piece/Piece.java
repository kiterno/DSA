package design.pattern.systemdesign.chess.piece;

import design.pattern.systemdesign.chess.Color;
import design.pattern.systemdesign.chess.Position;

public abstract class Piece {
    public Position position;
    public Color color;

    public Piece(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract boolean move(Position position);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
