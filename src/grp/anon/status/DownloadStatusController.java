package grp.anon.status;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
    private JFXTextField imageQuantity;

    @FXML
    private JFXButton startBtn;

    private static ArrayList<String> links;
    //private Integer quantity;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void startDownloading(ActionEvent event) {
        /*for (String i:links){
            System.out.println(i);
        }*/
        Integer quantity = null,index=0;
        if (!imageQuantity.getText().equals("")){
            try {
                quantity = Integer.parseInt(imageQuantity.getText());
                while (index < quantity){
                    download(links.get(index));
                    index++;
                }
            }catch (Exception e){
                showAert("Please Enter Integer Value ");
            }
        }
    }

    @FXML
    void cancelDownloading(ActionEvent event) {

    }

    private static void download(String imgUrl) throws IOException {
        URL url = new URL(imgUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Anikesh\\Desktop\\"+getImageName(imgUrl));
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                fos.write(buf,0,n);
            }
            System.out.println(getImageName(imgUrl)+" Succesfully Downloaded" );
            fos.close();
        }catch (Exception e){
            System.out.println("Exception Occure");
        }
        in.close();
    }

    private static String getImageName(String data){
        return data.substring(data.lastIndexOf("/")+1,data.length());
    }

    @FXML
    void goHome(ActionEvent event) {

    }

    public static void setLinks(ArrayList<String> getedLink){
        links = getedLink;
    }

    public void showAert(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ThunderGet Information");
        alert.setHeaderText(msg);
        alert.show();
    }

    class Download extends Service{
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {


                    return null;
                }
            };
        }
    }
}