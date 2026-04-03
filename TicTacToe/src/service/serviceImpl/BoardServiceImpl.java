package service.serviceImpl;

import model.board.Board;
import model.board.Pair;
import model.piece.Piece;
import service.BoardService;

import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService {

    Board board;

    public BoardServiceImpl(Board board){
        this.board = board;
    }

    @Override
    public void printBoard() {

     for(int i=0;i<board.getSize();i++){
         for(int j=0;j<board.getSize();j++){
             if(board.getBoard()[i][j]!=null){
                 System.out.print(board.getBoard()[i][j].getPieceType().name()+"   ");
             }else{
                 System.out.print("   ");
             }
             System.out.print(" | ");
         }
         System.out.println();
       }
    }

    @Override
    public boolean addPiece(int row, int col, Piece piece) {

        if(board.getBoard()[row][col]!=null) {
          return false;
        }else{
            board.getBoard()[row][col] = piece;
            return true;
        }
    }

    @Override
    public List<Pair> getFreeCells() {

        List<Pair> listOfFreeCells = new ArrayList<>();

        for(int i=0;i<board.getSize();i++){
            for(int j=0;j< board.getSize();j++){
                if(board.getBoard()[i][j]==null){
                    listOfFreeCells.add(new Pair(i,j));
                }
            }
        }
        return listOfFreeCells;
    }
}
