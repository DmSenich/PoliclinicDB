package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.DiseaseType;

@Getter
@Setter
public class DiseaseTypeProperties {
    private IntegerProperty id;
    private StringProperty name;

    public DiseaseTypeProperties(DiseaseType diseaseType){
        this.id = new SimpleIntegerProperty(diseaseType.getId());
        this.name = new SimpleStringProperty(diseaseType.getName());
    }
}
