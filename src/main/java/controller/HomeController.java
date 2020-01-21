package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private ImageView imgHome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img = new Image("asset/asset1.png");
        this.imgHome = new ImageView();
        this.imgHome.setImage(img);
    }
}
