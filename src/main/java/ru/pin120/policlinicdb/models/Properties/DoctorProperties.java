package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Doctor;

@Getter
@Setter
public class DoctorProperties {
    private Doctor doctor;
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty part;
    private StringProperty specialties;

    public DoctorProperties(Doctor doctor) {
        this.doctor = doctor;
        this.id = new SimpleIntegerProperty(doctor.getId());
        this.firstName = new SimpleStringProperty(doctor.getFirstName());
        this.lastName = new SimpleStringProperty(doctor.getLastName());
        this.part = new SimpleStringProperty(doctor.getPart());;
        this.specialties = new SimpleStringProperty(doctor.getSpecialties());;
    }


}
