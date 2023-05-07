package ru.pin120.policlinicdb.models.Properties;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import ru.pin120.policlinicdb.models.Specialty;

@Getter
@Setter

public class SpecialtyProperties {
    private IntegerProperty id;
    private StringProperty name;

    public SpecialtyProperties(Specialty specialty) {
        this.id = new SimpleIntegerProperty(specialty.getId());
        this.name = new SimpleStringProperty(specialty.getName());
    }
}
