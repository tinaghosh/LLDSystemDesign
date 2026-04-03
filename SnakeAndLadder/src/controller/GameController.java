package controller;

import module.*;
import service.BoardService;
import service.DiceService;
import service.serviceImpl.BoardServiceImpl;
import service.serviceImpl.DiceServiceImpl;

import java.util.Deque;
import java.util.LinkedList;

public class GameController {

    Board board;
    Deque<Player> players;
    Dice dice;
    public static GameController gameInstance = null;
    BoardService boardService;
    Player winner;
    DiceService diceService;

    public GameController(){
        initializeGame();
    }

    public static GameController getInstance(){
        if(gameInstance==null){
           return new GameController();
        }
       return gameInstance;
    }

    public void initializeGame(){

        board = new Board(10);
        board.setBoardSize(10);
        board.setNoOfLadders(4);
        board.setNoOfSnakes(5);
        board.setCells(new Cell[board.getBoardSize()][board.getBoardSize()]);

        boardService = new BoardServiceImpl(board);
        boardService.initializeCells();
        boardService.addSnakesAndLadders();

        dice = new Dice();

        players = new LinkedList<>();

        Player player1 = new Player();
        player1.setName("Tina");
        player1.setCurrentPosition(1);

        Player player2 = new Player();
        player2.setName("Sandy");
        player2.setCurrentPosition(1);

        players.add(player1);
        players.add(player2);

        winner = null;

        diceService = new DiceServiceImpl(dice);

    }

    public void startGame(){

        while(winner==null){

            //Player details
            Player playerTurn = findPlayersTurn();
            System.out.println("player turn is:" + playerTurn.getName() + " current position is: " + playerTurn.getCurrentPosition());

            //dice value
            int diceNumber = diceService.rollDice();

            //Player next Position
            int playerNextPosition = playerTurn.getCurrentPosition()+diceNumber;

            //if after adding the dice value its exeding the total no of cells  then revert it to current position
            if(playerNextPosition > board.getBoardSize() * board.getBoardSize()){
                playerNextPosition = playerTurn.getCurrentPosition();
            }

            playerNextPosition = currentCellSnakeOrLaderCheck(playerNextPosition);
            playerTurn.setCurrentPosition(playerNextPosition);

            System.out.println("player turn is:" + playerTurn.getName() + " new Position is: " + playerNextPosition);

            if(playerNextPosition == board.getBoardSize() * board.getBoardSize()){
                winner = playerTurn;
            }
        }
        System.out.println("Winner of the Snake and Lader Game is : "+winner.getName());
    }

    public Player findPlayersTurn(){
        Player playerTurn = players.removeFirst();
        players.addLast(playerTurn);
        return playerTurn;
    }

    public int currentCellSnakeOrLaderCheck(int currentPosition){

        Cell cell = boardService.getCells(currentPosition);
        if(cell.getJump()!=null && cell.getJump().getStart() == currentPosition){
            if(cell.getJump() instanceof Snake){
                System.out.println("Jump Done By Snake");
            }else if(cell.getJump() instanceof Ladder){
                System.out.println("Jump Done By Ladder");
            }
            return cell.getJump().getEnd();
        }
        return currentPosition;
    }
}
