package logic.model.entity;

import logic.enumeration.MenuSection;

public class MenuLine {

    private String description;

    private MenuSection menuSection;

    private float price;

    public MenuLine(String description, MenuSection menuSection, float price) {
        this.description = description;
        this.menuSection = menuSection;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MenuSection getMenuSection() {
        return menuSection;
    }

    public void setMenuSection(MenuSection menuSection) {
        this.menuSection = menuSection;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

