import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * Only Admin has the access to this feature.
 * If there is a new book so to update the book details we use this.
 * Bookname and the number of books will be updated,so the users can use the books.
 * If the book is already available then asks for the updation of books not add book.
 */
public class AddBook {
    public static Scanner sc=new Scanner(System.in);
    public static void write(String id,File fi)throws IOException{//creating a method to write the data to file
        FileWriter fw=new FileWriter(fi,true);//file opening in append mode
        fw.write(id);
        fw.close();
    }
    public static String[] addbook(String file){// converting the data of the file into array and storing the appended data into files
        try{
            File f =new File(file);
            Scanner s=new Scanner(f);//s is the scanner object
            int c=0;
            int flag=0;
            while(s.hasNextLine()){//reading the lines of text files
                c++;
                s.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s1=new Scanner(f);//s1 is the scanner object
            for(int i=0;i<arr.length;i++){//we store data into the array arr
                arr[i]=s1.nextLine();
            }
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("You are here to ADD A NEW BOOK into the library");
            System.out.println("------------------------------------------------");
            System.out.println("\nEnter the Bookname:");
            String uname=sc.next();//uname stores the name of the book
            //System.out.print(uname);
            for(int i=0;i<arr.length;i++){
                //System.out.println(arr[i]);
                if(uname.equals(arr[i])){//making sure if the book already exists or not
                    flag=1;
                    break;
                }
                else{//if book is not in library 
                    flag=0;
                }
            }
            if(flag==1){//if already exists
                System.out.println("\nThe Book Already EXISTS");
                System.out.print("\nSo please UPDATE THE STOCK\n");
            }
            else{//if not exists 
                int i;
                String x;
                i=arr.length;
                File fi=new File("bookname.txt");
                write(uname +"\n",fi);//writes the new book name into the file bookname.txt
                String [] data1=addbook1("count.txt");//if the user is new then he need to create a password
                //System.out.println("The data has been appended succesfully");
                arr[i]=s1.nextLine();

            }
            return arr;
        }
        catch(Exception e){
            return null;
        }
    }
    public static Scanner scna=new Scanner(System.in);//scna is the scanner object
    //String id=s.next();
    /*public static void writes(String id,File fi)throws IOException{
        FileWriter fw=new FileWriter(fi,true);
        fw.write(id);
        fw.close();
    }*/
    public static String[] addbook1(String file){//converting the data of file into array and storing the appended data into files
        try{
            File f =new File(file);
            Scanner s=new Scanner(f);//s is the scanner object
            int c=0;
            int flag=0;
            while(s.hasNextLine()){//reading the lines of text files
                c++;
                s.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s1=new Scanner(f);//s1 is the scanner object
            /*for(int i=0;i<arr.length;i++){
                arr[i]=s1.nextLine();
            }*/
            System.out.println("\nEnter the Count:");
            String pass=scna.next();//pass stores the count of new book
            //System.out.println(uname);
            File fi=new File("count.txt");
            write(pass +"\n",fi);//writes the count to the file count.txt
            System.out.println("----------------------------------------");
            System.out.println("\nThe Book has been UPDATED");
            for(int i=0;i<arr.length;i++){//storing into the data arr
                arr[i]=s1.nextLine();
            }
            Scanner sac=new Scanner(System.in);//sac is the scanner object 
            /*System.out.println("\nDo you want to ADD Another Book\nEnter y if want to and anything not to");
            String ch=sac.next();//storing the input given by the user 
            System.out.println("\033[H\033[2J");
            System.out.flush();
            if(ch.equals("y")){//if want to add any other book
                String [] data2=addbook("bookname.txt");
            }
            else{//if not the goes for stock updation 
            }*/
            return arr;
        }
        catch(Exception e){
            return null;
        }
    }
    public static void main(String[] args){
        String [] data=addbook("bookname.txt");
    }
}
