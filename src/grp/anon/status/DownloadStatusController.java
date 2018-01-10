package grp.anon.status;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import grp.anon.main.Home;
import grp.anon.main.HomeController;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DownloadStatusController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ProgressIndicator download_progress;

    @FXML
    private JFXTextArea download_status_text;

    @FXML
    private JFXTextField imageQuantity;


    private static ArrayList<String> links;
    private Integer quantity;
    private Download downloadService;
    private File downloadPath;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        downloadService = new Download();
        download_progress.progressProperty().bind(downloadService.progressProperty());
        downloadService.setOnSucceeded(e->{
            System.out.println("Done");
        });
    }


    @FXML
    void startDownloading(ActionEvent event) {
        if (!imageQuantity.getText().equals("")){
            try {
                quantity = Integer.parseInt(imageQuantity.getText());
                downloadPath = new File(Home.download_dir.getAbsolutePath()+"\\"+HomeController.userKeyWord);
                /*if (!downloadPath.exists())
                    downloadPath.mkdir();*/
                downloadService.start();
            }catch (Exception e){
                showAert("Please Enter Integer Value ");
            }
        }
    }

    @FXML
    void cancelDownloading(ActionEvent event) {
        downloadService.cancel();
        download_progress.setProgress(0);
        download_status_text.appendText("Download Canceled ");
    }

    private static void download(String imgUrl, String downloadDir) throws IOException {
        URL url = new URL(imgUrl);
        InputStream in = new BufferedInputStream(url.openStream());
        try {
            FileOutputStream fos = new FileOutputStream(downloadDir+getImageName(imgUrl));
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1!=(n=in.read(buf)))
            {
                fos.write(buf,0,n);
            }
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

    private void showAert(String msg){
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
                    Integer index=0;
                    while (index<quantity){
                        DownloadStatusController.download(links.get(index),downloadPath.getAbsolutePath());
                        updateProgress(index,quantity-1);
                        download_status_text.appendText(getImageName(links.get(index)+"\t\t  -- Downloaded \n"));
                        index++;
                    }
                    return null;
                }
            };
        }
    }
}