package logic.bean;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import logic.model.entity.BookingInfo;

import java.time.LocalDate;

public class BookingInfoBean {

    private String numberOfClients;

    private LocalDate date;

    private String timeSlot;

    private String name;

    public BookingInfoBean(TextField nameEntry, TextField numberOfClientsEntry, DatePicker dateEntry, ChoiceBox<String> timeSlotEntry) {
        try {
            Integer.parseInt(numberOfClientsEntry.getText());
        }
        catch (NumberFormatException e){
            System.out.println("ERRORE");
            return;
        }

        this.setName(nameEntry.getText());
        this.setNumberOfClients(numberOfClientsEntry.getText());
        this.setDate(dateEntry.getValue());
        this.setTimeSlot(timeSlotEntry.getValue());

    }

    public String getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(String numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
