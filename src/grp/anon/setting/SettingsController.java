package grp.anon.setting;

import anon.database.ColumnIndexOutOfBoundException;
import grp.anon.main.Home;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
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
import java.io.IOException;
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
    private TextArea description_box;

    @FXML
    void choosePath(ActionEvent event) throws IOException, ColumnIndexOutOfBoundException {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setInitialDirectory(Home.download_dir);
        chooser.setTitle("Choose Download Folder");
        File downwload_Dir = chooser.showDialog(Home.getRoot().getScene().getWindow());
        download_path.setText(downwload_Dir.getAbsolutePath());
        Home.updateHomePath(downwload_Dir.getAbsolutePath());
        System.out.println(downwload_Dir.getAbsolutePath());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*root.setOpacity(0);
        download_path.setText(Home.download_dir.getAbsolutePath());
        FadeTransition transition = new FadeTransition(Duration.seconds(1),root);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();*/


        macindosRBtn.setOnAction(e->{

        });
        materialRBtn.setOnAction(e->{

        });
        material2RBtn.setOnAction(e ->{

        });
        darkRBtn.setOnAction(e ->{

        });
        lightRBtn.setOnAction(e ->{

        });

        smart_arrange_toggle.addEventHandler(MouseEvent.MOUSE_CLICKED,e ->{

        });
        smart_arrange_toggle.addEventHandler(MouseEvent.MOUSE_ENTERED,e->{
            description_box.setText("Smaart Arrange Is A ThunderGet Facility That Past Your Downloaded Images In A Separate Folder's.");
        });
        rating_bar.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{

        });
        rating_bar.addEventHandler(MouseEvent.MOUSE_ENTERED,e->{
            description_box.setText("Give Rating");
        });
    }
}
