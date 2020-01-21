package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import data.UserAccount;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane session_log;
    @FXML
    private AnchorPane layerContent;
    @FXML
    private AnchorPane layerSlide;

    // SIGN UP CONTENT FXML
    @FXML
    private VBox signUpContainer;
    @FXML
    private VBox signUpContainerContent;
    @FXML
    private JFXTextField usernameSignUp;
    @FXML
    private JFXPasswordField passwordSignUp;
    @FXML
    private JFXButton signUpBtn;

    // SIGN IN CONTENT FXML
    @FXML
    private VBox signInContainer;
    @FXML
    private VBox signInContainerContent;
    @FXML
    private JFXTextField usernameSignIn;
    @FXML
    private JFXPasswordField passwordSignIn;

    @FXML
    void signInClick(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(layerSlide);
        slide.setToX(491);
        slide.play();

        layerContent.setTranslateX(-309);
        signUpContainer.setVisible(true);
        signInContainer.setVisible(false);
        signUpContainerContent.setVisible(false);
        signInContainerContent.setVisible(true);

        slide.setOnFinished((e->{ }));
    }
    @FXML
    void signUpClick(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.4));
        slide.setNode(layerSlide);
        slide.setToX(0);
        slide.play();

        layerContent.setTranslateX(0);
        signUpContainer.setVisible(false);
        signInContainer.setVisible(true);
        signUpContainerContent.setVisible(true);
        signInContainerContent.setVisible(false);

        slide.setOnFinished((e->{ }));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        signUpContainer.setVisible(false);
        signInContainer.setVisible(true);
        signInContainerContent.setVisible(false);
        signUpContainerContent.setVisible(true);
    }

    @FXML
    void signUpClickContent(MouseEvent event) {

    }
    @FXML
    void signInClickContent(MouseEvent event) {

    }

    private ArrayList<UserAccount> dataAccounts = new ArrayList<>();
    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
        String usrSNI   = usernameSignIn.getText();
        String passSNI  = passwordSignIn.getText();
        signIn(usrSNI, passSNI);
    }
    private void signIn(String usrSNI, String passSNI) throws IOException {
        if(dataAccounts.size() < 1) {
            String tilte = "Sign In";
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage("User Not Found, Register Now");
            tray.setNotificationType(NotificationType.ERROR);
            tray.showAndDismiss(Duration.millis(2000));
        }else{
            for(UserAccount check: dataAccounts) {
                if(check.getUserName().equals(usrSNI) && check.getPassword().equals(passSNI)) {
                    setView("../CartApplication.fxml");
                }
                if(!check.getUserName().equals(usrSNI)){
                    String tilte = "Sign In";
                    String message = "Username Wrong";
                    TrayNotification tray = new TrayNotification();
                    AnimationType type = AnimationType.POPUP;
                    tray.setAnimationType(type);
                    tray.setTitle(tilte);
                    tray.setMessage(message);
                    tray.setNotificationType(NotificationType.ERROR);
                    tray.showAndDismiss(Duration.millis(2000));
                }
                if (!check.getPassword().equals(passSNI)){
                    String tilte = "Sign In";
                    String message = "Password Wrong";
                    TrayNotification tray = new TrayNotification();
                    AnimationType type = AnimationType.POPUP;
                    tray.setAnimationType(type);
                    tray.setTitle(tilte);
                    tray.setMessage(message);
                    tray.setNotificationType(NotificationType.ERROR);
                    tray.showAndDismiss(Duration.millis(2000));
                }
                if (!check.getUserName().equals(usrSNI) && !check.getPassword().equals(passSNI)){
                    String tilte = "Sign In";
                    String message = "Username and Password Wrong";
                    TrayNotification tray = new TrayNotification();
                    AnimationType type = AnimationType.POPUP;
                    tray.setAnimationType(type);
                    tray.setTitle(tilte);
                    tray.setMessage(message);
                    tray.setNotificationType(NotificationType.ERROR);
                    tray.showAndDismiss(Duration.millis(2000));
                }
            }
        }
    }
    @FXML
    public void handleSignUp(ActionEvent event) {
        String usrSNU   = usernameSignUp.getText();
        String passSNU  = passwordSignUp.getText();
        signUp(usrSNU, passSNU);

        String tilte = "Register";
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle(tilte);
        tray.setMessage("Register Success");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.millis(2000));
    }
    private void signUp(String usrSNU, String passSNU) {
        UserAccount tempUsr = new UserAccount(usrSNU, passSNU);
        dataAccounts.add(tempUsr);
    }

    void setView(String view) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(view));
        session_log.getChildren().clear();
        session_log.getChildren().setAll(root);
    }
}
