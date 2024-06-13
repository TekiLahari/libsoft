import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;
/**
 * In this returnbook they update the details of any of the book 
 * which is returned by the student
 * the book count gets increased
 */

public class ReturnBook {
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

    public static void write(String id, File fi) throws IOException {// creating a method to write the data to file
        FileWriter fw = new FileWriter(fi, true);// appends the data into the textfile
        /*
         * If the second argument of the FileWriter true,
         * then bytes will be written to the end of the file rather than the beginning.
         * which means we can append the data into the file
         */
        fw.write(id);
        fw.close();
    }
    public static String getDate(){
        LocalDateTime date=LocalDateTime.now();
        return date.toString();
    }


    public static String[] returnbook(String file) {// converting the data of the file into array and storing
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
                arr[i] = s2.nextLine();// we store the data into the array
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
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("You are here to RETURN BOOK");
            System.out.println("------------------------------------------------------");
            System.out.println("\nEnter the Bookname:");
            String bname = sc.next();// here on using the scanner object sc we take the input from user
            int index;
            for (int i = 0; i < arr1.length; i++) {
                // System.out.println(arr[i]);
                if (bname.equals(arr[i])) {// here it compares the input bookname with the available books
                    flag = 1;
                    System.out.println("\nThe Book IS IN LIBRARY");
                    index = i;
                    System.out.println("\nThe Number of Books Available is " + arr1[i]);// this returns the number of
                                                                                      // books available
                    int x = Integer.parseInt(arr1[i]);// converting into integer
                    System.out.println("\nEnter y to UPDATE the DETAILS of RETURNED Book");
                    Scanner ser = new Scanner(System.in);// s1 is the scanner object
                    String ch = ser.next();// takes the input using the scanner object
                    /*
                     * if anyone is returning the book on giving their details
                     * it shows that they have returned the book
                     * the books count will also be updated
                     * the books count is increased
                     */
                    if (ch.equals("y")) {
                        System.out.println("\nEnter Roll Number: ");
                        String ro = ser.next();// takes the rollno using the ser scanner object
                        int y = x + 1; // here we increase the number of count of the books as the book is returned and
                                       // store it in the integer variable y
                        String z = Integer.toString(y);// to convert the integer to string
                                                       // we convert it so that we will be able to store it in the form
                                                       // of a string
                        arr1[i] = z;// we store the increased count again into into particular index
                        // writer(arr,fi);
                        writer("count.txt", arr1);// used to write into the text file
                        File fi = new File("returnreport.txt");
                        write("The book " + bname + " has been returned by " + ro +" on "+ getDate()+ "\n", fi);
                        System.out.println("The Book " + bname + " has been returned by " + ro+" on "+ getDate());
                        break;

                    }
                } else {
                    flag = 0;
                }
            }
            if (flag == 1) {
            } else {
                System.out.println("\nThe Book is NOT in LIBRARY");
            }
            Scanner sac = new Scanner(System.in);// sac is the scanner object
            /* here it again asks if they want to update details of any other book */
            System.out.println("-----------------------------------------------------------");
            /*System.out.println("\nDo you want to update the deatils of returning of another book\nEnter y if want to and anything not to");
            String ch = sac.next();// it takes the details of other bookname which they want to return
            if (ch.equals("y")) {
                String[] data2 = returnbook("bookname.txt");
            } else {
            }*/
            return arr1;

        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String[] data12 = returnbook("bookname.txt");

    }
}