package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.Visiting;

@Getter
@Setter
public class VisitingProperties {
    private Visiting visiting;
    private IntegerProperty id;
    private IntegerProperty doctorId;
    private IntegerProperty patientId;
    //private StringProperty disease;
    private StringProperty date;

    public VisitingProperties(Visiting visiting) {
        this.visiting = visiting;
        this.id = new SimpleIntegerProperty(visiting.getId());
        this.patientId = new SimpleIntegerProperty(visiting.getPatientId());
        this.doctorId = new SimpleIntegerProperty(visiting.getDoctorId());
//        String strDiseases = "";
//        for (Disease disease:
//             visiting.getDiseases()) {
//            strDiseases
//        }
//        this.disease = new SimpleStringProperty(visiting.getDiseases());
        this.date = new SimpleStringProperty(visiting.getDate().toString());
    }


}
