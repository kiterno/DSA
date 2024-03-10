package design.pattern.systemdesign.chess;

import design.pattern.systemdesign.chess.piece.Piece;
import design.pattern.systemdesign.chess.piece.PieceGeneratorFactory;
import design.pattern.systemdesign.chess.piece.PieceType;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Cell[][] cells;
    int size;
    Map<String, Piece> whitePieces;
    Map<String, Piece> blackPieces;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];

        initializeBoard();
        displayBoard();
    }

    private void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] == null ? "O\t" : cells[i][j].getPieceType());
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println(whitePieces.keySet());
        System.out.println(blackPieces.keySet());
    }

    private void initializeBoard() {
        whitePieces = new HashMap<>();
        blackPieces = new HashMap<>();

        for (int i = 0; i < size; i++) {
            Position positionWhite = new Position(0, i);
            Position positionBlack = new Position(size-1, i);
            whitePieces.put(positionWhite.toString(), PieceGeneratorFactory.getPiece(PieceType.PAWN, positionWhite, Color.WHITE));
            blackPieces.put(positionBlack.toString(), PieceGeneratorFactory.getPiece(PieceType.PAWN, positionWhite, Color.BLACK));
            cells[0][i] = new Cell(positionWhite, whitePieces.get(positionWhite.toString()), PieceType.PAWN);
            cells[size-1][i] = new Cell(positionBlack, blackPieces.get(positionBlack.toString()), PieceType.PAWN);
        }

        Position positionWhiteRook = new Position(1, 0);
        Position positionWhiteRookRight = new Position(1, size-1);
        whitePieces.put(positionWhiteRook.toString(), PieceGeneratorFactory.getPiece(PieceType.ROOK, positionWhiteRook, Color.WHITE));
        whitePieces.put(positionWhiteRookRight.toString(), PieceGeneratorFactory.getPiece(PieceType.ROOK, positionWhiteRookRight, Color.WHITE));
        cells[positionWhiteRook.x][positionWhiteRook.y] = new Cell(positionWhiteRook, whitePieces.get(positionWhiteRook.toString()), PieceType.ROOK);
        cells[positionWhiteRookRight.x][positionWhiteRookRight.y] = new Cell(positionWhiteRookRight, whitePieces.get(positionWhiteRookRight.toString()), PieceType.ROOK);

        Position positionBlackRook = new Position(size-2, 0);
        Position positionBlackRookRight = new Position(size-2, size-1);
        blackPieces.put(positionBlackRook.toString(), PieceGeneratorFactory.getPiece(PieceType.ROOK, positionBlackRook, Color.BLACK));
        blackPieces.put(positionBlackRookRight.toString(), PieceGeneratorFactory.getPiece(PieceType.ROOK, positionBlackRookRight, Color.BLACK));
        cells[positionBlackRook.x][positionBlackRook.y] = new Cell(positionBlackRook, blackPieces.get(positionBlackRook.toString()), PieceType.ROOK);
        cells[positionBlackRookRight.x][positionBlackRookRight.y] = new Cell(positionBlackRookRight, blackPieces.get(positionBlackRookRight.toString()), PieceType.ROOK);

        Position positionWhiteBishop = new Position(1, 1);
        Position positionWhiteBishopRight = new Position(1, size-2);
        cells[positionWhiteBishop.x][positionWhiteBishop.y] = new Cell(positionWhiteBishop, PieceGeneratorFactory.getPiece(PieceType.BISHOP, positionWhiteBishop, Color.WHITE), PieceType.BISHOP);
        cells[positionWhiteBishopRight.x][positionWhiteBishopRight.y] = new Cell(positionWhiteBishopRight, PieceGeneratorFactory.getPiece(PieceType.BISHOP, positionWhiteBishopRight, Color.WHITE), PieceType.BISHOP);

        Position positionBlackBishop = new Position(size-2, 1);
        Position positionBlackBishopRight = new Position(size-2, size-2);
        cells[positionBlackBishop.x][positionBlackBishop.y] = new Cell(positionBlackBishop, PieceGeneratorFactory.getPiece(PieceType.BISHOP, positionBlackBishop, Color.BLACK), PieceType.BISHOP);
        cells[positionBlackBishopRight.x][positionBlackBishopRight.y] = new Cell(positionBlackBishopRight, PieceGeneratorFactory.getPiece(PieceType.BISHOP, positionBlackBishopRight, Color.BLACK), PieceType.BISHOP);

        Position positionWhiteKnight = new Position(1, 2);
        Position positionWhiteKnightRight = new Position(1, size-3);
        cells[positionWhiteKnight.x][positionWhiteKnight.y] = new Cell(positionWhiteKnight, PieceGeneratorFactory.getPiece(PieceType.KNIGHT, positionWhiteKnight, Color.WHITE), PieceType.KNIGHT);
        cells[positionWhiteKnightRight.x][positionWhiteKnightRight.y] = new Cell(positionWhiteKnightRight, PieceGeneratorFactory.getPiece(PieceType.KNIGHT, positionWhiteKnightRight, Color.WHITE), PieceType.KNIGHT);

        Position positionBlackKnight = new Position(size-2, 2);
        Position positionBlackKnightRight = new Position(size-2, size-3);
        cells[positionBlackKnight.x][positionBlackKnight.y] = new Cell(positionBlackKnight, PieceGeneratorFactory.getPiece(PieceType.KNIGHT, positionBlackKnight, Color.BLACK), PieceType.KNIGHT);
        cells[positionBlackKnightRight.x][positionBlackKnightRight.y] = new Cell(positionBlackKnightRight, PieceGeneratorFactory.getPiece(PieceType.KNIGHT, positionBlackKnightRight, Color.BLACK), PieceType.KNIGHT);

        Position positionWhiteQueen = new Position(1, 3);
        Position positionWhiteKing = new Position(1, size-4);
        cells[positionWhiteQueen.x][positionWhiteQueen.y] = new Cell(positionWhiteQueen, PieceGeneratorFactory.getPiece(PieceType.QUEEN, positionWhiteQueen, Color.WHITE), PieceType.QUEEN);
        cells[positionWhiteKing.x][positionWhiteKing.y] = new Cell(positionWhiteKing, PieceGeneratorFactory.getPiece(PieceType.KING, positionWhiteKing, Color.WHITE), PieceType.KING);

        Position positionBlackQueen = new Position(size-2, 3);
        Position positionBlackKing = new Position(size-2, size-4);
        cells[positionBlackQueen.x][positionBlackQueen.y] = new Cell(positionBlackQueen, PieceGeneratorFactory.getPiece(PieceType.QUEEN, positionBlackQueen, Color.BLACK), PieceType.QUEEN);
        cells[positionBlackKing.x][positionBlackKing.y] = new Cell(positionBlackKing, PieceGeneratorFactory.getPiece(PieceType.KING, positionBlackKing, Color.BLACK), PieceType.KING);

    }
}
