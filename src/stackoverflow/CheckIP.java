package stackoverflow;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class CheckIP {
    
    public static boolean isInternetReachable(String ip)
   {
       try {
           //make a URL to a known source
           URL url = new URL("http://" + ip);

           //open a connection to that source
           HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

           //trying to retrieve data from the source. If there
           //is no connection, this line will fail
           Object objData = urlConnect.getContent();

       } catch (Exception e) {              
           e.printStackTrace();
           return false;
       }

       return true;
   }
    
public static void main(String args[]) throws UnknownHostException, IOException {
    String ip = "78.46.84.171";

    System.out.println("isInternetReachable=" + isInternetReachable(ip));
    if(InetAddress.getByName(ip).isReachable(5000)){
        System.out.println("Reachable.");
    }
    else{
        System.out.println("Not Reachable.");
    }
}
}