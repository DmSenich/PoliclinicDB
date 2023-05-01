module ru.pin120.policlinicdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;


    opens ru.pin120.policlinicdb to javafx.fxml;
    exports ru.pin120.policlinicdb;
}