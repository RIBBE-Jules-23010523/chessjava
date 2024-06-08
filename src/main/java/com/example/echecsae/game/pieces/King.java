package com.example.echecsae.game.pieces;

import com.example.echecsae.game.ChessPlate;

/**
 * Cette classe représente un roi dans le jeu d'échecs.
 */
public class King extends Piece {

    /**
     * Constructeur de la classe King.
     * @param name le nom de la pièce.
     * @param color la couleur de la pièce.
     * @param pieceColor le code couleur de la pièce.
     * @param locationX la position x de la pièce.
     * @param locationY la position y de la pièce.
     */
    public King(String name, String color, int pieceColor, int locationX, int locationY) {
        super(name, color, pieceColor, locationX, locationY);
    }

    /**
     * Cette méthode retourne les mouvements valides du roi.
     * @param board l'échiquier.
     * @return un tableau des mouvements valides.
     * Le roi peut se déplacer d'une case dans n'importe quelle direction.
     */
    public int[][] validMoves(ChessPlate board) {
        int[][] moves = new int[8][2];
        int i = 0;

        int[][] moveOffsets = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
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
     * Cette méthode vérifie si un mouvement est valide pour le roi.
     * @param x la position x du mouvement.
     * @param y la position y du mouvement.
     * @return vrai si le mouvement est valide, faux sinon.
     */
    @Override
    public boolean isValidMove(int x, int y) {
        return false;
    }

    /**
     * Cette méthode retourne la représentation en chaîne de caractères du roi.
     * @return la représentation en chaîne de caractères du roi.
     */
    @Override
    public String toString() {
        return "King";
    }
}
