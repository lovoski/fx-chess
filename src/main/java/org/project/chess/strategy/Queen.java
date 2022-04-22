package org.project.chess.strategy;

import org.project.chess.utils.ChessPieces;
import org.project.chess.utils.Coordinate;

import java.util.ArrayList;

public class Queen implements ChessPieces {
    @Override
    public ArrayList<Coordinate> calculateMovablePlaces(double xPos, double yPos, int[] board) {
        ArrayList<Coordinate> res = new ArrayList<>();
        int abX = (int)((xPos-BOARD_X_MIN)/WALK_LENGTH);
        int abY = (int)((yPos-BOARD_Y_MIN)/WALK_LENGTH);
        process(res,abX,abY,board,-1,-1);
        process(res,abX,abY,board,-1,1);
        process(res,abX,abY,board,1,-1);
        process(res,abX,abY,board,1,1);
        process(res,abX,abY,board,-1,0);
        process(res,abX,abY,board,0,1);
        process(res,abX,abY,board,1,0);
        process(res,abX,abY,board,0,-1);
        return res;
    }

    public void process(ArrayList<Coordinate> res,int abX,int abY,int[] board,int xP,int yP) {
        int X = abX+xP,Y = abY+yP;
        while (true) {
            if (X>7 || X<0 || Y>7 || Y<0) break;
            int type = board[t(X,Y)]*board[t(abX,abY)];
            if (type!=0) {
                if (type<0) {
                    res.add(new Coordinate((X*WALK_LENGTH+BOARD_X_MIN),(Y*WALK_LENGTH+BOARD_Y_MIN),false));
                }
                break;
            } else {
                res.add(new Coordinate((X*WALK_LENGTH+BOARD_X_MIN),(Y*WALK_LENGTH+BOARD_Y_MIN),true));
                X+=xP;
                Y+=yP;
            }
        }
    }

    @Override
    public int t(int abX, int abY) {
        return abX+abY*8;
    }
}
