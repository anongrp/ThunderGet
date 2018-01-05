import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL website = new URL("https://github.com/Anikeshpatel/AnDatabase/blob/master/images/AnonDatabase.png");
        try (InputStream in = website.openStream()) {
            Files.copy(in, Paths.get(""), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
