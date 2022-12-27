module logic.eateasy {
    requires javafx.controls;
    requires javafx.fxml;


    opens logic to javafx.fxml;
    exports logic;
    exports logic.view.gi;
    opens logic.view.gi to javafx.fxml;
}