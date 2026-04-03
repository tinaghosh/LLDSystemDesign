package module;

public class Board {

    Cell[][] cells;
    int boardSize;
    int noOfSnakes;
    int noOfLadders;

    public int getNoOfSnakes() {
        return noOfSnakes;
    }

    public void setNoOfSnakes(int noOfSnakes) {
        this.noOfSnakes = noOfSnakes;
    }

    public int getNoOfLadders() {
        return noOfLadders;
    }

    public void setNoOfLadders(int noOfLadders) {
        this.noOfLadders = noOfLadders;
    }

    public Board (int size){
        this.boardSize = size;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
