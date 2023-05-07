package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Specialty;

@Getter
@Setter
public class DoctorProperties {
    private Doctor doctor;
    private IntegerProperty id;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty part;
    private IntegerProperty workExp;
    private ListProperty<StringProperty> specialties;

    public DoctorProperties(Doctor doctor) {
        this.doctor = doctor;
        this.id = new SimpleIntegerProperty(doctor.getId());
        this.firstName = new SimpleStringProperty(doctor.getFirstName());
        this.lastName = new SimpleStringProperty(doctor.getLastName());
        this.part = new SimpleStringProperty(doctor.getPart());
        this.workExp = new SimpleIntegerProperty(doctor.getWorkExp());
        for (Specialty spec: doctor.getSpecialties()
             ) {
            this.specialties.add(new SimpleStringProperty(spec.getName()));
        }
        //this.specialties = new SimpleStringProperty(doctor.getSpecialties());
    }


}
