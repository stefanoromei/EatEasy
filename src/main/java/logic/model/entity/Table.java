package logic.model.entity;

import logic.enumeration.TimeSlot;

import java.time.LocalDate;
import java.util.Locale;

public class Table {

    private int tableId;

    private int minClients;

    private int maxClients;

    public Table(){
        this.tableId = 1;
        this.minClients = 2;
        this.maxClients = 4;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getMinClients() {
        return minClients;
    }

    public void setMinClients(int minClients) {
        this.minClients = minClients;
    }

    public int getMaxClients() {
        return maxClients;
    }

    public void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
    }

    public boolean canBeBooked(int numberOfClients, LocalDate date, TimeSlot timeSlot){
        return true;
    }

    public boolean book(BookingInfo bookingInfo) {
        return true;
    }
}
