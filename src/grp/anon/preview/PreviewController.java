package grp.anon.preview;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

    @FXML
    private Pane progressPane1;

    @FXML
    private Pane progressPane2;

    private static Integer counter;

    private ArrayList<String> links;
    private SetPreview previewService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        links = new ArrayList<String>();
        previewService = new SetPreview();
        counter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\ThunderGet\\Links.dat")));
            String link;
            while ((link = reader.readLine()) != null){
                links.add(link.substring(link.indexOf('"')+1,link.indexOf('"',6)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            progressPane1.setOpacity(1);
            progressPane2.setOpacity(1);
            previewService.start();
        }
        previewService.setOnSucceeded(e->{
            progressPane1.setOpacity(0);
            progressPane2.setOpacity(0);
        });

    }

    @FXML
    void showMore(ActionEvent event) {
        previewService.restart();
    }
    @FXML
    void goHome(ActionEvent event) {
        Stage curStage = (Stage) root.getScene().getWindow();
        curStage.hide();
    }
    class SetPreview extends Service<Void>{
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    pb1.setImage(new Image(links.get(0)));
                    pb2.setImage(new Image(links.get(1)));
                    pb3.setImage(new Image(links.get(2)));
                    pb4.setImage(new Image(links.get(3)));
                    pb5.setImage(new Image(links.get(4)));
                    pb6.setImage(new Image(links.get(5)));
                    return null;
                }
            };
        }
    }
}
