package org.project.chess.strategy;

import org.project.chess.utils.Coordinate;
import org.project.chess.utils.PositionStorageStructure;

import java.util.ArrayList;

public class MoveStrategy {

    Pawn pawnMove = new Pawn();
    King kingMove = new King();
    Queen queenMove = new Queen();
    Rook rookMove = new Rook();
    Knight knightMove = new Knight();
    Bishop bishopMove = new Bishop();

    public MoveStrategy() {}

    public ArrayList<Coordinate> calculateMovablePlaces(PositionStorageStructure pss, double xPos, double yPos) {
        int type = pss.findAndReturnType(xPos, yPos);
        if ((type>=1 && type<=8) || (type<=-1 && type>=-8)) {
            return pawnMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else if ((type==9)||(type==10)||(type==-9)||(type==-10)) {
            return bishopMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else if ((type==11)||(type==12)||(type==-11)||(type==-12)) {
            return knightMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else if ((type==13)||(type==14)||(type==-13)||(type==-14)) {
            return rookMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else if ((type==15)||(type==-15)) {
            return kingMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else if ((type==16)||(type==-16)) {
            return queenMove.calculateMovablePlaces(xPos,yPos,pss.store_type);
        } else return null;
    }
}
