package org.project.chess.strategy;

import org.project.chess.utils.ChessPieces;
import org.project.chess.utils.Coordinate;

import java.util.ArrayList;

public class King implements ChessPieces {

    @Override
    public ArrayList<Coordinate> calculateMovablePlaces(double xPos, double yPos, int[] board) {
        ArrayList<Coordinate> res = new ArrayList<>();
        int abX = (int)((xPos-BOARD_X_MIN)/WALK_LENGTH);
        int abY = (int)((yPos-BOARD_Y_MIN)/WALK_LENGTH);
        if (isMovable(abX,abY,board,1)) {
            res.add(new Coordinate(((abX)*WALK_LENGTH+BOARD_X_MIN),((abY-1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX,abY-1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,2)) {
            res.add(new Coordinate(((abX-1)*WALK_LENGTH+BOARD_X_MIN),((abY-1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-1,abY-1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,3)) {
            res.add(new Coordinate(((abX+1)*WALK_LENGTH+BOARD_X_MIN),((abY-1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+1,abY-1)]*board[t(abX, abY)]==0));
        }
        if (isMovable(abX,abY,board,4)) {
            res.add(new Coordinate(((abX-1)*WALK_LENGTH+BOARD_X_MIN),((abY)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-1,abY)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,5)) {
            res.add(new Coordinate((((abX+1))*WALK_LENGTH+BOARD_X_MIN),((abY)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+1,abY)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,6)) {
            res.add(new Coordinate(((abX)*WALK_LENGTH+BOARD_X_MIN),((abY+1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX,abY+1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,7)) {
            res.add(new Coordinate(((abX-1)*WALK_LENGTH+BOARD_X_MIN),((abY+1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-1,abY+1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,8)) {
            res.add(new Coordinate(((abX+1)*WALK_LENGTH+BOARD_X_MIN),((abY+1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+1,abY+1)]*board[t(abX,abY)]==0));
        }
        return res;
    }

    public boolean isMovable(int abX, int abY, int[] board,int dir) {
        if (dir==1) {
            //up
            if (abY==0) return false;
            return board[t(abX,abY-1)]*board[t(abX, abY)]<=0;
        } else if (dir==2) {
            //up left
            if (abX==0 || abY==0) return false;
            return board[t(abX-1,abY-1)]*board[t(abX, abY)]<=0;
        } else if (dir==3) {
            //up right
            if (abX==7 || abY==0) return false;
            return board[t(abX+1,abY-1)]*board[t(abX, abY)]<=0;
        } else if (dir==4) {
            //left
            if (abX==0) return false;
            return board[t(abX-1,abY)]*board[t(abX, abY)]<=0;
        } else if (dir==5) {
            //right
            if (abX==7) return false;
            return board[t(abX+1,abY)]*board[t(abX, abY)]<=0;
        } else if (dir==6) {
            //back
            if (abY==7) return false;
            return board[t(abX,abY+1)]*board[t(abX, abY)]<=0;
        } else if (dir==7) {
            //back left
            if (abY==7 || abX==0) return false;
            return board[t(abX-1,abY+1)]*board[t(abX, abY)]<=0;
        } else if (dir==8) {
            //back right
            if (abY==7 || abX==7) return false;
            return board[t(abX+1,abY+1)]*board[t(abX, abY)]<=0;
        } else return false;
    }

    @Override
    public int t(int abX, int abY) {
        return abX+abY*8;
    }
}
