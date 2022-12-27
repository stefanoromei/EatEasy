package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class BookATableGController implements Initializable{
    @FXML
    private Label timeSlot_Label;

    @FXML
    private ChoiceBox<String> timeSlot_Entry;

    @FXML
    private final String[] timeSlot = {"LUNCH", "DINNER"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        timeSlot_Entry.getItems().addAll(timeSlot);
        timeSlot_Entry.setOnAction(this::getFood);
    }

    public void getFood(ActionEvent event){
        String myTimeSlot = timeSlot_Entry.getValue();
        timeSlot_Label.setText("timeSlot");
    }

    public void confirmBooking(ActionEvent actionEvent) {
    }

}
