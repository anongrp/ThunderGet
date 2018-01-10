package grp.anon.main;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawerController implements Initializable {
    @FXML
    private VBox root;

    private Stage downloadStage;
    private Stage aboutStage;
    private Stage settingsStage;

    private Scene downloadScene;
    private Scene aboutScene;
    private Scene settingScene;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            downloadStage = new Stage();
            downloadStage.setResizable(false);
            //aboutStage = new Stage();
            settingsStage = new Stage();
            settingsStage.setResizable(false);
            downloadScene = new Scene(FXMLLoader.load(getClass().getResource("../status/download_status.fxml")));
            //aboutScene =  new Scene(FXMLLoader.load(getClass().getResource("../about/about.fxml")));
            settingScene = new Scene(FXMLLoader.load(getClass().getResource("../setting/settings.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void goAbout(ActionEvent event) {
    }

    @FXML
    void goCategory(ActionEvent event) {

    }

    @FXML
    void goDownloads(ActionEvent event) throws IOException {
        downloadStage.setScene(downloadScene);
        downloadStage.setTitle("Download");
        downloadStage.show();
        Home.mainStage.hide();
        downloadStage.setOnCloseRequest(e->{
            Home.mainStage.show();
        });
    }

    @FXML
    void goHome(ActionEvent event) {

    }

    @FXML
    void goSettings(ActionEvent event) {
        settingsStage.setScene(settingScene);
        settingsStage.setTitle("Setting");
        settingsStage.show();
        Home.mainStage.hide();
        settingsStage.setOnCloseRequest(e->{
            Home.mainStage.show();
        });
    }

    @FXML
    void quit(ActionEvent event) {
        System.exit(1);
    }

}
