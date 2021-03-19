package com.company.chess.pieces;

import com.company.boardGame.Board;
import com.company.boardGame.Position;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "N";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p== null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above

        p.setValues(position.getRows()-2, position.getColumns()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        p.setValues(position.getRows()-2, position.getColumns()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //bellow

        p.setValues(position.getRows()+2, position.getColumns()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        p.setValues(position.getRows()+2, position.getColumns()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //left

        p.setValues(position.getRows()-1, position.getColumns()-2);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        p.setValues(position.getRows()+1, position.getColumns()-2);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //right

        p.setValues(position.getRows()-1, position.getColumns()+2);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        p.setValues(position.getRows()+1, position.getColumns()+2);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        return mat;
    }
}
