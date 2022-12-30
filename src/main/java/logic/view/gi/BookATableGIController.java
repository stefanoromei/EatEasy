package logic.view.gi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.bean.BookingInfoBean;
import logic.control.BookATableControl;
import logic.model.entity.BookingInfo;

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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        timeSlotEntry.getItems().addAll(timeSlot);
    }

    public void confirmBooking(ActionEvent actionEvent) {

        BookATableControl booking = new BookATableControl();
        BookingInfoBean bookingInfoBean = new BookingInfoBean(nameEntry, numberOfClientsEntry, dateEntry, timeSlotEntry);

        booking.checkForBooking(bookingInfoBean);
    }

}
