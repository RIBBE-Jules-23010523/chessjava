package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    public boolean isValidMove(int x, int y, ChessPlate plate) {
        List<int[]> legalMoves = getLegalMoves(plate);
        for (int[] move : legalMoves) {
            if (move[0] == x && move[1] == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidAttack(int x, int y) {
        return isValidMove(x, y);
    }

    @Override
    public String toString() {
        return "Rook";
    }

    //Méthode pour les déplacements de la tour
    public List<int[]> getLegalMoves(ChessPlate plate) {
        List<int[]> legalMoves = new ArrayList<>();
        int[] directions = {1, -1, 0};
        for (int direction : directions) {
            for (int i = 1; i < 8; i++) {
                int x = locationX + i * direction;
                int y = locationY + i * direction;
                if (x < 0 || x >= 8 || y < 0 || y >= 8) {
                    break;
                }
                if (plate.getPiece(x, y) == null) {
                    legalMoves.add(new int[]{x, y});
                } else {
                    if (plate.getPiece(x, y).pieceColor != pieceColor) {
                        legalMoves.add(new int[]{x, y});
                    }
                    break;
                }
            }
        }
        return legalMoves;
    }

}
