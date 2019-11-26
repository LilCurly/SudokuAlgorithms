package be.technifutur.devmob.sudoku.sudoku_interfaces;

import be.technifutur.devmob.sudoku.SudokuException;

import java.util.Set;

public interface UpdatableSudoku extends VisualSudoku {
    boolean isComplete();
    boolean add(Position pos, char c) throws SudokuException;
    boolean update(Position pos, char c) throws SudokuException;
    boolean delete(Position pos) throws SudokuException;
    int size();
    boolean isEmpty(Position p);
    Set<Character> remainingValues();
}
