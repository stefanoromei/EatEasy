package logic.model.dao;

import logic.exception.DatabaseException;
import logic.model.Database;
import logic.model.entity.BookingInfo;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class TableDAO {
    public int bookTable(BookingInfo bookingInfo, int tableId) throws DatabaseException {
        var conn = Database.getConnection();
        var id = 0;
        try(CallableStatement stmt = conn.prepareCall("call add_booking(?, ?, ?, ?, ?);");){

            stmt.setString(1, bookingInfo.getName());
            stmt.setInt(2, bookingInfo.getNumberOfClients());
            stmt.setDate(3, bookingInfo.getDate());
            stmt.setString(4, String.valueOf(bookingInfo.getTimeSlot()));
            stmt.setInt(5, tableId);

            boolean haveResult = stmt.execute();
            id = stmt.getInt(1);
        }
        catch(SQLException e) {
            throw new DatabaseException();
        }
        return id;

    }
}
