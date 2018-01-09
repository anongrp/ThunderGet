package grp.anon.setting;

import grp.anon.main.Home;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.util.Duration;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField download_path;

    @FXML
    private JFXButton browseBtn;

    @FXML
    private ImageView macindos_pr;

    @FXML
    private ImageView material_pr;

    @FXML
    private ImageView material2_pr;

    @FXML
    private ImageView dark_pr;

    @FXML
    private ImageView light_pr;

    @FXML
    private JFXRadioButton macindosRBtn;

    @FXML
    private JFXRadioButton materialRBtn;

    @FXML
    private JFXRadioButton material2RBtn;

    @FXML
    private JFXRadioButton darkRBtn;

    @FXML
    private JFXRadioButton lightRBtn;

    @FXML
    private JFXToggleButton smart_arrange_toggle;

    @FXML
    private Rating rating_bar;

    @FXML
    private TextArea discription_box;

    @FXML
    void choosePath(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\ThunderGet"));
        chooser.setTitle("Choose Download Folder");
        chooser.showDialog(Home.getRoot().getScene().getWindow());
        File donwload_Dir = chooser.getInitialDirectory();
        download_path.setText(donwload_Dir.getAbsolutePath());
        Home.download_dir = new File(donwload_Dir.getAbsolutePath());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        root.setOpacity(0);
        download_path.setText(Home.download_dir.getAbsolutePath());
        FadeTransition transition = new FadeTransition(Duration.seconds(1),root);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();

    }
}
