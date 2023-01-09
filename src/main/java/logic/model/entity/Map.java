package logic.model.entity;

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

    public Map(){
        this.tables = new ArrayList<>();
        this.tables.add(new Table());
    }



}
