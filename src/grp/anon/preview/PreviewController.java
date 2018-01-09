package grp.anon.preview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PreviewController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private GridPane preview_pane;

    @FXML
    private ImageView pb1;

    @FXML
    private ImageView pb2;

    @FXML
    private ImageView pb3;

    @FXML
    private ImageView pb4;

    @FXML
    private ImageView pb5;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
