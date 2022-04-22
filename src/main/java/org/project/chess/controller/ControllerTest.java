package org.project.chess.controller;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.project.chess.strategy.MoveStrategy;
import org.project.chess.utils.ChessPieces;
import org.project.chess.utils.CircleStorageStructure;
import org.project.chess.utils.Coordinate;
import org.project.chess.utils.PositionStorageStructure;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerTest implements Initializable {

    public Circle C,C9,C91,C911,C9111,C91111,C911111,C9111111;
    public Circle C10,C101,C1011,C10111,C101111,C1011111,C10111111,C101111111;
    public Circle C102,C1021,C10211,C102111,C1021111,C10211111,C102111111,C1021111111;
    public Circle C1022,C10221,C102211,C1022111,C10221111,C102211111,C1022111111,C10221111111;
    public Circle C10222,C102221,C1022211,C10222111,C102221111,C1022211111,C10222111111,C102221111111;
    public Circle C1022212,C1022213,C1022214,C1022215,C1022216,C1022217;
    public Circle C10222112,C10222113,C10222114,C10222115,C10222116,C10222117;
    public Circle C102221112,C102221113,C102221114,C102221115,C102221116,C102221117;
    public Circle C1022211112, C1022211113,C1022211114,C10222111112, C10222111113,C102221111112;
    public Rectangle A1,A2,A3,A4,A5,A6,A7,A8;
    public Rectangle B1,B2,B3,B4,B5,B6,B7,B8;
    public Rectangle C1,C2,C3,C4,C5,C6,C7,C8;
    public Rectangle D1,D2,D3,D4,D5,D6,D7,D8;
    public Rectangle E1,E2,E3,E4,E5,E6,E7,E8;
    public Rectangle F1,F2,F3,F4,F5,F6,F7,F8;
    public Rectangle G1,G2,G3,G4,G5,G6,G7,G8;
    public Rectangle H1,H2,H3,H4,H5,H6,H7,H8;

    public ImageView b_pawn_8,b_pawn_7,b_pawn_6,b_pawn_5,b_pawn_4,b_pawn_3,b_pawn_2,b_pawn_1;
    public ImageView b_bishop_2,b_bishop_1;
    public ImageView b_rook_1,b_rook_2;
    public ImageView b_knight_2,b_knight_1;
    public ImageView b_queen,b_king;
    public ImageView w_pawn_1,w_pawn_2,w_pawn_3,w_pawn_4,w_pawn_7,w_pawn_6,w_pawn_5,w_pawn_8;
    public ImageView w_bishop_1,w_bishop_2;
    public ImageView w_rook_1,w_rook_2;
    public ImageView w_knight_2,w_knight_1;
    public ImageView w_king,w_queen;

    PositionStorageStructure pss;
    CircleStorageStructure csse;
    MoveStrategy ms;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ms = new MoveStrategy();

        csse = new CircleStorageStructure();
        csse.fillInAllStore(new Circle[][]
                {
                        {C,C9,C91,C911,C9111,C91111,C911111,C9111111},
                        {C10,C101,C1011,C10111,C101111,C1011111,C10111111,C101111111},
                        {C102,C1021,C10211,C102111,C1021111,C10211111,C102111111,C1021111111},
                        {C1022,C10221,C102211,C1022111,C10221111,C102211111,C1022111111,C10221111111},
                        {C10222,C102221,C1022211,C10222111,C102221111,C1022211111,C10222111111,C102221111111},
                        {C1022212,C1022213,C1022214,C1022215,C1022216,C1022217},
                        {C10222112,C10222113,C10222114,C10222115,C10222116,C10222117},
                        {C102221112,C102221113,C102221114,C102221115,C102221116,C102221117},
                        {C1022211112, C1022211113,C1022211114,C10222111112, C10222111113,C102221111112}
                });

        pss = new PositionStorageStructure(false);
        pss.fillInAllRectangle(new Rectangle[][]
                {
                        {A1,A2,A3,A4,A5,A6,A7,A8},
                        {B1,B2,B3,B4,B5,B6,B7,B8},
                        {C1,C2,C3,C4,C5,C6,C7,C8},
                        {D1,D2,D3,D4,D5,D6,D7,D8},
                        {E1,E2,E3,E4,E5,E6,E7,E8},
                        {F1,F2,F3,F4,F5,F6,F7,F8},
                        {G1,G2,G3,G4,G5,G6,G7,G8},
                        {H1,H2,H3,H4,H5,H6,H7,H8}
                });
        pss.readDefaultPosition(true,true);
        pss.createStorageStructure();
    }

    public boolean chessPieceSelected = false;

    public void onMouseEntered(MouseEvent mouseEvent) {
        if (!chessPieceSelected) {
            ImageView imageView = (ImageView) mouseEvent.getSource();
            double xPos = imageView.getLayoutX();
            double yPos = imageView.getLayoutY();
            //System.out.println("enter position: x :"+xPos+" y :"+yPos);
            pss.findAndMark(xPos,yPos,true,true);
        }
    }

    public void onMouseExited(MouseEvent mouseEvent) {
        if (!chessPieceSelected) {
            ImageView imageView = (ImageView) mouseEvent.getSource();
            double xPos = imageView.getLayoutX();
            double yPos = imageView.getLayoutY();
            //System.out.println("exit position: x :"+xPos+" y :"+yPos);
            pss.findAndMark(xPos,yPos,false,true);
        }
    }

    public boolean count = true;
    public double lastSelectedX = -1,lastSelectedY = -1;

    public void onMouseClicked_Black(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        double xPos = imageView.getLayoutX();
        double yPos = imageView.getLayoutY();
        if (!chessPieceSelected) {
            chessPieceSelected = true;
            lastSelectedX = xPos;
            lastSelectedY = yPos;
            ArrayList<Coordinate> pos = ms.calculateMovablePlaces(pss,xPos,yPos);
            //System.out.println(pos.size());
            for (Coordinate c : pos) {
                csse.findAndMarkAndShow(c,count);
            }
            count = !count;
        } else {
            if (lastSelectedX==xPos && lastSelectedY==yPos) {
                chessPieceSelected = false;
                lastSelectedX = -1;
                lastSelectedY = -1;
                ArrayList<Coordinate> pos = ms.calculateMovablePlaces(pss,xPos,yPos);
                //System.out.println(pos.size());
                for (Coordinate c : pos) {
                    csse.findAndMarkAndShow(c,count);
                }
                count = !count;
            }
        }
    }

    public void onMouseClicked_White(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        double xPos = imageView.getLayoutX();
        double yPos = imageView.getLayoutY();
        //ArrayList<Coordinate> pos = ms.calculateMovablePlaces(pss,xPos,yPos);
    }

}
