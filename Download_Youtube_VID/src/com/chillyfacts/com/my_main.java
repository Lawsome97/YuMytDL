
package com.chillyfacts.com;
import java.io.PrintWriter;
import java.util.Scanner;
public class my_main {
    public static void main(String[] args) {

        String download_path="C:\\Users\\anina\\OneDrive\\Dokumente\\Youtube-dl";
        String destination_path= "C:\\Users\\anina\\Music";
        String url="https://www.youtube.com/watch?v=95Rzsn-zjr0";
        Scanner scanner = new Scanner(System.in);
        
        
        Process p;
        try {
            p = Runtime.getRuntime().exec("cmd");
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl   --get-url  "+ url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}