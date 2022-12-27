package logic.model.entity;

import java.util.List;

public class Menu {

    private List<MenuLine> menuLines;

    public List<MenuLine> getMenuLines() {
        return menuLines;
    }

    public void setMenuLines(List<MenuLine> menuLines) {
        this.menuLines = menuLines;
    }
}
