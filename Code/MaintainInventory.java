import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.LocalDate;

public class MaintainInventory {
    public static String account(){
        Scanner s1=new Scanner(System.in);
        System.out.println("You are here for MAINTAIN INVENTORY");
        System.out.println("---------------------------------------------------");
        System.out.println("Enter the Roll-No:");
        String rollno=s1.next();
        String word =rollno; // the word you want to find
            String line;        
            try (BufferedReader br = new BufferedReader(new FileReader("reservereport.txt"))) { // open file foobar.txt
            while ((line = br.readLine()) != null) { //read file line by line in a loop
                if(line.contains(word)) { // check if line contain that word then prints the line
                    System.out.println(line);
                }
            }
            try (BufferedReader br1 = new BufferedReader(new FileReader("issuereport.txt"))) { // open file foobar.txt
                String line1;
                while ((line1 = br1.readLine()) != null) { //read file line by line in a loop
                    if(line1.contains(word)) { // check if line contain that word then prints the line
                        System.out.println(line1);
                    }
                }
                try (BufferedReader br2 = new BufferedReader(new FileReader("returnreport.txt"))) { // open file foobar.txt
                    String line2;
                    while ((line2 = br2.readLine()) != null) { //read file line by line in a loop
                        if(line2.contains(word)) { // check if line contain that word then prints the line
                            System.out.println(line2);
                        }
                    }
                }
                catch(Exception ee){
                    System.out.println(ee);
                }
            }
            catch(Exception e1){
                System.out.println(e1);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    return " ";
    }
    public static void main(String[] args) {
        String data111 = account();
    }
}
