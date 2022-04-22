module org.project.chess {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.project.chess to javafx.fxml;
    exports org.project.chess;

    opens org.project.chess.net.client to javafx.fxml;
    exports org.project.chess.net.client;

    opens org.project.chess.net.server to javafx.fxml;
    exports org.project.chess.net.server;
    exports org.project.chess.controller;
    opens org.project.chess.controller to javafx.fxml;

    exports org.project.chess.utils;
    exports org.project.chess.strategy;
}