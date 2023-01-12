package logic.view.gi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.util.converter.NumberStringConverter;
import logic.control.PlaceOrderControl;
import logic.exception.DatabaseException;
import logic.model.entity.Menu;
import logic.model.entity.MenuLine;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderGIController implements Initializable {

    @FXML
    private Button confirmButton;

    @FXML
    private Button homeButton;

    @FXML
    private ListView<HBox> list;

    private List<HBox> hBoxList;

    public void insertLine(ListView<HBox> list, String itemName, float price){
        HBox lineBox = new HBox();
        HBox quantityBox = new HBox();
        Label item = new Label();
        Label itemPrice = new Label();
        TextField numberField = new TextField();
        item.setText(itemName);
        item.setFont(new Font(20));
        itemPrice.setText(String.valueOf(price)+" €");
        itemPrice.setFont(new Font(20));
        numberField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
        numberField.setMaxWidth(50);
        quantityBox.getChildren().addAll(itemPrice, numberField);
        quantityBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(quantityBox, Priority.ALWAYS);
        lineBox.getChildren().addAll(item, quantityBox);
        list.getItems().add(lineBox);
    }

    //public Menu getMenu() throws DatabaseException {
    //    Menu menu = new Menu();
    //    menu.getMenu();
    //    return menu;
    //}



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PlaceOrderControl placeOrderControl = new PlaceOrderControl();
        Menu menu = null;
        try {
            menu = placeOrderControl.getMenu();
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        }
        for (MenuLine menuLine : menu.getMenuLines()){
            this.insertLine(list, menuLine.getDescription(), menuLine.getPrice());
        }

    }

    public void confirmOrder(ActionEvent actionEvent) {
    }

    public void goHome(ActionEvent actionEvent) {
    }
}
