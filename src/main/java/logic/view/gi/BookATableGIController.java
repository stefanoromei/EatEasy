package logic.view.gi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.bean.BookingInfoBean;
import logic.control.BookATableControl;

import java.net.URL;
import java.util.ResourceBundle;

public class BookATableGIController implements Initializable{

    @FXML
    private ChoiceBox<String> timeSlotEntry;

    @FXML
    private DatePicker dateEntry;

    @FXML
    private TextField numberOfClientsEntry;

    @FXML
    private TextField nameEntry;

    @FXML
    private final String[] timeSlot = {"LUNCH", "DINNER"};

    @FXML
    private Label responseLabel;

    @FXML
    private Button confirmButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        timeSlotEntry.getItems().addAll(timeSlot);
    }

    public void displayResponse(Label label, String response){
        label.setText(response);
    }


    public void confirmBooking(ActionEvent actionEvent) {

        BookATableControl booking = new BookATableControl();
        BookingInfoBean bookingInfoBean = new BookingInfoBean(nameEntry, numberOfClientsEntry, dateEntry, timeSlotEntry);

        if (booking.checkForBooking(bookingInfoBean)){
            this.displayResponse(responseLabel, "Book OK");
        }
        else{
        this.displayResponse(responseLabel, "Book NO");
        }
        confirmButton.setDisable(true);
    }

    public void goBack(ActionEvent actionEvent) {
    }
}
