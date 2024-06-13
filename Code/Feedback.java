import java.io.*;
import java.util.*;
import java.lang.*;

/**
 * At the end the user is asked to give the feedback
 * if he/she wants to,so that we could get any new suggestions
 * from the user.
 * 
 */
public class Feedback {
    public static void wr(String id, File fi) throws IOException {// creating a method to write the data to file
        FileWriter fwr = new FileWriter(fi, true);// appends the data into the textfile
        /**
         * If the second argument of the FileWriter true,
         * then bytes will be written to the end of the file rather than the beginning.
         * which means we can append the data into the file
         */
        // PrintWriter pw=new PrintWriter(fw);
        fwr.write(id);
        fwr.close();
    }

    // public static Scanner scan=new Scanner(System.in);
    public static String feedback(String file) {// this is a method named feedback
        Scanner sca = new Scanner(System.in);// a scanner sca object is created
        System.out.println("You are here to give the FEEDBACK");
        System.out.println("-------------------------------------------");
        System.out.println("\nEnter the feedback you want to give:");
        String fil = sca.nextLine();// takes the feedback in the input form
        File fi = new File("feedback.txt");
        try {
            wr(fil + "\n", fi);// for writing into the file
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("\nThankyou For giving your feedback\n");
        System.out.println("-------------------------------------------------");
       // System.out.println("The feedback given by you is " + fil);//displays on screen 
        return " ";
    }

    public static void main(String[] args) {
        String data = feedback("feedback.txt");
    }

}
