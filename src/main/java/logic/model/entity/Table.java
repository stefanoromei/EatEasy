package logic.model.entity;

import logic.enumeration.TimeSlot;
import logic.exception.DatabaseException;
import logic.model.dao.BookingDAO;
import logic.model.dao.TableDAO;

import java.util.Date;

public class Table {

    private int tableId;

    private int minClients;

    private int maxClients;

    public Table() {
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

    public int canBeBooked(int numberOfClients, Date date, Enum<TimeSlot> timeSlot, int tableId) throws DatabaseException {
        TableDAO tableDAO = new TableDAO();
        if (tableDAO.isFree(numberOfClients, (java.sql.Date) date, timeSlot, tableId) && this.isCompliant(numberOfClients)){
            return tableId;
        }
        return 0;
    }

    private boolean isCompliant(int numberOfClients) {
        return (numberOfClients >= this.getMinClients() && numberOfClients <= this.getMaxClients());
    }

    public boolean book(BookingInfo bookingInfo, int tableId) throws DatabaseException {
        BookingDAO bookingDAO = new BookingDAO();
        return bookingDAO.addBook(bookingInfo, tableId);
    }
}
