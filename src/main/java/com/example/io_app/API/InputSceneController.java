package com.example.io_app.API;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InputSceneController {

    @FXML
    private TextField titleField;

    @FXML
    private DatePicker dateField;

    @FXML
    private void handleSave() {
        // Pobieranie danych z pól
        String title = titleField.getText();
        String date = (dateField.getValue() != null) ? dateField.getValue().toString() : "Brak daty";

        System.out.println("Tytuł: " + title);
        System.out.println("Data seansu: " + date);

        // Dodaj logikę zapisu danych (np. zapis do bazy)
    }
}
