import java.io.*;
import java.util.*;
import java.lang.*;

public class Search {
    // Scanner sc=new Scanner(System.in);
    public static String[] search(String file) {// method for converting the data of the file into array and storing
        Scanner sc = new Scanner(System.in);// sc is the scanner object
        try {
            File f = new File("bookname.txt");// this is used to access this textfile
            Scanner scann = new Scanner(f);
            int c = 0;
            int flag = 0;
            while (scann.hasNextLine()) {// this is used for reading the lines of text file
                c++;
                scann.nextLine();
            }
            String[] arr = new String[c];// here we create an array arr
            Scanner s2 = new Scanner(f);// s2 is the scanner object
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s2.nextLine();// we store the data into the array arr
            }
            File f1 = new File("count.txt");// this is used to access the textfile
            Scanner s = new Scanner(f1);// s is the scanner object
            int c1 = 0;
            int flag1 = 0;
            while (s.hasNextLine()) {// this is used for reading the lines of text file
                c1++;
                s.nextLine();
            }
            String[] arr1 = new String[c1];// here we create an array arr1
            Scanner s1 = new Scanner(f1);// s1 is the scanner object
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = s1.nextLine();// we store the data into the array arr1
            }   
            System.out.println("\nEnter the Bookname:");
            String bname = sc.next();// takes the input of bookname and stores it in bname
            int index;
            for (int i = 0; i < arr1.length; i++) {
                // System.out.println(arr[i]);
                if (bname.equals(arr[i])) {// compares the input bookname with the available books
                    flag = 1;
                    System.out.println("\nThe Book is AVAILABLE");
                    index = i;
                    System.out.println("\nThe Number of Books Available is " + arr1[i]);// this returns the number of
                                                                                      // books available
                    System.out.println("------------------------------------------------");
                    break;
                }
                else {
                    flag = 0;
                }
            }
            if (flag == 1) {
            }
            else {
                System.out.println("\nThe book is NOT AVAILABLE so please tell us in the FEEDBACK form about the book you need");
            }
           /* Scanner sca = new Scanner(System.in);  
            System.out.println("\nYou are here to SEARCH the books");  
            System.out.println("----------------------------------------------------");
            System.out.println("\n\nDo you want to SEARCH any other book?\n \nClick y to search other book and anything not to search");
            String ch = sc.next();// takes the input character using the sc scanner object
            if (ch.equals("y")) {
                System.out.println("\033[H\033[2J");
                System.out.flush();    
                //System.out.println("\nYou are here to SEARCH the books\n");
                //System.out.println("--------------------------------------------------------");
                String[] data2 = search("bookname.txt");// if the user gives y as input then it again calls the search
                                                        // method where is asks for the bookname
            }
            else {

            }*/
            return arr1;
        }
        catch (Exception ee) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] data = search("bookname.txt");
    }
}
