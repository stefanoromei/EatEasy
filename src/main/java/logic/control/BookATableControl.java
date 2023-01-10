package logic.control;

import logic.bean.BookingInfoBean;
import logic.enumeration.TimeSlot;
import logic.exception.DatabaseException;
import logic.model.dao.BookingDAO;
import logic.model.entity.BookingInfo;
import logic.model.entity.Map;
import logic.model.entity.Table;

public class BookATableControl {

    public boolean checkForBooking(BookingInfoBean bookingInfoBean) throws DatabaseException {

        BookingInfo bookingInfo = new BookingInfo();

        bookingInfo.setName(bookingInfoBean.getName());
        bookingInfo.setDate(bookingInfoBean.getDate());
        bookingInfo.setNumberOfClients(Integer.parseInt(bookingInfoBean.getNumberOfClients()));
        bookingInfo.setTimeSlot(TimeSlot.valueOf(bookingInfoBean.getTimeSlot()));

        Map map = new Map();
        for (Table table : map.getTables()){
            var tableId = table.canBeBooked(bookingInfo.getNumberOfClients(), bookingInfo.getDate(), bookingInfo.getTimeSlot(), table.getTableId());
            if (tableId > 0){
                BookingDAO bookingDAO = new BookingDAO();
                return bookingDAO.addBook(bookingInfo, tableId);
            }
        }
        return false;
    }
}
