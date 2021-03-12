package com.company.boardGame;

public class Position {
    private int row;
    private int column;

    public Position(int rows, int columns) {
        this.row = rows;
        this.column = columns;
    }

    public int getRows() {
        return row;
    }

    public void setRows(int rows) {
        this.row = rows;
    }

    public int getColumns() {
        return column;
    }

    public void setColumns(int columns) {
        this.column = columns;
    }

    @Override
    public final String toString(){
        return row + ", " + column;
    }

}
