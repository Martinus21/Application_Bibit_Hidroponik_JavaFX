package controller;

import data.Cart;
import data.DataCart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private TableView tableViewCart;
    @FXML
    private Text textTotalPrice;

    @FXML
    void handleBuy(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Cart cart : DataCart.getInstance().get()) {
            System.out.println(cart.getSeed().getName());
        }
    }
}