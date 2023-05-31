package ru.pin120.policlinicdb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;

public class MainApplication extends Application {
    private static Stage stage;
    private static Connection connection;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        this.stage = stage;
        DBHelper.connect();
        this.connection = DBHelper.getConnection();
        stage.setTitle("Главное меню");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
    static public Stage getPrimaryStage(){return stage;}
    static public Connection getConnection(){return connection;}
}