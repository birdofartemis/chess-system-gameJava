package com.company.chess.pieces;

import com.company.boardGame.Board;
import com.company.boardGame.Position;
import com.company.chess.ChessMatch;
import com.company.chess.ChessPiece;
import com.company.chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color,ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        if(getColor() == Color.WHITE){
            p.setValues(position.getRows() -1, position.getColumns());
            if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()] = true;
            }

            Position p2 = new Position(position.getRows() -1, position.getColumns());
            p.setValues(position.getRows() -2, position.getColumns());

            if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() == 0){
                mat[p.getRows()][p.getColumns()] = true;
            }
            p.setValues(position.getRows() -1, position.getColumns()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }

            p.setValues(position.getRows() -1, position.getColumns()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }

            //Special move en passant White
            if(position.getRows() == 3){
                Position left = new Position(position.getRows(), position.getColumns() -1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRows()-1][left.getColumns()] = true;
                }

                Position right = new Position(position.getRows(), position.getColumns() +1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[right.getRows()-1][right.getColumns()] = true;
                }
            }
        }

        else{
            p.setValues(position.getRows() +1, position.getColumns());
            if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)){
                mat[p.getRows()][p.getColumns()] = true;
            }

            Position p2 = new Position(position.getRows() +1, position.getColumns());
            p.setValues(position.getRows() +2, position.getColumns());

            if(getBoard().positionExists(p) && !getBoard().thereIsPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereIsPiece(p2) && getMoveCount() == 0){
                mat[p.getRows()][p.getColumns()] = true;
            }
            p.setValues(position.getRows() +1, position.getColumns()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }

            p.setValues(position.getRows() +1, position.getColumns()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRows()][p.getColumns()] = true;
            }

            //Special move en passant Black
            if(position.getRows() == 4){
                Position left = new Position(position.getRows(), position.getColumns() -1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left)
                        && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRows()+1][left.getColumns()] = true;
                }

                Position right = new Position(position.getRows(), position.getColumns() +1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right)
                        && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[right.getRows()+1][right.getColumns()] = true;
                }
            }
        }
        return mat;
    }
}
