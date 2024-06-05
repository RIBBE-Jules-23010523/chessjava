package com.example.echecsae.game.pieces;
public class Pawn extends Piece {

    public Pawn(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    //@Override
    public boolean isValidMove(int x, int y) {
        return (x == locationX || y == locationY);
    }

    //@Override
    public boolean isValidAttack(int x, int y) {
        return isValidMove(x, y);
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
