import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * After the user creates an account with his/her username and password
 * then he gets the access to login into the account
 * On entering the valid details he logins into the account
 * 
 */
public class LogIn extends Register {
    public static Scanner sc = new Scanner(System.in);
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            //System.out.println("false");
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            //System.out.println("flase");
            return false;
        }
        //System.out.println("true");
        return true;
    }

    public static String[] readFiles1(String file) {// method for converting the data of the file into array and storing
        try {
            File f = new File(file);
            Scanner scann = new Scanner(f);// scann is the scanner object
            int c = 0;
            int flag = 0;
            while (scann.hasNextLine()) {// this is used for reading the lines of text file
                c++;
                scann.nextLine();
            }
            String[] arr = new String[c];// here we create an array arr
            Scanner s2 = new Scanner(f);// s2 is the scanner object
            for (int i = 0; i < arr.length; i++) {// we store the data into the array arr
                arr[i] = s2.nextLine();
            }
            System.out.println("You are here to LOGIN");
            System.out.println(("--------------------------------------------"));
            System.out.println("\nEnter the Username:");
            String uname = sc.next();// here on using the scanner object sc we take the input from user
            int x;
            for (int i = 0; i < arr.length; i++) {
                if (uname.equals(arr[i])) {// here it compares the input username with already existing username
                    flag = 1;
                    break;
                } else {
                    flag = 0;
                }
            }
            // System.out.print(uname);
            if (flag == 1) {// if the username is valid then it gets into the loop
                for (int i = 0; i < arr.length; i++) {
                    // System.out.println(arr[i]);
                    if (uname.equals(arr[i])) {
                        System.out.println("\nThe capatcha number is " + i);// here it asks to enter the captcha to login
                                                                          // successfully
                        String[] data1 = readFile1("password.txt");
                        // System.out.println(i);
                    }
                }
            }
            /**
             * if the username doesnot exist then we get into this part
             * where it asks to reenter the correct username if he is already an
             * existing user or create an account if he is new to LMS
             */
            else {
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("\nThe User Do Not EXIST");
                System.out.println("\nIf you are NEW USER click 1\nif you are ALREADY an EXISTING USER click 2");
                Scanner scan = new Scanner(System.in);// scan is the scanner object
                int cho = scan.nextInt();// here we take the username again
                System.out.println("\033[H\033[2J");
                System.out.flush();
                if (cho == 1) {
                    String[] data = readFiles("username.txt");// this calls the readFiles method
                    /** if the username exists here then is asks to relogin with correct username */
                    System.out.println("\nPlease LOGIN inorder to access the features of the software");
                    String[] data2 = readFiles1("username.txt");// this calls the readFiles1 method
                } else {
                    String[] data2 = readFiles1("username.txt");// it goes on asking for the username if invalid
                                                                // username is given
                }
                // System.exit(0);
            }
            // System.out.println("User does not exist");
            /*
             * for(int i=0;i<arr.length;i++){
             * arr[i]=s1.nextLine();
             * }
             */
            return arr;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String[] readFile1(String file) {// method for converting the data of the file into array and storing
        try {
            File f1 = new File(file);
            Scanner s2 = new Scanner(f1);// s is the scanner object
            int c1 = 0;
            int flag1 = 0,ind;
            while (s2.hasNextLine()) {// this is used for reading the lines of text file
                c1++;
                s2.nextLine();
            }
            String[] arr1 = new String[c1];// here we create an array arr
            Scanner s1 = new Scanner(f1);// s1 is the scanner object
            /*
             * for(int i=0;i<arr.length;i++){
             * arr[i]=s1.nextLine();
             * }
             */
            String ind1;
            boolean s;
            File fi = new File("C:\\Users\\USER\\Desktop\\tanmayee\\password.txt");
            System.out.println("\nEnter the captcha number:");// asks to enter for captcha visible on screen
            String index = sca.next();// takes the input of captcha
            s=isNumeric(index);
            if(!s){
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("\nMake sure the CAPTCHA you entered is a NUMBER");
                System.out.println("\nPlease LOGIN again\n");
                LMS1 obj11=new LMS1();
                obj11.lms1();    
                //String[] data2 = readFiles1("username.txt");
            }
            else{
                ind=Integer.parseInt(index);
                ind1=Integer.toString(ind);
                    //System.out.println(index);
                    //System.out.println(ind);
                    //System.out.println(ind1);

                System.out.println("\nEnter the Password:");
                String pass = sca.next();// takes the input of password
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = s1.nextLine();// data stored into the array
                }
                    //System.out.println(arr1[index]);
                    // File fi=new File("C:\\Users\\USER\\Desktop\\tanmayee\\password.txt");
                    //System.out.println(index);;
                if(index.equals(ind1)){
                    if(ind<arr1.length){
                        if (arr1[ind].equals(pass)) {// if the password matches then it logins into the system
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("\nYou have SUCCESSFULLY LOGGED into the library management software");                    
                            //System.out.println("\nYou have SUCCESSFULLY LOGGED into the library management software");
                        } else {//if not asks to enter again
                            System.out.println("\033[H\033[2J");
                            System.out.flush();    
                            System.out.println("\nDetails Do Not MATCH\n");
                            System.out.println("Please LOGIN again\n");
                            //String[] data2 = readFiles1("username.txt");
                            LMS1 obj11=new LMS1();
                            obj11.lms1();                
                        }
                    }
                    else{
                        System.out.println("\033[H\033[2J");
		                System.out.flush();
                        System.out.println("\nDetails Do Not MATCH\n");
                        System.out.println("Please LOGIN again\n");
                        //String[] data2 = readFiles1("username.txt");
                        LMS1 obj11=new LMS1();
                        obj11.lms1();            
                    }
                }
                else{
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("\nDetails Do Not MATCH\n");               
                    System.out.println("Please LOGIN again\n");
                    //String[] data2 = readFiles1("username.txt");
                    LMS1 obj11=new LMS1();
                    obj11.lms1();        
                }
            }
            return arr1;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] data = readFiles1("username.txt");
    }
}
