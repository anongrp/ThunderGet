package grp.anon.preview;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
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

    @FXML
    private ImageView pb6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> links = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\ThunderGet\\Links.dat")));
            String link;
            while ((link = reader.readLine()) != null){
                links.add(link.substring(link.indexOf('"')+1,link.indexOf('"',6)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
