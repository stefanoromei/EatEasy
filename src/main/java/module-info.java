module logic.eateasy {
    requires javafx.controls;
    requires javafx.fxml;


    opens logic to javafx.fxml;
    exports logic;
    exports logic.view.GIGraphicController;
    opens logic.view.GIGraphicController to javafx.fxml;
}