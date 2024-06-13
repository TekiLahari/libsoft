import java.io.*;
import java.util.*;
import java.lang.*;
import java.time.*;
/** 
 * After when we login as user then we get the options such as to search a book and know its availability,to reserve a book and feedback.
 * When you want to reserve a book the system first asks for the bookname and checks if there is any previous reservation on that book.
 * If there are no previous reservation then asks for the user rollnumber and reserves the book and generates a report on that reservation.
 * If there is a previous reservation then a message will be displayed as the book cannot be reserved.This reserve report helps the admin at the 
 time of issuing the book,So the admin checks the reservation and then issue the book.
 * According to this code one book can only reserved by one member,if other wants to reserve the same book the they cannot reserve this book.
 */
public class Reserve {
    //public static Scanner sc=new Scanner(System.in);
    public static void write(String id,File fi)throws IOException{//creating a method to write the data to file 
        FileWriter fw=new FileWriter(fi,true);//opens the file in appending mode 
        fw.write(id);
        fw.close();
    }
    public static void writes(String ide,File fil)throws IOException{//creating a method to write the data to file
        FileWriter fwr=new FileWriter(fil,true);//opens the file in appending mode
        fwr.write(ide);
        fwr.close();
    }
    public static String getDate(){
        LocalDateTime date=LocalDateTime.now();
        return date.toString();
    }
    public static String[] reserve(String file){// converting the data of the file into array and storing into the files 
        try{
            Scanner sc=new Scanner(System.in);//sc is the scanner object
            File f =new File("bookname.txt");
            Scanner scann=new Scanner(f);//scann is the scanner object
            int c=0;
            int flag=0;
            while(scann.hasNextLine()){//this is used for reading the lines of text file which is bookname.txt
                c++;
                scann.nextLine();
            }
            String[] arr=new String[c];//here we create an array which has the book names
            Scanner s2=new Scanner(f);
            for(int i=0;i<arr.length;i++){//we store data into array arr
                arr[i]=s2.nextLine();
            }
            File f1 =new File("reserve.txt");
            Scanner s=new Scanner(f1);//s is the scanner object
            int c1=0;
            int flag1=0;
            while(s.hasNextLine()){//this is used for reading the lines of text file which is reserve.txt
                c1++;
                s.nextLine();
            }
            String[] arr1=new String[c1];//here we create an array of previous reservations on the book 
            Scanner s1=new Scanner(f1);//s1 is the scanner object
            for(int i=0;i<arr1.length;i++){//we store data into an array arr1
                arr1[i]=s1.nextLine();
            }
            System.out.println("You are here to RESERVE a book");
            System.out.println("---------------------------------------------------");
            System.out.println("\nEnter the Bookname:");
            String uname=sc.next();//uname is the variable stores the bookname
            //System.out.print(uname);
            for(int i=0;i<arr.length;i++){
                //System.out.println(arr[i]);
                if(uname.equals(arr[i])){//making sure the book is in the library or not  
                    flag=1;
                    break;
                }
                else{//if not in the library 
                    flag=0;
                }
            }
            //System.out.println("erhb");
            for(int i=0;i<arr1.length;i++){//making sure if the book has been already reserved are not 
                //System.out.println(arr[i]);
                if(uname.equals(arr1[i])){//if found then the flag1 variable rises 
                    flag1=1;
                    break;
                }
                else{//if not reserved previously
                    flag1=0;
                }
            }
            if(flag1==0){
                if(flag==1){
                    System.out.println("\nThe Book IS IN the LIBRARY ");
                    Scanner scan=new Scanner(System.in);//scan is the scanner object 
                    System.out.println("\nEnter the Roll Number ");
                    String fil=scan.next();//fil stores the roll number by whom the book has been reserved
                    System.out.println("\nEnter y if you want to RESERVE the Book and anything to not to reserve");
                    String res=scan.next();//res stores the confirmation from the user to reserve the book
                    if(res.equals("y")){//if res stores y ie if user want to reserve 
                        File fi=new File("reservereport.txt");
                        File fill=new File("reserve.txt");
                        write("The book " + uname + " has been reserved by "+ fil +" on "+ getDate() +"\n",fi);//creates a report by whom the book has been reserved 
                        writes(uname+"\n",fill);//stores the book name which has reserved 
                        System.out.println("The Book " + uname + " has been reserved by "+fil+ " on "+ getDate());//displays on the screen 
                        System.out.println("Please make sure that this book will only be reserved for 2 days ");
                    }
                    else{// if user does not want to reserve 
                        System.out.println("\nThe Book has NOT been RESERVED");
                    }
                }
                else{//if uname ie the book name doesnot found in the library 
                    System.out.println("\nThe Book is not in the LIBRARY .Please give us in the FEEDBACK form we will Try to ADD the book");
                }
            }
            else{// if the uname is already in reserve.txt
                System.out.println("\nThe Book has ALREADY been RESERVED");
            }
            //String [] data1=reserve("bookname.txt");
            Scanner sce=new Scanner(System.in);//sce is the scanner object  
            System.out.println("--------------------------------------------------------------------");   
            /*System.out.println("\nDo you want to RESERVE ANY other Book?\n \nClick y to reserve other book and anything not to reserve");
            String c3=sce.nextLine();//stores the confirmation whether want to reserve any other 
            System.out.println("\033[H\033[2J");
            System.out.flush();
            if(c3.equals("y")){//if yes goes for another time
                String [] data2=reserve("bookname.txt");
            }
            else{//skips and goes to next which is feedback

            }*/

            return arr;
        }
        catch(Exception e){
            return null;
        }
    }
    public static void main(String[] args){
        String[] data=reserve("bookname.txt");
    }
}
