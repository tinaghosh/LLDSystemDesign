package service;

import module.Cell;

public interface BoardService {

     void initializeCells();
     void addSnakesAndLadders();
     Cell getCells(int position);

}
