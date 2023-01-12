package logic.model.entity;

import logic.exception.DatabaseException;
import logic.model.dao.MenuDAO;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<MenuLine> menuLines;

    public List<MenuLine> getMenuLines() {
        return menuLines;
    }

    public void setMenuLines(List<MenuLine> menuLines) {
        this.menuLines = menuLines;
    }

    public Menu() throws DatabaseException {
        this.updateMenu();
    }

    public void addMenuLine(MenuLine menuLine){
        this.menuLines.add(menuLine);
    }

    public void updateMenu() throws DatabaseException {
        MenuDAO menuDAO = new MenuDAO();
        this.menuLines = new ArrayList<>();
        menuDAO.updateMenu(this.menuLines);
    }
}
