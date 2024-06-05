package com.example.echecsae.game.pieces;
public class Rook extends Piece {

    public Rook(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    public boolean isValidMove(int x, int y) {
        return (x == locationX || y == locationY);
    }

    public boolean isValidAttack(int x, int y) {
        return isValidMove(x, y);
    }

    @Override
    public String toString() {
        return "Rook";
    }
}
