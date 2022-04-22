package org.project.chess.net.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.project.chess.GUI_res;
import org.project.chess.controller.ControllerClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI_res.class.getResource("Client.fxml"));
        Parent parent = fxmlLoader.load();
        ControllerClient controller = fxmlLoader.getController();
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("White");
        primaryStage.getIcons().add(new Image(Client.class.getResourceAsStream("/img/icon.png")));
        primaryStage.show();
        new LaunchThread((controller)).start();
    }
}

class LaunchThread extends Thread {

    ControllerClient controller;

    public LaunchThread(ControllerClient controller) {
        this.controller = controller;
    }

    public void run() {
        Socket socket = new Socket();
        try {
            //System.out.println("before");
            while (controller.IPConnect.equals("")) {
                Thread.sleep(200);
            }
            //System.out.println("after");
            socket.connect(new InetSocketAddress(controller.IPConnect,9090),3000);
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
        } catch (InterruptedException | IOException e) {
            controller.IPConnect = "";
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    controller.writeMessage("[INFO] Connection failed to make\n");
                }
            });
            new LaunchThread((controller)).start();
        }
    }
}

class SendMessageThread implements Runnable {

    InputStream in;
    OutputStream out;
    ControllerClient controller;

    public SendMessageThread(InputStream in,OutputStream out,ControllerClient controller) {
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
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ReceiveMessageThread implements  Runnable {

    InputStream in;
    OutputStream out;
    ControllerClient controller;

    public ReceiveMessageThread(InputStream in,OutputStream out,ControllerClient controller) {
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
