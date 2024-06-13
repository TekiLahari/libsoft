import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;

/**
 * this is accessed by the librarian
 * he/she can issue the book to that person
 * 
 */
public class IssueBook {
    public static void writer(String filename, String[] x) throws IOException {// creating a method to write the data to
                                                                               // file
        BufferedWriter outpuWriter = null;
        outpuWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.length; i++) {// changing the whole data in the file to the new data
            outpuWriter.write(x[i] + "");
            // outpuWriter.write(x[i]);
            outpuWriter.newLine();
        }
        outpuWriter.flush();
        outpuWriter.close();
    }

    public static void reader(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
    public static String getDate(){
        LocalDateTime date=LocalDateTime.now();
        return date.toString();
    }

    public static void write(String id, File fi) throws IOException {// creating a method to write the data to file
        FileWriter fw = new FileWriter(fi, true);// appends the data into the textfile
        /**
         * If the second argument of the FileWriter true,
         * then bytes will be written to the end of the file rather than the beginning.
         * which means we can append the data into the file
         */
        fw.write(id);
        fw.close();
    }

    public static String[] issuebook(String file) {// method for converting the data of the file into array and storing
        Scanner sc = new Scanner(System.in);// sc is the scanner object
        try {
            File f = new File("bookname.txt");
            Scanner scann = new Scanner(f);
            int c = 0;
            int flag = 0;
            while (scann.hasNextLine()) {// this is used for reading the lines of text file
                c++;
                scann.nextLine();
            }
            String[] arr = new String[c];
            Scanner s2 = new Scanner(f);// s2 is the scanner object
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s2.nextLine();
            }
            File f1 = new File("count.txt");
            Scanner s = new Scanner(f);// s is the scanner object
            int c1 = 0;
            int flag1 = 0;
            while (s.hasNextLine()) {// this is used for reading the lines of text file
                c1++;
                s.nextLine();
            }
            String[] arr1 = new String[c1];
            Scanner s1 = new Scanner(f1);// s1 is the scanner object
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = s1.nextLine();// we store the data into the array
            }
            System.out.println("\n\nYou are here to ISSUE BOOK\n");
            System.out.println("-----------------------------------------");
            System.out.println("\nEnter the Bookname:");
            String bname = sc.next();// here on using the scanner object sc we take the input from user
            int index;
            for (int i = 0; i < arr1.length; i++) {
                // System.out.println(arr[i]);
                if (bname.equals(arr[i])) {// here it compares the input bookname with the available books
                    flag = 1;
                    System.out.println("\nThe Book is IN LIBRARY");
                    index = i;
                    System.out.println("\nThe Number of Books available is " + arr1[i]);// this returns the number of
                                                                                      // books available
                    int x = Integer.parseInt(arr1[i]);// converting into integer
                    if (x > 1) {
                        System.out.println("\nEnter y to issue book");
                        Scanner ser = new Scanner(System.in);// ser is the scanner object created
                        String ch = ser.next();// it takes the input from the user
                        if (ch.equals("y")) {
                            System.out.println("\nEnter Roll No: ");
                            String ro = ser.next();// takes the input as rollno
                            int y = x - 1;
                            /*
                             * if anyone is issued book on taking their rollno
                             * it shows that they have been issued a book
                             * the books count will also be updated
                             * the books count is reduced
                             */
                            String z = Integer.toString(y);
                            arr1[i] = z;
                            // writer(arr,fi);
                            writer("count.txt", arr1);
                            File fi = new File("issuereport.txt");
                            write("The book " + bname + " has been issued to " + ro + " on "+ getDate()+"\n", fi);
                            System.out.println("\nThe Book " + bname + " has been issued to " + ro+" on "+ getDate());
                            /*
                             * for(int i=0;i<arr.length;i++){
                             * System.out.println(arr[i]);
                             * }
                             */

                        }
                    } else if (x == 1) {
                        Scanner ser = new Scanner(System.in);
                        System.out.println("Check the PREVIOUS RESERVATIONS\n");
                        reader("reservereport.txt");
                        /*System.out.println("If there are previous reservation book cannot be issued");
                        System.out.println(
                                "If there is no previous reservations click y to issue book and anything not to");
                        System.out.println("If the book is reserved by the same person the book can be issued");*/
                        System.out.println(
                                "Is the user reserved the book \n\nEnter y if user is the person who reserved the book and anything if not");
                        String cha = ser.next();
                        if (cha.equals("y")) {
                            System.out.println("\nThe Book can be Issued");
                            System.out.println("\nEnter Roll No: ");
                            String ro = ser.next();
                            int y = x - 1;
                            String z = Integer.toString(y);
                            arr1[i] = z;
                            // writer(arr,fi);
                            writer("count.txt", arr1);
                            File fi = new File("issuereport.txt");
                            write("The book " + bname + " has been issued to " + ro + "\n", fi);
                            System.out.println("\nThe Book " + bname + " has been issued to " + ro);
                        } else {
                            System.out.println("The Book CANNOT be Issued");
                        }
                    } else {
                        System.out.println("Book CANNOT be Issued");
                    }

                    break;
                } else {
                    flag = 0;
                }

            }
            if (flag == 1) {
            } else {
                System.out.println("\nThe Book is NOT in the LIBRARY");
            }
            Scanner sac = new Scanner(System.in);
            System.err.println("----------------------------------------------------------------");
            /*System.out.println("\nDo you want to ISSUE Another Book\nEnter y if want to and anything not to");
            String ch = sac.next();
            System.out.println("\033[H\033[2J");
            System.out.flush();
            if (ch.equals("y")) {
                String[] data2 = issuebook("bookname.txt");
            } else {
            }*/
            return arr1;
        } catch (Exception ee) {
            return null;
        }

    }

    public static void main(String[] args) {
        String[] data10 = issuebook("bookname.txt");

    }
}