package grp.anon.main;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;

public class Home extends Application {

    public static File download_dir = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\ThunderGet");

    @Override
    public void init() throws Exception {
        super.init();
        if (!download_dir.exists())
            download_dir.mkdir();
        /*String url = "https://www.google.co.in/search?q=facebook&source=lnms&tbm=isch&sa=X&ved=0ahUKEwih85HTqMPYAhWIRY8KHQ_IDn0Q_AUIDSgE&biw=1536&bih=753";
        getGoogleImagesLinks(url,new File("facebookLink.dat"));*/

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }

    private static StackPane mainRoot;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        mainRoot = (StackPane) root;
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("ThunderGet");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static StackPane getRoot(){
        return mainRoot;
    }

    public static void main(String[] args) {
        launch(args);
    }



    /*public void getGoogleImagesLinks(String url,File outPutFilePath) throws IOException {
        String rowLink;
        FileWriter writer = new FileWriter(outPutFilePath);
        FileWriter rowDataWriter = new FileWriter(new File("temp.dat"));
        BufferedReader reader = new BufferedReader(new FileReader(new File("temp.dat")));
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
    }*/
}
