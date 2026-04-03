package service;

import model.board.Pair;
import model.piece.Piece;

import java.util.List;

public interface BoardService{

    public void printBoard();
    boolean addPiece(int row, int col, Piece piece);
    public List<Pair> getFreeCells();

}
