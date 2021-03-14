package com.company.chess.pieces;

import com.company.boardGame.Board;
import com.company.boardGame.Position;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
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
        p.setValues(position.getRows()-1, position.getColumns());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //below
        p.setValues(position.getRows()+1, position.getColumns());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //left
        p.setValues(position.getRows(), position.getColumns()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //right
        p.setValues(position.getRows(), position.getColumns()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //above-left
        p.setValues(position.getRows()-1, position.getColumns()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //above-right
        p.setValues(position.getRows()-1, position.getColumns()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //below-left
        p.setValues(position.getRows()+1, position.getColumns()-1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //below-right
        p.setValues(position.getRows()+1, position.getColumns()+1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        return mat;
    }
}
