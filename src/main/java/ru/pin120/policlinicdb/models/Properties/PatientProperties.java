package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Patient;

@Getter
@Setter
public class PatientProperties {
    private Patient patient;
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty part;
    private StringProperty birthDate;

    public PatientProperties(Patient patient) {
        this.patient = patient;
        this.id = new SimpleIntegerProperty(patient.getId());
        this.firstName = new SimpleStringProperty(patient.getFirstName());
        this.lastName = new SimpleStringProperty(patient.getLastName());
        this.part = new SimpleStringProperty(patient.getPart());;
        this.birthDate = new SimpleStringProperty(patient.getBirthDate().toString());
    }
}
