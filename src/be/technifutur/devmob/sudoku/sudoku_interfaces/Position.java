package be.technifutur.devmob.sudoku.sudoku_interfaces;

public interface Position {
    int getPos();
    int getCol();
    int getRow();
    int getSector();
    int getRowSector();
    int getColSector();
}
