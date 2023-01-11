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
        int count = 1;
        try (CallableStatement stmt = conn.prepareCall("call is_free(?, ?, ?, ?);")) {

            stmt.setInt(1, numberOfClients);
            stmt.setDate(2, date);
            stmt.setString(3, String.valueOf(timeSlot));
            stmt.setInt(4, tableId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException();
        }
        return count == 0;
    }

    public int add_table(int minClients, int maxClients) throws DatabaseException {
        var conn = Database.getConnection();
        int tableId = 0;
        try (CallableStatement stmt = conn.prepareCall("call add_table(?, ?, ?);")) {

            stmt.setInt(1, minClients);
            stmt.setInt(2, maxClients);

            boolean result = stmt.execute();
            if(result){
                tableId = stmt.getInt(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException();
        }
        return tableId;
    }

    public int delete_table(int tableId) throws DatabaseException {
        var conn = Database.getConnection();
        int id = 0;
        try (CallableStatement stmt = conn.prepareCall("call delete_table(?);")) {

            stmt.setInt(1, tableId);

            boolean result = stmt.execute();
            if(result){
                id = stmt.getInt(1);
            }

        } catch (SQLException e) {
            throw new DatabaseException();
        }
        return id;
    }
}