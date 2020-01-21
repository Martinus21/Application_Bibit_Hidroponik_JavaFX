package controller;

import component.CardSeed;
import data.DataCart;
import data.DataSeed;
import data.Seed;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HydroController implements Initializable {
    @FXML
    private VBox cardContainer;

    @FXML
    void handleCart(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../LoginApplication.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Hydro Green");
        stage.setScene(new Scene(root, 800, 500));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataCart.getInstance().setCarts(new ArrayList<>());
        for (Seed seed: DataSeed.getInstance().get()) {
            CardSeed seedCard = new CardSeed(seed);
            cardContainer.getChildren().add(seedCard.getCard());
        }
    }
}
