package grp.anon.status;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import grp.anon.main.Home;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DownloadStatusController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ProgressIndicator download_progress;

    @FXML
    private JFXButton homeBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXTextArea download_status_text;

    @FXML
    void cancelDownloading(ActionEvent event) {
    }

    @FXML
    void goHome(ActionEvent event) {
        Stage curStage = (Stage) root.getScene().getWindow();
        FadeTransition transition = new FadeTransition(Duration.seconds(2),root);
        transition.setFromValue(1);
        transition.setToValue(0);
        transition.setOnFinished(e ->{
            try {
                curStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../main/home.fxml"))));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        transition.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FadeTransition transition = new FadeTransition(Duration.seconds(2),root);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();

    }
}
