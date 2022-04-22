package org.project.chess.utils;

import java.util.ArrayList;

public interface ChessPieces {

    boolean SHOWING = true;

    int PIECE_SIZE_PIXEL = 64;
    int BOARD_LEFT_POINT_X = 30;
    int BOARD_LEFT_POINT_Y = 30;

    int BOARD_X_MIN = BOARD_LEFT_POINT_X;
    int BOARD_X_MAX = BOARD_LEFT_POINT_X+PIECE_SIZE_PIXEL*8;
    int BOARD_Y_MIN = BOARD_LEFT_POINT_Y;
    int BOARD_Y_MAX = BOARD_LEFT_POINT_Y+PIECE_SIZE_PIXEL*8;

    int WALK_LENGTH = PIECE_SIZE_PIXEL;

    int PAWN_WHITE_1 = 1;
    int PAWN_WHITE_2 = 2;
    int PAWN_WHITE_3 = 3;
    int PAWN_WHITE_4 = 4;
    int PAWN_WHITE_5 = 5;
    int PAWN_WHITE_6 = 6;
    int PAWN_WHITE_7 = 7;
    int PAWN_WHITE_8 = 8;
    int BISHOP_WHITE_1 = 9;
    int BISHOP_WHITE_2 = 10;
    int KNIGHT_WHITE_1 = 11;
    int KNIGHT_WHITE_2 = 12;
    int ROOK_WHITE_1 = 13;
    int ROOK_WHITE_2 = 14;
    int KING_WHITE = 15;
    int QUEEN_WHITE = 16;

    int PAWN_BLACK_1 = -1;
    int PAWN_BLACK_2 = -2;
    int PAWN_BLACK_3 = -3;
    int PAWN_BLACK_4 = -4;
    int PAWN_BLACK_5 = -5;
    int PAWN_BLACK_6 = -6;
    int PAWN_BLACK_7 = -7;
    int PAWN_BLACK_8 = -8;
    int BISHOP_BLACK_1 = -9;
    int BISHOP_BLACK_2 = -10;
    int KNIGHT_BLACK_1 = -11;
    int KNIGHT_BLACK_2 = -12;
    int ROOK_BLACK_1 = -13;
    int ROOK_BLACK_2 = -14;
    int KING_BLACK = -15;
    int QUEEN_BLACK = -16;

    ArrayList<Coordinate> calculateMovablePlaces(double xPos, double yPos,int[] board);

    int t(int abX,int abY);
}
