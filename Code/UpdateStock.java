import java.io.*;
import java.util.*;
import java.lang.*;
/**
 * Only Admin has the access to this feature.
 * If there is a existing book so to update the book count we use this.
 * Number of books will be updated,so the specific book can be issued to more users.
 * If the book is not available previously then asks for the add book.
 */
public class UpdateStock{
    public static void writer(String filename,String[] x )throws IOException{//creating a method to write the data to file in the write method 
        BufferedWriter outpuWriter=null;                                     // so that the count of the book gets updated correctly 
        outpuWriter=new BufferedWriter(new FileWriter( filename));
        for(int i=0;i<x.length;i++){//changing the whole data in the file to the new data 
            outpuWriter.write(x[i]+"");
            //outpuWriter.write(x[i]);
            outpuWriter.newLine();
        }
        outpuWriter.flush();
        outpuWriter.close();
    }
    public static Scanner sc=new Scanner(System.in);//sc is the scanner object
    //String id=s.next();
    public static void write(String id,File fi)throws IOException{//creating a method to write the data to file
        FileWriter fw=new FileWriter(fi,true);//opening the file in append mode 
        fw.write(id);
        fw.close();
    }
    public static String[] updatestock(String file){// converting the data of the file into array and storing the appended data into files
        Scanner sc=new Scanner(System.in);//sc is the new scanner
        try{
            File f =new File("bookname.txt");
            Scanner scann=new Scanner(f);//scann is the scanner object
            int c=0;
            int flag=0;
            while(scann.hasNextLine()){//reading the lines of text files 
                c++;
                scann.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s2=new Scanner(f);//s2 is the scanner object
            for(int i=0;i<arr.length;i++){//storing data into the array arr 
                arr[i]=s2.nextLine();
            }
            File f1 =new File("count.txt");
            Scanner s=new Scanner(f);//s is the scanner object
            int c1=0;
            int flag1=0;
            while(s.hasNextLine()){//here reading the lines of text files
                c1++;
                s.nextLine();
            }
            String[] arr1=new String[c1];//we create an array arr1
            Scanner s1=new Scanner(f1);//s1 is the scanner object
            for(int i=0;i<arr1.length;i++){//storing data into the array arr1
                arr1[i]=s1.nextLine();
            }
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("You are here to UPDATE STOCK of book");
            System.out.println("----------------------------------------------------");
            System.out.println("\nEnter the Bookname:");
            String bname=sc.next();//bname stores the book name
            int index;//for the position of book in the array 
            for(int i=0;i<arr1.length;i++){
                //System.out.println(arr[i]);
                if(bname.equals(arr[i])){//making sure if the book is in library or not
                    flag=1;
                    System.out.println("\nThe Book IS IN LIBRARY");
                    index=i;
                    System.out.println("\nThe Number of Books Available is "+arr1[i]);
                    int x=Integer.parseInt(arr1[i]);//gets the secific index of book
                    System.out.println("\nEnter y to UPDATE the count of Book");
                    Scanner ser=new Scanner(System.in);//ser is the scanner object
                    String ch=ser.next();//confirmation  
                    if(ch.equals("y")){
                        System.out.println("\nEnter the Number of Books to be ADDED: ");
                        int ro=ser.nextInt();//number of books to be added
                        int y=x+ro;//adding the number of books to the previous 
                        String z=Integer.toString(y);
                        arr1[i]=z;
                        writer("count.txt",arr1);//writing the updated count to the file
                        System.out.println("The STOCK has been UPDATED");
                        break;
                
                    }
                }
                else{//if not in library 
                    flag=0;
                }
            }
            if(flag==1){//then skips 
            }
            else{//the book is in the library 
                System.out.println("\nThe Book is NOT in LIBRARY");
            }
            Scanner s6 =new Scanner(System.in);//s6 is the scanner object
            System.out.println("---------------------------------------------------------------");
            /*System.out.println("\nDo you want to UPDATE STOCK of Another Book\nEnter y if want to and anything not to");
            String ch=s6.next();//ch stores the data we give whether we need to do this again or not 
            if(ch.equals("y")){
                String [] data2=updatestock("bookname.txt");
            }
            else{
            }*/
            return arr1;
            
        } 
        catch(Exception e) {
            return null;
        }
    }
    public static void main(String[] args){
        String[] data0=updatestock("bookname.txt");
    }
}