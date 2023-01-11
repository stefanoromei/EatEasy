package logic.view.gi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import logic.bean.BookingInfoBean;
import logic.control.BookATableControl;
import logic.exception.DatabaseException;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;
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
        timeSlotEntry.getSelectionModel().selectFirst();

    }

    public void displayResponse(Label label, String response){

        label.setText(response);
    }


    public void confirmBooking(ActionEvent actionEvent) throws DatabaseException {

        BookATableControl bookATableControl = new BookATableControl();
        BookingInfoBean bookingInfoBean = null;
        try {
            bookingInfoBean = new BookingInfoBean(nameEntry, numberOfClientsEntry, dateEntry, timeSlotEntry);
        } catch (NumberFormatException e) {
            this.displayResponse(responseLabel, "Number of clients must be a number.");
        } catch (NullPointerException e){
            this.displayResponse(responseLabel, "Please insert a valid date.");
        }

        int bookingId = bookATableControl.checkForBooking(bookingInfoBean);
        if (bookingId > 0) {
            this.displayResponse(responseLabel, "Booking successfully made ,your booking identifier is "+ bookingId);
        } else {
            this.displayResponse(responseLabel, "Sorry, there is no availability for the number of clients on the selected dates");
        }
        confirmButton.setDisable(true);


    }

    public void goHome(ActionEvent actionEvent) {
    }
}
