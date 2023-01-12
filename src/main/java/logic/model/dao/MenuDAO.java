package logic.model.dao;

import javafx.scene.SubScene;
import logic.enumeration.MenuSection;
import logic.exception.DatabaseException;
import logic.model.Database;
import logic.model.entity.Menu;
import logic.model.entity.MenuLine;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MenuDAO {
    public void updateMenu(List<MenuLine> menuLines) throws DatabaseException {
        var conn = Database.getConnection();
        try(CallableStatement stmt = conn.prepareCall("call get_menu();")){
            String itemDescription;
            float itemPrice;
            MenuSection menuSection;

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                itemDescription = rs.getString("itemDescription");
                itemPrice = rs.getFloat("itemPrice");
                menuSection = MenuSection.valueOf(rs.getString("menuSection"));

                menuLines.add(new MenuLine(itemDescription, menuSection, itemPrice));

            }

        }
        catch(SQLException e) {
            throw new DatabaseException();
        }
    }
}
