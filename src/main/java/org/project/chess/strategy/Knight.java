package org.project.chess.strategy;

import org.project.chess.utils.ChessPieces;
import org.project.chess.utils.Coordinate;

import java.util.ArrayList;

public class Knight implements ChessPieces {
    @Override
    public ArrayList<Coordinate> calculateMovablePlaces(double xPos, double yPos, int[] board) {
        ArrayList<Coordinate> res = new ArrayList<>();
        int abX = (int)((xPos-BOARD_X_MIN)/WALK_LENGTH);
        int abY = (int)((yPos-BOARD_Y_MIN)/WALK_LENGTH);
        if (isMovable(abX,abY,board,1)) {
            res.add(new Coordinate(((abX-1)*WALK_LENGTH+BOARD_X_MIN),((abY-2)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-1,abY-2)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,2)) {
            res.add(new Coordinate(((abX-2)*WALK_LENGTH+BOARD_X_MIN),((abY-1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-2,abY-1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,3)) {
            res.add(new Coordinate(((abX+1)*WALK_LENGTH+BOARD_X_MIN),((abY-2)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+1,abY-2)]*board[t(abX, abY)]==0));
        }
        if (isMovable(abX,abY,board,4)) {
            res.add(new Coordinate(((abX+2)*WALK_LENGTH+BOARD_X_MIN),((abY-1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+2,abY-1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,5)) {
            res.add(new Coordinate((((abX-1))*WALK_LENGTH+BOARD_X_MIN),((abY+2)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-1,abY+2)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,6)) {
            res.add(new Coordinate(((abX-2)*WALK_LENGTH+BOARD_X_MIN),((abY+1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX-2,abY+1)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,7)) {
            res.add(new Coordinate(((abX+1)*WALK_LENGTH+BOARD_X_MIN),((abY+2)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+1,abY+2)]*board[t(abX,abY)]==0));
        }
        if (isMovable(abX,abY,board,8)) {
            res.add(new Coordinate(((abX+2)*WALK_LENGTH+BOARD_X_MIN),((abY+1)*WALK_LENGTH+BOARD_Y_MIN),board[t(abX+2,abY+1)]*board[t(abX,abY)]==0));
        }
        return res;
    }

    public boolean isMovable(int abX, int abY, int[] board,int dir) {
        if (dir==1) {
            //UL1
            if (abY==0 || abY==1 || abX==0) return false;
            return board[t(abX-1,abY-2)]*board[t(abX,abY)]<=0;
        } else if (dir==2) {
            //UL2
            if (abY==0 || abX==0 || abX==1) return false;
            return board[t(abX-2,abY-1)]*board[t(abX,abY)]<=0;
        } else if (dir==3) {
            //UR1
            if (abY==0 || abY==1 || abX==7) return false;
            return board[t(abX+1,abY-2)]*board[t(abX, abY)]<=0;
        } else if (dir==4) {
            //UR2
            if (abY==0 || abX==7 || abX==6) return false;
            return board[t(abX+2,abY-1)]*board[t(abX,abY)]<=0;
        } else if (dir==5) {
            //DL1
            if (abY==6 || abY==7 || abX==0) return false;
            return board[t(abX-1,abY+2)]*board[t(abX,abY)]<=0;
        } else if (dir==6) {
            //DL2
            if (abY==7 || abX==0 || abX==1) return false;
            return board[t(abX-2,abY+1)]*board[t(abX,abY)]<=0;
        } else if (dir==7) {
            //DR1
            if (abY==7 || abX==7 || abY==6) return false;
            return board[t(abX+1,abY+2)]*board[t(abX,abY)]<=0;
        } else if (dir==8) {
            //DR2
            if (abY==7 || abX==7 || abX==6) return false;
            return board[t(abX+2,abY+1)]*board[t(abX,abY)]<=0;
        } else return false;
    }

    @Override
    public int t(int abX, int abY) {
        return abY*8+abX;
    }
}
