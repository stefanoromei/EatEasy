package logic.view.GIGraphicController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BookATableGController implements Initializable{
    @FXML
    private Label timeSlotLabel;

    @FXML
    private ChoiceBox<String> timeSlotEntry;

    @FXML
    private final String[] timeSlot = {"LUNCH", "DINNER"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        timeSlotEntry.getItems().addAll(timeSlot);
        timeSlotEntry.setOnAction(this::getFood);
    }

    public void getFood(ActionEvent event){
        timeSlotLabel.setText("timeSlot");
    }

    public void confirmBooking(ActionEvent actionEvent) {
        //DO_SOMETHING
    }

}
