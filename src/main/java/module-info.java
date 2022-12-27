module logic.eateasy {
    requires javafx.controls;
    requires javafx.fxml;


    opens logic to javafx.fxml;
    exports logic;
    exports logic.view.giGraphicController;
    opens logic.view.giGraphicController to javafx.fxml;
}