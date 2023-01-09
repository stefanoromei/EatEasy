package logic.model.entity;

import logic.enumeration.TimeSlot;

import java.sql.Date;

public class BookingInfo {

    private int numberOfClients;

    private Date date;

    private Enum<TimeSlot> timeSlot;

    private String name;

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enum<TimeSlot> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
