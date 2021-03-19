package com.company.chess.pieces;

import com.company.boardGame.Board;
import com.company.boardGame.Position;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above
        p.setValues(position.getRows() -1, position.getColumns());
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setRows(p.getRows() -1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //below
        p.setValues(position.getRows() +1, position.getColumns());
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setRows(p.getRows() +1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //left
        p.setValues(position.getRows(), position.getColumns()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setColumns(p.getColumns() -1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //right
        p.setValues(position.getRows(), position.getColumns()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setColumns(p.getColumns() +1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // bishop moves

        //above - right
        p.setValues(position.getRows() -1, position.getColumns()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setValues(p.getRows() -1, p.getColumns()+1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //above-left
        p.setValues(position.getRows() -1, position.getColumns()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setValues(p.getRows() -1, p.getColumns()-1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //bellow-left
        p.setValues(position.getRows()+1, position.getColumns()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setValues(p.getRows() +1, p.getColumns()-1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        //bellow-right
        p.setValues(position.getRows()+1, position.getColumns()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
            p.setValues(p.getRows() +1, p.getColumns()+1);
        }

        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        return mat;
    }
}
