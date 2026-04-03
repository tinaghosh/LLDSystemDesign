package controller;

import model.board.Board;
import model.board.Pair;
import model.piece.Piece;
import model.piece.PieceO;
import model.piece.PieceX;
import model.player.Player;
import service.BoardService;
import service.serviceImpl.BoardServiceImpl;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Deque<Player> players;
    Board board;
    BoardService boardService;

    public void initializeGame(){

        this.players = new LinkedList<>();

        Player player1 = new Player();
        player1.setName("Tina");
        player1.setPiece(new PieceX());

        Player player2 = new Player();
        player2.setName("Sandy");
        player2.setPiece(new PieceO());

        players.add(player1);
        players.add(player2);

        this.board = new Board(3);
        boardService = new BoardServiceImpl(board);
    }

    public String startGame(){

       boolean noWinner = true;

       while(noWinner){

           //Print initial stage of the board
           boardService.printBoard();

           //get the free space from the board
           List<Pair> freeCells = boardService.getFreeCells();
           if(freeCells.isEmpty()){
               noWinner = false;
               continue;
           }

           //get the Player whose turn is
           Player playerTurn = players.removeFirst();

           //read the user input
           System.out.println("Player : "+playerTurn.getName()+" Enter row and column seperated by comma : ");
           Scanner scanner = new Scanner(System.in);
           String s = scanner.nextLine();
           String[] values = s.split(",");
           int inputRow = Integer.parseInt(values[0]);
           int inputCol = Integer.parseInt(values[1]);

           //Add the Piece
           boolean pieceAddedSuccessfully = boardService.addPiece(inputRow,inputCol,playerTurn.getPiece());
           if(!pieceAddedSuccessfully){
               //player can not insert the piece into this cell, player has to choose another cell
               System.out.println("Incorrect position chosen, try again");
               players.addFirst(playerTurn);
               continue;
           }

           //Add the player again end of the queue for his next turn
           players.addLast(playerTurn);

           //Check the winner if applicable
           boolean winner = isThereWinner(inputRow,inputCol,playerTurn.getPiece());

           //If Winner is there then announce the name of the winner
           if(winner){
               return playerTurn.getName();
           }
       }
        return "Tie";
    }

    public boolean isThereWinner(int row, int column, Piece piece){

        int rowMatch = 0;
        int columnMatch = 0;
        int diagonalMatch = 0;
        int antiDiagonalMatch = 0;

        //All row Matching
        for(int i=0;i<board.getSize();i++){
            if(board.getBoard()[row][i]!=null && board.getBoard()[row][i].getPieceType() == piece.getPieceType()){
                rowMatch++;
            }
        }

        //All column Matching
        for(int i=0;i<board.getSize();i++){
            if(board.getBoard()[i][column]!=null && board.getBoard()[i][column].getPieceType() == piece.getPieceType()){
                columnMatch++;
            }
        }

        // Diagonal Matching
        if(row==column) {
            for (int i = 0; i < board.getSize(); i++) {
                if (board.getBoard()[i][i] != null && board.getBoard()[i][i].getPieceType() == piece.getPieceType()) {
                    diagonalMatch++;
                }
            }
        }
       //Anti Diagonal Matching
        if(row+column== board.getSize()-1) {
            for (int i = 0, j = board.getSize() - 1; i < board.getSize(); i++, j--) {
                if (board.getBoard()[i][j] != null && board.getBoard()[i][j].getPieceType() == piece.getPieceType()) {
                    antiDiagonalMatch++;
                }
            }
        }

      return (rowMatch == board.getSize()) || (columnMatch == board.getSize()) ||
              (diagonalMatch == board.getSize()) || (antiDiagonalMatch == board.getSize());
    }
}
