import data.DataSeed;
import data.Seed;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        root = FXMLLoader.load(getClass().getResource("MainApplication.fxml"));
        primaryStage.setTitle("Hydro Green");
        primaryStage.setScene(new Scene(root, 1080, 680));
        primaryStage.show();
    }

    public static void main(String[] args) {
        DataSeed.getInstance().add(new Seed("Brocolli", "Price : 14.000"));
        DataSeed.getInstance().add(new Seed("Mustard greens", "12.000"));
        DataSeed.getInstance().add(new Seed("Celery", "16.000"));
        DataSeed.getInstance().add(new Seed("Spinach", "20.000"));
        DataSeed.getInstance().add(new Seed("Bean", "18.000"));
        DataSeed.getInstance().add(new Seed("Chili", "25.000"));
        launch(args);
    }
}
