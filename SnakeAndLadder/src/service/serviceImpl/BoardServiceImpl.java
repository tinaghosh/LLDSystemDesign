package service.serviceImpl;

import module.*;
import service.BoardService;
import java.util.concurrent.ThreadLocalRandom;

public class BoardServiceImpl implements BoardService {

    Board board;

    public BoardServiceImpl(Board board){
        this.board = board;
    }

    @Override
    public void initializeCells() {
       for(int i=0;i<board.getBoardSize();i++){
           for(int j=0;j<board.getBoardSize();j++){
               Cell cell = new Cell();
               board.getCells()[i][j] = cell;
           }
       }
    }

    @Override
    public void addSnakesAndLadders() {
       int noOfSnakes = board.getNoOfSnakes();
       int noOfLadders = board.getNoOfLadders();
       int totalNoOfCells = board.getBoardSize() * board.getBoardSize();

       while(noOfSnakes>0){
           int snakeHead = ThreadLocalRandom.current().nextInt(1,totalNoOfCells);
           int snakeTail = ThreadLocalRandom.current().nextInt(1,totalNoOfCells);
           if(snakeTail >= snakeHead){
               continue;
           }
           Jump snake = new Snake(snakeHead,snakeTail);
           Cell cell = getCells(snakeHead);
           cell.setJump(snake);

        noOfSnakes--;
       }

        while(noOfLadders>0){

            int ladderStart = ThreadLocalRandom.current().nextInt(1,totalNoOfCells);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,totalNoOfCells);

            if(ladderStart >= ladderEnd){
                continue;
            }

            Jump ladder = new Ladder(ladderStart,ladderEnd);
            Cell cell = getCells(ladderStart);
            cell.setJump(ladder);

         noOfLadders--;
        }
    }

    @Override
    public Cell getCells(int position) {
        int boardRow = (position-1) / board.getBoardSize();
        int boardCol = (position-1) % board.getBoardSize();
        return board.getCells()[boardRow][boardCol];
    }
}
