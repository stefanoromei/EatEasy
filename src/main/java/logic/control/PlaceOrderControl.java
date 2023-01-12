package logic.control;

import logic.exception.DatabaseException;
import logic.model.entity.Menu;

public class PlaceOrderControl {
    public Menu getMenu() throws DatabaseException {
        Menu menu = new Menu();
        return menu;
    }
}
