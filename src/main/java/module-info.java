module logic.eateasy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens logic to javafx.fxml;
    exports logic;
    exports logic.view.gi;
    opens logic.view.gi to javafx.fxml;
}