package org.project.chess.controller;

import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.project.chess.strategy.MoveStrategy;
import org.project.chess.utils.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerServer implements Initializable {

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

    public boolean moveMade = false;
    public boolean waitForMove = true;

    public PositionStorageStructure pss;
    public CircleStorageStructure csse;
    public ImageStorageStructure iss;
    public MoveStrategy ms;

    public ScrollPane scrollPane;
    public TextFlow textFlow;
    public Rectangle moveSign;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ms = new MoveStrategy();

        iss = new ImageStorageStructure();
        iss.fillInAllImage(new ImageNode[][]
                {
                        {new ImageNode(b_pawn_8,-8),new ImageNode(b_pawn_7,-7),new ImageNode(b_pawn_6,-6),new ImageNode(b_pawn_5,-5),new ImageNode(b_pawn_4,-4)
                                ,new ImageNode(b_pawn_3,-3),new ImageNode(b_pawn_2,-2),new ImageNode(b_pawn_1,-1)},
                        {new ImageNode(b_bishop_2,-10),new ImageNode(b_bishop_1,-9),new ImageNode(b_rook_1,-13),new ImageNode(b_rook_2,-14)},
                        {new ImageNode(b_knight_2,-12),new ImageNode(b_knight_1,-11),new ImageNode(b_queen,-16),new ImageNode(b_king,-15)},

                        {new ImageNode(w_pawn_8,8),new ImageNode(w_pawn_7,7),new ImageNode(w_pawn_6,6),new ImageNode(w_pawn_5,5),new ImageNode(w_pawn_4,4)
                                ,new ImageNode(w_pawn_3,3),new ImageNode(w_pawn_2,2),new ImageNode(w_pawn_1,1)},
                        {new ImageNode(w_bishop_2,10),new ImageNode(w_bishop_1,9),new ImageNode(w_rook_1,13),new ImageNode(w_rook_2,14)},
                        {new ImageNode(w_knight_2,12),new ImageNode(w_knight_1,11),new ImageNode(w_queen,16),new ImageNode(w_king,15)},
                });

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

        pss = new PositionStorageStructure(true);
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
        pss.readDefaultPosition(true,false);
        pss.createStorageStructure();
        pss.printState();
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
            pss.printState();
            ArrayList<Coordinate> pos = ms.calculateMovablePlaces(pss,xPos,yPos);
            for (Coordinate c : pos) {
                csse.findAndMarkAndShow(c,count);
                //System.out.println(c.getXPos()+" "+c.getYPos());
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

    public void clickedOnPath(MouseEvent mouseEvent) {
        Circle clicked = (Circle) mouseEvent.getSource();
        double xPos = clicked.getLayoutX();
        double yPos = clicked.getLayoutY();
        int valX = (int)((xPos-ChessPieces.BOARD_X_MIN)/ChessPieces.WALK_LENGTH);
        int valY = (int)((yPos-ChessPieces.BOARD_Y_MIN)/ChessPieces.WALK_LENGTH);
        if (chessPieceSelected && lastSelectedX!=-1 && lastSelectedY!=-1) {
            int abX = (int)((lastSelectedX-ChessPieces.BOARD_X_MIN)/ChessPieces.WALK_LENGTH);
            int abY = (int)((lastSelectedY-ChessPieces.BOARD_Y_MIN)/ChessPieces.WALK_LENGTH);

            if (pss.store.get(t(valX,valY)).type!=0) {
                iss.findImageByPosition(valX*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_X_MIN
                        ,valY*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_Y_MIN,false);
            }

            ArrayList<Coordinate> pos = ms.calculateMovablePlaces(pss,lastSelectedX,lastSelectedY);
            //System.out.println(pos.size());
            for (Coordinate c : pos) {
                csse.findAndMarkAndShow(c,count);
            }
            count = !count;

            pss.findAndMark(lastSelectedX,lastSelectedY,false,true);

            if (!waitForMove) {
                iss.findImageAndMove(lastSelectedX,lastSelectedY
                        ,valX*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_X_MIN
                        ,valY*ChessPieces.WALK_LENGTH+ChessPieces.BOARD_Y_MIN);

                int temp1 = pss.store.get(t(abX,abY)).type;
                pss.store.get(t(abX,abY)).type = 0;
                pss.store.get(t(valX,valY)).type = temp1;

                int temp2 = pss.store_type[t(abX,abY)];
                pss.store_type[t(abX,abY)] = 0;
                pss.store_type[t(valX,valY)] = temp2;

                iss.repaintChessBoard(pss.store_type);
            }

            pss.printState();
            //pss.transCurrentToFile(true,"0000");

            chessPieceSelected = false;
            lastSelectedX = -1;
            lastSelectedY = -1;

            moveMade = true;
            waitForMove = true;
            Text temp1 = new Text("[INFO] Wait for ");
            Text temp2 = new Text("white");
            Text temp3 = new Text(" to move\n");
            temp1.setFont(Font.font("Bell MT",15));
            temp2.setFont(Font.font("Bell MT",15));
            temp3.setFont(Font.font("Bell MT",15));
            temp1.setFill(Color.valueOf("f0d8b3"));
            temp2.setFill(Color.WHITE);
            temp3.setFill(Color.valueOf("f0d8b3"));
            textFlow.getChildren().add(temp1);
            textFlow.getChildren().add(temp2);
            textFlow.getChildren().add(temp3);
            moveSign.setFill(Color.WHITE);
            scrollPane.layout();
            scrollPane.setVvalue(1.0);
        }
    }

    private String[] findDifference(int[] ori,int[] aft) {
        int ptr1,ptr2,from = 0,dest = 0,movePiece = -1;
        for (int i = 0;i<64;i++) {
            ptr1 = ori[i];
            ptr2 = aft[i];
            if (ptr1!=ptr2) {
                if (ptr2==0) {
                    movePiece = ptr1;
                    from = i;
                } else {
                    movePiece = ptr2;
                    dest = i;
                }
            }
        }
        return new String[]{findPos(from),findPos(dest),findName(movePiece)};
    }

    private String findPos(int pos) {
        int x = 7-pos%8,y = 8-(pos-pos%8)/8;
        char c1 = (char) ('a'+x);
        return ""+c1+y;
    }

    private String findName(int piece) {
        int num = Math.abs(piece);
        if (num<=8 && num>=1) return "pawn";
        else if (num==9 || num==10) return "bishop";
        else if (num==11 || num==12) return "knight";
        else if (num==13 || num==14) return "rook";
        else if (num==15) return "king";
        else if (num==16) return "queen";
        else return "unknown";
    }

    public void setPSSFromOutSide(String message) {
        String[] temp = message.split(" ");
        int[] tempNum = new int[64];
        for (int i = 0;i<temp.length;i++) {
            int num = Integer.parseInt(temp[63-i]);
            tempNum[i] = num;
            pss.store.get(i).type = num;
        }
        String[] use = findDifference(pss.store_type,tempNum);

        Text t1 = new Text("[MOVE] ");
        Text t2 = new Text("white");
        Text t3 = new Text(" move ");
        Text t4 = new Text(use[2]);
        Text t5 = new Text(" "+use[0]+"->"+use[1]+"\n");
        t1.setFont(Font.font("Bell MT",15));
        t2.setFont(Font.font("Bell MT",15));
        t3.setFont(Font.font("Bell MT",15));
        t4.setFont(Font.font("Bell MT",15));
        t5.setFont(Font.font("Bell MT",15));
        t1.setFill(Color.valueOf("f0d8b3"));
        t2.setFill(Color.WHITE);
        t3.setFill(Color.valueOf("f0d8b3"));
        t4.setFill(Color.WHITE);
        t5.setFill(Color.valueOf("f0d8b3"));
        textFlow.getChildren().add(t1);
        textFlow.getChildren().add(t2);
        textFlow.getChildren().add(t3);
        textFlow.getChildren().add(t4);
        textFlow.getChildren().add(t5);

        pss.store_type = tempNum;
        iss.repaintChessBoard(pss.store_type);
        waitForMove = false;
        Text temp1 = new Text("[INFO] Wait for ");
        Text temp2 = new Text("black");
        Text temp3 = new Text(" to move\n");
        temp1.setFont(Font.font("Bell MT",15));
        temp2.setFont(Font.font("Bell MT",15));
        temp3.setFont(Font.font("Bell MT",15));
        temp1.setFill(Color.valueOf("f0d8b3"));
        temp2.setFill(Color.BLACK);
        temp3.setFill(Color.valueOf("f0d8b3"));
        textFlow.getChildren().add(temp1);
        textFlow.getChildren().add(temp2);
        textFlow.getChildren().add(temp3);
        moveSign.setFill(Color.BLACK);
        scrollPane.layout();
        scrollPane.setVvalue(1.0);
    }

    public void writeMessage(String message) {
        Text temp = new Text(message);
        temp.setFont(Font.font("Bell MT",15));
        temp.setFill(Color.valueOf("f0d8b3"));
        textFlow.getChildren().add(temp);
    }

    public void writeFirstLine() {

        Text temp = new Text("[INFO] Connection successfully made\n");
        temp.setFont(Font.font("Bell MT",15));
        temp.setFill(Color.valueOf("f0d8b3"));

        Text temp1 = new Text("[INFO] Wait for ");
        Text temp2 = new Text("white");
        Text temp3 = new Text(" to move\n");
        temp1.setFont(Font.font("Bell MT",15));
        temp2.setFont(Font.font("Bell MT",15));
        temp3.setFont(Font.font("Bell MT",15));
        temp1.setFill(Color.valueOf("f0d8b3"));
        temp2.setFill(Color.WHITE);
        temp3.setFill(Color.valueOf("f0d8b3"));
        textFlow.getChildren().add(temp);
        textFlow.getChildren().add(temp1);
        textFlow.getChildren().add(temp2);
        textFlow.getChildren().add(temp3);
        moveSign.setFill(Color.WHITE);
        scrollPane.layout();
        scrollPane.setVvalue(1.0);
    }

    public int t(int valX,int valY) {
        return valX+8*valY;
    }
}
