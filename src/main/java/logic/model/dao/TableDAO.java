package logic.model.dao;

import logic.enumeration.TimeSlot;
import logic.exception.DatabaseException;
import logic.model.Database;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableDAO {

    public boolean isFree(int numberOfClients, Date date, Enum<TimeSlot> timeSlot, int tableId) throws DatabaseException {
        var conn = Database.getConnection();
        var count = 0;
        try (CallableStatement stmt = conn.prepareCall("call is_free(?, ?, ?, ?);")) {

            stmt.setInt(1, numberOfClients);
            stmt.setDate(2, date);
            stmt.setString(3, String.valueOf(timeSlot));
            stmt.setInt(4, tableId);


            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count == 0;
        } catch (SQLException e) {
            throw new DatabaseException();
        }
    }
}