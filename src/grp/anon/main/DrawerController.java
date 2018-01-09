package grp.anon.main;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DrawerController {
    @FXML
    private VBox root;

    private StackPane mainRoot;

    @FXML
    void goAbout(ActionEvent event) {
    }

    @FXML
    void goCategory(ActionEvent event) {

    }

    @FXML
    void goDownloads(ActionEvent event) throws IOException {
        mainRoot = Home.getRoot();
        Stage curStage = (Stage) mainRoot.getScene().getWindow();
        FadeTransition transition = new FadeTransition(Duration.seconds(2),mainRoot);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setOnFinished(e ->{
            try {
                curStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../status/download_status.fxml"))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        transition.play();
    }

    @FXML
    void goHome(ActionEvent event) {
        JFXDrawer home_drawer = HomeController.getDrawer();
        home_drawer.close();
    }

    @FXML
    void goSettings(ActionEvent event) {

        mainRoot = Home.getRoot();
        Stage curStage = (Stage) mainRoot.getScene().getWindow();
        FadeTransition transition = new FadeTransition(Duration.seconds(2),mainRoot);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setOnFinished(e ->{
            try {
                curStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../setting/settings.fxml"))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        transition.play();
    }

    @FXML
    void quit(ActionEvent event) {
        mainRoot = Home.getRoot();
        Stage curStage = (Stage) mainRoot.getScene().getWindow();
        FadeTransition transition = new FadeTransition(Duration.seconds(1),mainRoot);
        transition.setFromValue(1);
        transition.setToValue(0.5);
        transition.setOnFinished(e ->{
            System.exit(0);
        });
        transition.play();
    }
}
