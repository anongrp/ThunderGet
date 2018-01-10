package grp.anon.main;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private StackPane root_pane;

    @FXML
    private JFXTextField search_input;

    @FXML
    private JFXHamburger home_ham;

    @FXML
    private JFXDrawer home_drawer;

    @FXML
    private Pane progressPane;

    private GetLinkService linkService;
    private Stage previewStage = new Stage();

    private String startLink = "https://www.google.co.in/search?q=";
    private String endLink = "&dcr=0&source=lnms&tbm=isch&sa=X&ved=0ahUKEwjo3q-En8jYAhXBtY8KHZpfA44Q_AUICygC&biw=1536&bih=759&dpr=1.25";
    private String finalLink;
    public static String userKeyWord;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        linkService = new GetLinkService();
        previewStage.setResizable(false);

        /* Coding For Main Drawer */
        try {
            home_drawer.setSidePane((VBox)FXMLLoader.load(getClass().getResource("drawer.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        HamburgerBasicCloseTransition hamburgerAnimation = new HamburgerBasicCloseTransition(home_ham);
        hamburgerAnimation.setRate(-1);
        home_ham.addEventHandler(MouseEvent.MOUSE_PRESSED,e -> {
            hamburgerAnimation.setRate(hamburgerAnimation.getRate()*-1);
            hamburgerAnimation.play();

            if (home_drawer.isShown()){
                home_drawer.close();
            }else {
                home_drawer.open();
            }
        });


        search_input.addEventHandler(KeyEvent.KEY_PRESSED,e->{
            if (e.getCode().equals(KeyCode.ENTER)){
                progressPane.setOpacity(1);
                finalLink = startLink+search_input.getText()+endLink;
                userKeyWord = search_input.getText();
                linkService.restart();
                linkService.setOnSucceeded(afterSuccess ->{
                    try {
                        progressPane.setOpacity(0);
                        previewStage.setScene(new Scene((AnchorPane)FXMLLoader.load(getClass().getResource("../preview/preview.fxml"))));
                        previewStage.setTitle("Preview");
                        previewStage.show();
                    } catch (IOException ex) {
                        showError();
                    }
                });
                linkService.setOnFailed(afterFailed->{
                    progressPane.setOpacity(0);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("No Image Found");
                    alert.setHeaderText("Please Change Your Keyword or Remove png to Your Keyword");
                    alert.show();
                });
            }
        });
    }


    private void getGoogleImagesLinks(String url, File outPutFilePath) throws IOException {
        String rowLink;
        FileWriter writer = new FileWriter(outPutFilePath);
        FileWriter rowDataWriter = new FileWriter(new File("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\ThunderGet\\temp.dat"));
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\ThunderGet\\temp.dat")));
        Document document = Jsoup.connect(url).get();
        Elements divTags = document.getElementsByTag("div");
        rowDataWriter.write(divTags.toString());
        rowDataWriter.close();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject;

        while ((rowLink = reader.readLine()) != null){
            if (rowLink.contains("ou") && rowLink.contains("http")){
                if (rowLink.contains("jpg") || rowLink.contains("png")){
                    jsonObject = parser.parse(rowLink).getAsJsonObject();
                    writer.append(String.valueOf(jsonObject.get("ou"))).append("\n");
                }
            }
        }

        writer.close();
        reader.close();
    }

    private void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("NetWork Error, Please Contact To ThunderGet Developer's ");
        alert.setHeaderText("Some Problem Occure");
        alert.show();
    }

    class GetLinkService extends Service<Void>{

        @Override
        protected Task<Void> createTask() {

            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        getGoogleImagesLinks(finalLink,new File("C:\\Users\\"+System.getProperty("user.name")+"\\AppData\\Local\\ThunderGet\\Links.dat"));
                    } catch (IOException e) {
                        showError();
                    }
                    return null;
                }
            };
        }
    }
}
