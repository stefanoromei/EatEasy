package logic.model.entity;

import java.util.Date;

public class TakeAwayOrder extends Order{

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
