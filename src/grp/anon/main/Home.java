package grp.anon.main;

import anon.database.*;
import anon.database.connect.Connection;
import com.jfoenix.controls.JFXAlert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;

public class Home extends Application {

    public static File download_dir ;
    public static Database mainDB;
    public static Table prefTable;
    public static Table tempTable;

    @Override
    public void init() throws Exception {
        super.init();
        boolean dbStatus = initDatabase();
        try {
            mainDB = new Database("ThunderGet");
            prefTable = new Table("prefTable",mainDB);
            tempTable = new Table("tempTable",mainDB);
            tempTable.setColumns(new String[]{"id","value"});
        } catch (TableCreationOutOfBoundException | DatabaseConnectionException e) {
            showError();
        }
        try {
            initHomePath();
        } catch (ColumnIndexOutOfBoundException e) {
            showError();
        }
        String homePath = tempTable.getRow("id","HOMEPATH").get(1);
        download_dir = new File(homePath);
        if (!download_dir.exists())
            download_dir.mkdir();
    }

    private boolean initDatabase(){
        return Connection.connect("ThunderGet");
    }

    private static void initHomePath() throws IOException, ColumnIndexOutOfBoundException {
        if (tempTable.getRow("id","HOMEPATH").get(0) == null){
            tempTable.addRow(new String[]{"HOMEPATH","C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\ThunderGet"});
        }
    }

    public static void updateHomePath(String newPath) throws IOException, ColumnIndexOutOfBoundException {
        tempTable.deleteElement("id","HOMEPATH");
        tempTable.addRow(new String[]{"HOMEPATH",newPath});
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }

    public static StackPane mainRoot;
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
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

    private void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Database Error Please ReInstall Software For Again Init Database");
        alert.setHeaderText("Database Error");
        alert.setOnCloseRequest(lambda->{
            System.exit(1);
        });
        alert.show();
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
