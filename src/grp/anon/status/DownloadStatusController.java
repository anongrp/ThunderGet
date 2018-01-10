package grp.anon.status;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
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

    }

    Thread downloader = new Thread();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}

class ImagesDownloader implements Runnable{
    @Override
    public void run() {

    }
}