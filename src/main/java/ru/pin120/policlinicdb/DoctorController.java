package ru.pin120.policlinicdb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.service.DoctorService;
import ru.pin120.policlinicdb.service.DoctorServiceImpl;

public class DoctorController {

    @FXML
    public TextField tLastName;
    @FXML
    public TextField tFirstName;
    @FXML
    public TextField tPatr;
    @FXML
    public TextField tWorkExp;

    private Stage dialogStage;
    private Doctor doctor;
    DoctorService doctorService = new DoctorServiceImpl(MainApplication.getConnection());

    public void setAddStage(Stage addStage){
        dialogStage = addStage;
    }

    //public void setDoctor(Doctor doctor){ this.doctor = doctor;}

    @FXML
    public void onCancelClick(ActionEvent actionEvent) {
        dialogStage.close();
    }

    @FXML
    public void onOkClick(ActionEvent actionEvent) {
        String lastName = tLastName.getText();
        String firstName = tFirstName.getText();
        String patr = tPatr.getText();
        int workExp;
        try{
            workExp = Integer.getInteger(tWorkExp.getText());
        } catch (Exception e) {
            workExp = 0;
        }
        doctorService.create(firstName,lastName,patr,workExp);
        dialogStage.close();
    }
}
