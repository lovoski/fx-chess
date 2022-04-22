package org.project.chess.utils;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.ArrayList;

public class PositionStorageStructure {

    public ArrayList<BlockNode> store = new ArrayList<>(64);
    public Rectangle[] store_rec = new Rectangle[64];
    public int[] store_type = new int[64];
    public int saveFileCount = 1;
    public boolean localHostIsServer;

    public Color lighter,darker,path,target;

    public PositionStorageStructure(boolean localHostIsServer) {
        lighter = Color.valueOf("f0d8b3");
        darker = Color.valueOf("b48661");
        path = Color.valueOf("EA2450");
        target = Color.valueOf("671F2E");
        this.localHostIsServer = localHostIsServer;

        File saveRootSever = new File("save/server");
        File saveRootClient = new File("save/client");
        File saveRootPublic = new File("save/public");
        if (!saveRootSever.exists())
            saveRootSever.mkdirs();
        if (!saveRootClient.exists())
            saveRootClient.mkdirs();
        if (!saveRootPublic.exists())
            saveRootPublic.mkdirs();
    }

    public void fillInAllRectangle(Rectangle[][] recs) {
        int index = 0;
        for (Rectangle[] rectangles : recs) {
            for (Rectangle rectangle : rectangles) {
                store_rec[index] = rectangle;
                index++;
            }
        }
    }

    public void readSavingFile() {

    }

    public void transCurrentToFile(boolean isSever,String time) {
        File out;
        if (isSever) out = new File("save/sever/"+time+saveFileCount+".txt");
        else out = new File("save/client/"+time+saveFileCount+".txt");
        saveFileCount++;
        try {
            if (!out.exists()) {
                out.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(out);
            StringBuilder temp = new StringBuilder();
            for (int i = 0;i<store_type.length-1;i++) {
                temp.append(store_type[i]).append(" ");
            }
            temp.append(store_type[63]);
            fos.write(temp.toString().getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String transCurrentToString() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0;i<store_type.length-1;i++) {
            temp.append(store_type[i]).append(" ");
        }
        temp.append(store_type[63]);
        return temp.toString();
    }

    public void readDefaultPosition(boolean isSever,boolean testMode) {
        File defaultPosition = null;
        if (!testMode) {
            if (isSever) defaultPosition = new File("save/server/default.txt");
            else defaultPosition = new File("save/client/default.txt");
        } else defaultPosition = new File("save/test1.txt");
        int index = 0;
        try {
            FileInputStream fis = new FileInputStream(defaultPosition);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String tempLine = reader.readLine();
            String[] line = tempLine.split(" ");
            for (String s : line) {
                store_type[index] = Integer.parseInt(s);
                index++;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("default finished,size :"+index);
    }

    public void fillInAllPieces(int[][] pieces) {
        int index = 0;
        for (int[] i : pieces) {
            for (int j : i) {
                store_type[index] = j;
                index++;
            }
        }
    }

    public void createStorageStructure() {
        for (int i = 0;i<64;i++) {
            store.add(i,new BlockNode(store_rec[i],store_type[i]));
        }
    }

    public int findAndReturnType(double xPos,double yPos) {
        BlockNode findNode = new BlockNode(xPos,yPos);
        for (int i = 0;i<64;i++) {
            if (findNode.isSame(store.get(i))) {
                return store.get(i).type;
            }
        }
        return 0;
    }

    public void translateType(int type) {
        if (type>0) System.out.println("white");
        else if (type<0) System.out.println("black");
        else System.out.println("null");
    }

    public void findAndMark(double xPos,double yPos,boolean changeColor,boolean onEnter) {
        BlockNode findNode = new BlockNode(xPos,yPos);
        for (int i = 0;i<64;i++) {
            if (findNode.isSame(store.get(i))) {
                if (onEnter) {
                    if (changeColor) {
                        //System.out.println("change color");
                        store.get(i).block.setFill(path);
                        //store.get(i).block.setStrokeWidth(0);
                    } else {
                        store.get(i).block.setFill(store.get(i).oriColor);
                        //store.get(i).block.setStrokeWidth(0);
                    }
                } else {
                    if (changeColor) {
                        store.get(i).block.setFill(target);
                        //store.get(i).block.setStrokeWidth(0);
                    } else {
                        store.get(i).block.setFill(store.get(i).oriColor);
                        //store.get(i).block.setStrokeWidth(0);
                    }
                }
                return;
            }
        }
    }

    public void printState() {
        System.out.println();
        for (int i = 0;i<8;i++) {
            for (int j = 0;j<8;j++) {
                System.out.printf("%5d",store.get(8*i+j).type);
            }
            System.out.println();
        }
        System.out.println();
    }
}
