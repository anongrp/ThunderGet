
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> pureLink = new ArrayList<>();
        ArrayList<String> imageLinks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("Google.html")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("imageLinks.html"),true));
        String data;
        while ((data = reader.readLine())!= null){
            if (data.contains("http") && data.contains("com") && (data.contains(".jpg") || data.contains(".png"))){
                try {
                    imageLinks.add(data.substring(data.indexOf("http"),data.indexOf('"',data.indexOf("http"))));
                }catch (Exception e){
                    System.out.println("Exception");
                }
            }
        }
        int dotIndex,counter=0;
        for (String i:imageLinks){
            dotIndex = i.indexOf(".",i.indexOf("com"));
            try {
                pureLink.add(i.substring(i.indexOf("http"),i.indexOf("g",dotIndex)+1));
            }catch (Exception e){
                System.out.println("Exception");
            }
        }

        for (String j : pureLink){
            counter++;
            System.out.println(j);
        }
        System.out.println("Total Links Are : "+counter);
        writer.close();
    }
}