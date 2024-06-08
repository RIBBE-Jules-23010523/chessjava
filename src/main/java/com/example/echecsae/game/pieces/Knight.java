package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

/**
 * Cette classe représente le cavalier du jeu d'échecs.
 */
public class Knight extends Piece {

    /**
     * Constructeur de la classe Knight.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param pieceColor le code couleur de la pièce.
     * @param locationX la position x de la pièce.
     * @param locationY la position y de la pièce.
     */
    public Knight(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    /**
     * Cette méthode retourne les mouvements valides du cavalier.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     * Le cavalier peut se déplacer en L, c'est-à-dire de deux cases dans une direction et une case dans une direction perpendiculaire.
     */
    public int[][] validMoves(ChessPlate board) {
        int[][] moves = new int[8][2];
        int i = 0;

        int[][] moveOffsets = {
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        for (int[] offset : moveOffsets) {
            int x = getX() + offset[0];
            int y = getY() + offset[1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board.getPiece(x, y) == null || !isSameColor(board.getPiece(x, y))) {
                    moves[i][0] = x;
                    moves[i][1] = y;
                    i++;
                }
            }
        }
        int[][] validMoves = new int[i][2];
        System.arraycopy(moves, 0, validMoves, 0, i);
        return validMoves;
    }

    /**
     * Cette méthode vérifie si un mouvement est valide pour le cavalier.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        return false;
    }

    /**
     * Cette méthode retourne la représentation en chaîne de caractères du cavalier.
     * @return la représentation en chaîne de caractères du cavalier.
     */
    @Override
    public String toString() {
        return "Knight";
    }
}
