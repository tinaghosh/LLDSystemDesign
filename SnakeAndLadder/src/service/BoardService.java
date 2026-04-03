package service;

import module.Cell;

public interface BoardService {

    public void initializeCells();
    public void addSnakesAndLadders();
    public Cell getCells(int position);

}
