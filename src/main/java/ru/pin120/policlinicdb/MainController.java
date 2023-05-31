package ru.pin120.policlinicdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.service.DoctorService;
import ru.pin120.policlinicdb.service.DoctorServiceImpl;

import java.io.IOException;
import java.sql.Connection;

public class MainController {
    Connection connection = MainApplication.getConnection();


//    @FXML
//    private Label welcomeText;

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }


    @FXML
    public void onAddDoctorClick(ActionEvent actionEvent) throws IOException {
//        Doctor doctor = showDialogDoctor();
//        doctorService.create(doctor);
    }
    @FXML
    public void onAddPatientClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onAddDiseaseTypeClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onAddSpecialtyClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onAddVisitingClick(ActionEvent actionEvent) {
    }

    private void showDialogDoctor() throws IOException {
        //Doctor doctor = new Doctor();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("doctor-view.fxml"));
        Parent page = loader.load();
        Stage addStage = new Stage();
        addStage.setTitle("Добавить доктора");
        addStage.initModality(Modality.WINDOW_MODAL);
        addStage.initOwner(MainApplication.getPrimaryStage());
        Scene scene = new Scene(page);
        addStage.setScene(scene);
        DoctorController controller = loader.getController();
        controller.setAddStage(addStage);
        //controller.setDoctor(doctor);
        addStage.showAndWait();
        //return doctor;
    }
}