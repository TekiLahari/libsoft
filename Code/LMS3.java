import java.io.*;
import java.util.*;
import java.lang.*;
public class LMS3 {
    public static void lms3() throws IOException{
        System.out.println("-------------------------------------------------");
        System.out.println("\nEnter 1 to ISSUE BOOK \nEnter 2 to RETURN BOOK \nEnter 3 to ADD BOOK \nEnter 4 to UPDATE STOCK\nEnter 5 for MAINTAIN INVENTORY\nEnter 6 to EXIT AS ADMIN ");
        Scanner scann=new Scanner(System.in);
        int choice2=scann.nextInt();
        switch(choice2){
            case 1:
            System.out.println("\033[H\033[2J");
                    System.out.flush();
            //System.out.println("\nyou are here to issue book");
            IssueBook obj5=new IssueBook();//an object obj created for the class IssueBook
            String[] data6=obj5.issuebook("bookname.txt");
            break;
            case 2:
            System.out.println("\033[H\033[2J");
            System.out.flush();
            //System.out.println("\nyou are here to update the details of returned book");
            ReturnBook obj6=new ReturnBook();//an object obj created for the class ReturnBook
            String[] data7=obj6.returnbook("bookname.txt");
            break;
            case 3:
            System.out.println("\033[H\033[2J");
                    System.out.flush();
            //System.out.println("\nyou are here to add a new book");
            AddBook obj7=new AddBook();//an object obj created for the class AddBook
            String[] data10=obj7.addbook("bookname.txt");
            break;
            case 4:
            System.out.println("\033[H\033[2J");
                    System.out.flush();
            //System.out.println("\nyou are here to update the stock");
            UpdateStock obj8=new UpdateStock();//an object obj created for the UpdateStock
            String[] data11=obj8.updatestock("bookname.txt");
            break;
            case 5:
            System.out.println("\033[H\033[2J");
            System.out.flush();
            MaintainInventory obj9=new MaintainInventory();
            String data12=obj9.account();
            break;
            case 6:
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("You are here as USER");
            LMS2 obj12=new LMS2();
            obj12.lms2();
            default:
            System.out.println("Please choose from above");
            LMS3 obj10=new LMS3();
            obj10.lms3();
            break;
        }
        LMS3 obj10=new LMS3();
        obj10.lms3();
    }
    
}
