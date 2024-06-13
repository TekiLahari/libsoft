import java.io.*;
import java.util.*;
import java.lang.*;

public class ViewBooks {
    public  void reader(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
}
