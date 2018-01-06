package grp.anon.main.ui.home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("Hello Its Init");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("ThunderGet");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
