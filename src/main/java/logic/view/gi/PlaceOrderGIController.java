package logic.view.gi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderGIController implements Initializable {

    @FXML
    private Button confirmButton;

    @FXML
    private Button homeButton;

    @FXML
    private ListView<String> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
        list.getItems().addAll("15");
    }

    public void confirmOrder(ActionEvent actionEvent) {
    }

    public void goHome(ActionEvent actionEvent) {
    }
}
