package logic.control;

import logic.bean.BookingInfoBean;
import logic.enumeration.TimeSlot;
import logic.model.entity.BookingInfo;

public class BookATableControl {

    public void checkForBooking(BookingInfoBean bookingInfoBean) {
        BookingInfo bookingInfo = new BookingInfo();

        bookingInfo.setName(bookingInfoBean.getName());
        bookingInfo.setDate(bookingInfoBean.getDate());
        bookingInfo.setNumberOfClients(Integer.parseInt(bookingInfoBean.getNumberOfClients()));
        bookingInfo.setTimeSlot(TimeSlot.valueOf(bookingInfoBean.getTimeSlot()));

        System.out.println(bookingInfo.getName());
        System.out.println(bookingInfo.getDate());
        System.out.println(bookingInfo.getTimeSlot());
        System.out.println(bookingInfo.getNumberOfClients());

    }
}
