package design.pattern.systemdesign.connect4.model;

public class Board {
    private int xSize;
    private int ySize;
    private Piece[][] board;

    public Board(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

        board = new Piece[xSize][ySize];
    }

    public boolean isBoardFull() {
        for (int i=0;i<ySize;i++) {
            if (board[0][i] == null) return false;
        }
        return true;
    }

    public boolean isCellEmpty(int y) {
        return y>=0 && y<ySize && board[0][y] == null;
    }

    public int move(int y, Piece piece) {
        int x = 0;
        while (x<xSize && board[x][y] == null) {
            x++;
        }

        board[x-1][y] = piece;
        return x-1;
    }

    public boolean checkIfGameEnded(int x, int y, Piece piece) {
        if (checkHorizontal(x, y, piece)) return true;
        if (checkVertical(x, y, piece)) return true;
        if (checkRightDiagnol(x, y, piece)) return true;
        if (checkLeftDiagonal(x, y, piece)) return true;

        return false;
    }

    private boolean checkLeftDiagonal(int x, int y, Piece piece) {
        int count = 1;
        for (int i=x+1, j=y-1; i<xSize && j>=0; i++, j--) {
            if (board[i][j] != null && board[i][j].getPieceType().equals(piece.getPieceType())) count++;
        }

        for (int i=x-1, j=y+1; i>=0 && j<ySize; i--, j++) {
            if (board[i][j] != null && board[i][j].getPieceType().equals(piece.getPieceType())) count++;
        }

        return count>=4;
    }

    private boolean checkRightDiagnol(int x, int y, Piece piece) {
        int count = 1;
        for (int i=x+1, j=y+1; i<xSize && j<ySize; i++, j++) {
            if (board[i][j] != null && board[i][j].getPieceType().equals(piece.getPieceType())) count++;
        }

        for (int i=x-1, j=y-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] != null && board[i][j].getPieceType().equals(piece.getPieceType())) count++;
        }

        return count>=4;
    }

    private boolean checkVertical(int x, int y, Piece piece) {
        int count = 1;
        for (int j=y-1;j>=0;j--) {
            if (board[x][j] != null && board[x][j].getPieceType().equals(piece.getPieceType())) count++;
        }
        for (int j=y+1;j<ySize;j++) {
            if (board[x][j] != null && board[x][j].getPieceType().equals(piece.getPieceType())) count++;
        }

        return count>=4;
    }

    private boolean checkHorizontal(int x, int y, Piece piece) {
        int count = 1;
        for(int i=x-1;i>=0;i--) {
            if (board[i][y] != null && board[i][y].getPieceType().equals(piece.getPieceType())) count++;
        }

        for (int i=x+1;i<xSize;i++) {
            if (board[i][y] != null && board[i][y].getPieceType().equals(piece.getPieceType())) count++;
        }

        return count>=4;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    public void display() {
        for (int i=0;i<xSize;i++) {
            for (int j = 0; j < ySize; j++) {
                System.out.print(board[i][j] == null ? null+"\t" : board[i][j].getPieceType() == PieceType.RED ?  board[i][j].getPieceType()+"\t\t" : board[i][j].getPieceType()+"\t");
            }
            System.out.println();
        }
    }
}
