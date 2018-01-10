/*
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

class Temp{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("PureImageLinks.html")));
        String data;

    }
    public static void download(String imgUrl,int count) throws IOException {
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

    public static String getImageName(String data){
        return data.substring(data.lastIndexOf("/")+1,data.length());
    }
}
*/
