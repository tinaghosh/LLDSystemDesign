package service;

import model.board.Pair;
import model.piece.Piece;
import java.util.List;

public interface BoardService{

    void printBoard();
    boolean addPiece(int row, int col, Piece piece);
    List<Pair> getFreeCells();

}
