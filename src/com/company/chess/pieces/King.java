package com.company.chess.pieces;

import com.company.boardGame.Board;
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
}
