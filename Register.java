import java.io.*;
import java.util.*;
import java.lang.*;
/** 
 * After when we compile if the user in new then the then it asks to create a new account.
 * So a new user can create a account over here by just entering a username and a password.
 * If the username already exists then asks to create a username with a different one.
 * So once you have signed you have signed up need to login again inorder to access the features of our Library Management Software.
 */
public class Register{
    public static Scanner sc=new Scanner(System.in);// sc is the scanner object 
    //String id=s.next();
    public static void write(String id,File fi)throws IOException{//creating a method to write the data to file
        FileWriter fw=new FileWriter(fi,true);//opening the file in append mode 
        fw.write(id);
        fw.close();
    }
    public static String[] readFiles(String file){// converting the data of the file into array and storing the appended data into files
        try{
            File f =new File(file);
            Scanner s=new Scanner(f);//s is the scanner object
            int c=0;
            int flag=0;
            while(s.hasNextLine()){//this is used for reading the lines of text files
                c++;
                s.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s1=new Scanner(f);//s1 is the scanner object
            for(int i=0;i<arr.length;i++){//storing the data into array arr
                arr[i]=s1.nextLine();
            }
            System.out.println("You are here to REGISTER as NEW USER");
            System.out.println("------------------------------------------------------");
            System.out.println("\nEnter the Username:");
            String uname=sc.next();//uname stores the username of the user wants to create
            //System.out.print(uname);
            for(int i=0;i<arr.length;i++){
                //System.out.println(arr[i]);
                if(uname.equals(arr[i])){//making sure the username is not repeated
                    flag=1;
                    break;
                }
                else{//if not repeated 
                    flag=0;
                }
            }
            if(flag==1){//if repeats then user already exists
                System.out.println("\nThe USER already EXISTS");
            }
            else{//if username doesnot exist
                int i;
                String x;
                i=arr.length;
                File fi=new File("username.txt");
                write(uname +"\n",fi);//writing the new user name into file username.txt
                String [] data1=readFile("password.txt");//if the user is new then he need to create a password
                //System.out.println("The data has been appended succesfully");
                arr[i]=s1.nextLine();

            }
            return arr;
        }
        catch(Exception e){
            return null;
        }
    }
    public static Scanner sca=new Scanner(System.in);//sca is the scanner object
    //String id=s.next();
    public static void writes(String id,File fi)throws IOException{//creating a method to write data to file
        FileWriter fw=new FileWriter(fi,true);//opening the file in append mode 
        fw.write(id);
        fw.close();
    }
    public static String[] readFile(String file){//converting the data of file into the array and storing the appended data into files
        try{
            File f =new File(file);
            Scanner s=new Scanner(f);//s is the scanner object
            int c=0;
            int flag=0;
            while(s.hasNextLine()){//this is used for reading the lines of text file
                c++;
                s.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s1=new Scanner(f);//s1 is the scanner object
            /*for(int i=0;i<arr.length;i++){
                arr[i]=s1.nextLine();
            }*/
            System.out.println("\nEnter the Password:");
            String pass=sca.next();//pass stores the password of the specific username 
            //System.out.println(uname);
            File fi=new File("password.txt");
            write(pass +"\n",fi);//writes the data into the file password.txt
            System.out.println("\nThe ACCOUNT has been CREATED");
            System.out.println("-----------------------------------------------------------");
            //sp a new user has been added 
            //System.out.println("Please login in order to access the features");
            for(int i=0;i<arr.length;i++){//stroing the data into array arr
                arr[i]=s1.nextLine();
            }
            return arr;
        }
        catch(Exception e){
            return null;
        }
    }
    public static void main(String [] args){
        String[] data=readFiles("username.txt");
    }
}