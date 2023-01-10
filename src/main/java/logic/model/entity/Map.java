package logic.model.entity;

import logic.exception.DatabaseException;
import logic.model.dao.MapDAO;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Map() throws DatabaseException {
        this.updateMap();
    }

    public void updateMap() throws DatabaseException {
        MapDAO mapDAO = new MapDAO();
        this.tables = new ArrayList<>();
        mapDAO.updateMap(this.tables);
    }





}
