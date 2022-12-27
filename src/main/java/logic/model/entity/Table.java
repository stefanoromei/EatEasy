package logic.model.entity;

public class Table {

    private int tableId;

    private int minClients;

    private int maxClients;

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
}
