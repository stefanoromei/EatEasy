module logic.eateasy {
    requires javafx.controls;
    requires javafx.fxml;


    opens logic to javafx.fxml;
    exports logic;
}