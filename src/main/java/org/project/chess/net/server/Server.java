package org.project.chess.net.server;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.project.chess.GUI_res;
import org.project.chess.controller.ControllerServer;
import org.project.chess.net.client.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI_res.class.getResource("Server.fxml"));
        Parent parent = fxmlLoader.load();
        ControllerServer controller = fxmlLoader.getController();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Black");
        primaryStage.getIcons().add(new Image(Client.class.getResourceAsStream("/img/icon.png")));
        primaryStage.show();
        //System.out.println("window finished");
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(9090);
                //System.out.println("setting socket");
                Socket socket = serverSocket.accept();
                //System.out.println(socket);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        controller.writeFirstLine();
                    }
                });
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                SendMessageThread smt = new SendMessageThread(in,out,controller);
                ReceiveMessageThread rmt = new ReceiveMessageThread(in,out,controller);
                new Thread(smt).start();
                new Thread(rmt).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class SendMessageThread implements Runnable {

    InputStream in;
    OutputStream out;
    ControllerServer controller;

    public SendMessageThread(InputStream in, OutputStream out,ControllerServer controller) {
        this.in = in;
        this.out = out;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (controller.moveMade) {
                    out.write(controller.pss.transCurrentToString().getBytes());
                    out.flush();
                    controller.moveMade = false;
                }
                Thread.sleep(100);
            }catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReceiveMessageThread implements Runnable {

    InputStream in;
    OutputStream out;
    ControllerServer controller;

    public ReceiveMessageThread(InputStream in, OutputStream out,ControllerServer controller) {
        this.in = in;
        this.out = out;
        this.controller = controller;
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] temp = new byte[1000*1024];
                int len = in.read(temp);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        controller.setPSSFromOutSide(new String(temp,0,len));
                    }
                });
                //Thread.sleep(100);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
