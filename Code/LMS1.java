import java.io.*;
import java.util.*;
import java.lang.*;

public class LMS1 {
    public  void lms1()throws IOException{
        System.out.println( "\nWelcome to VVIT LMS");
        System.out.println("-------------------------------------------------");
        System.out.println("Enter 1 for SIGNUP \nEnter 2 for LOGIN\nEnter 3 to EXIT");
        Scanner scan=new Scanner(System.in);//scan is the scanner object 
        int choice=scan.nextInt();
        switch(choice){
            case 1:
            System.out.println("\033[H\033[2J");
                        System.out.flush();
            Register obj=new Register();//an object obj created for the class Register 
            String [] data=obj.readFiles("username.txt");
            LMS1 obj11=new LMS1();
            obj11.lms1();
            break;
            case 2:
            System.out.println("\033[H\033[2J");
                        System.out.flush();
            LogIn obj1=new LogIn();//an object obj created for the class LogIn
            String[] data2=obj1.readFiles1("username.txt");
            LMS2 obj12=new LMS2();
            obj12.lms2();
            break;
            case 3:
            System.out.println("You are here to EXIT");
            System.out.println("THANKYOU FOR USING VVIT LMS");
            System.out.println("--------------------------------");
            System.exit(0);
            default:
            System.out.println("\033[H\033[2J");
                        System.out.flush();
            System.out.println("\nPlease choose from the above");
            LMS1 obj2=new LMS1();
            obj2.lms1(); 
        }

    }
}
