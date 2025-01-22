package com.example.io_app.API;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/io_app/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366, 768);
        stage.setTitle("StudioCinema");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }


    @FXML
    public void switchToMoviesManagement(ActionEvent event) {
        try {
            // Wczytanie nowego pliku FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/io_app/hello-view.fxml"));
            Parent root = fxmlLoader.load();

            // Pobranie bieżącego okna
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Ustawienie nowej sceny w bieżącym oknie
            stage.setScene(new Scene(root));
            stage.setTitle("Zarządzanie Filmami");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleExitButton(ActionEvent event) {
        // Zamyka aplikację
        Platform.exit();
    }

    public static void main(String[] args) {
        launch();
    }
}