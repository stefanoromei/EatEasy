package logic.model.dao;

import logic.exception.DatabaseException;
import logic.model.Database;
import logic.model.entity.Table;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapDAO {

    public void updateMap(List<Table> tables) throws DatabaseException {
        var conn = Database.getConnection();
        try(CallableStatement stmt = conn.prepareCall("call get_table();")){
            int tableId;
            int minClients;
            int maxClients;

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                tableId = rs.getInt("tableId");
                minClients = rs.getInt("minNumOfClients");
                maxClients = rs.getInt("maxNumOfClients");

                tables.add(new Table(tableId, minClients, maxClients));
            }

        }
        catch(SQLException e) {
            throw new DatabaseException();
        }
    }
}
