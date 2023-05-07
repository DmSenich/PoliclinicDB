package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Disease;

@Setter
@Getter
public class DiseaseProperties {
    private IntegerProperty id;
    private  IntegerProperty typeId;
    private StringProperty description;

    public DiseaseProperties(Disease disease){
        this.id = new SimpleIntegerProperty(disease.getId());
        this.typeId = new SimpleIntegerProperty(disease.getTypeId());
        this.description = new SimpleStringProperty(disease.getDescription());
    }
}
