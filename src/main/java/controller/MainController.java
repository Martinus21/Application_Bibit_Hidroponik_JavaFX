package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private AnchorPane contenContainer;

    @FXML
    private ImageView imgHome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setView("../HomeApplication.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleContact(ActionEvent event) throws IOException{
        setView("../ContactApplication.fxml");
    }
    @FXML
    void handleHome(ActionEvent event) throws IOException{
        setView("../HomeApplication.fxml");
    }
    @FXML
    void handleHydro(ActionEvent event) throws IOException{
        setView("../HydroponicApplication.fxml");
    }

    void setView(String view) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(view));
        contenContainer.getChildren().clear();
        contenContainer.getChildren().setAll(root);
    }
}
