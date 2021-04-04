package com.company.chess.pieces;

import com.company.boardGame.Board;
import com.company.boardGame.Position;
import com.company.chess.ChessMatch;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p!= null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingSide rook
            Position posT1 = new Position(position.getRows(), position.getColumns() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRows(), position.getColumns() + 1);
                Position p2 = new Position(position.getRows(), position.getColumns() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRows()][position.getColumns() + 2] = true;
                }
            }
            // #specialmove castling queenSide rook
            Position posT2 = new Position(position.getRows(), position.getColumns() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRows(), position.getColumns() - 1);
                Position p2 = new Position(position.getRows(), position.getColumns() - 2);
                Position p3 = new Position(position.getRows(), position.getColumns() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRows()][position.getColumns() - 2] = true;
                }
            }
        }

        return mat;
    }
}
