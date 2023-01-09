package logic.bean;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;


public class BookingInfoBean {

    private String numberOfClients;

    private Date date;

    private String timeSlot;

    private String name;

    public BookingInfoBean(TextField nameEntry, TextField numberOfClientsEntry, DatePicker dateEntry, ChoiceBox<String> timeSlotEntry) {
        try {
            Integer.parseInt(numberOfClientsEntry.getText());
        }
        catch (NumberFormatException e){
            System.out.println("ERROR");
            return;
        }

        this.setName(nameEntry.getText());
        this.setNumberOfClients(numberOfClientsEntry.getText());
        this.setDate(Date.valueOf(dateEntry.getValue()));
        this.setTimeSlot(timeSlotEntry.getValue());

    }

    public String getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(String numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
