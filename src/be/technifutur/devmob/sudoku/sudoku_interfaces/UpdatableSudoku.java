package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.SudokuException;

public interface UpdatableSudoku {
    boolean isComplete();
    boolean add(Position pos, char c) throws SudokuException;
    boolean update(Position pos, char c) throws SudokuException;
    boolean delete(Position pos) throws SudokuException;
}
