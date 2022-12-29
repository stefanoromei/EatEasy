package logic.bean;

import java.time.LocalDate;

public class BookingInfoBean {

    private String numberOfClients;

    private LocalDate date;

    private String timeSlot;

    private String name;

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
