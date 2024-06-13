import java.io.*;
import java.util.*;
import java.lang.*;
/** 
 * After when we succesfully login as user we get options as search a book and its availablity,reserve book,feedback and also as login as admin.
 * So when we login as admin then the admin has only access to do the operations as issue book,update the details of book return,to add a new book and 
 * to update a stock.
 * So the admin can login as by the admin name and the id of the admin.
 * The database contains the details of the admin if the user want to login as admin then the details should be entered correctly and then the user
  has succesfully logined as admin.
 * If in correct then the user cannot access the features of admin and a immediate log out.
 */
public class AdminLogin {
    public static Scanner sc=new Scanner(System.in);//sc is the scanner object
    public static Scanner sca=new Scanner(System.in);//sca is the scanner object
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

    public static String[] adminname(String file){// converting the data of the file into array and storing the appended data into files
        try{
            File f =new File(file);
            Scanner scann=new Scanner(f);//scann is the scanner object
            int c=0;
            int flag=0;
            while(scann.hasNextLine()){//this is used for reading the lines of textfiles
                c++;
                scann.nextLine();
            }
            String[] arr=new String[c];//here we create an array arr
            Scanner s2=new Scanner(f);
            for(int i=0;i<arr.length;i++){//we store data into the array arr
                arr[i]=s2.nextLine();
            }
            System.out.println("\nYou are here to LOGIN AS ADMIN");
            System.out.println("------------------------------------------");
            System.out.println("\nEnter the Admin Name:");
            String uname=sc.next();//uname stores the name of the admin
            int x,flag2=0;
            //System.out.print(uname);
            for(int i=0;i<arr.length;i++){
                //System.out.println(arr[i]);
                if(uname.equals(arr[i])){//making sure if the admin name is in the data base
                    flag2=1;
                    System.out.println("\nThe capatcha number is "+ i);//if there then reads the captcha
                    break;
                }
                else{
                    flag2=0;
                }
            }
            /*if(flag2==1){
                //System.out.println("The capatcha number is "+ i);//if there then reads the captcha
                String [] data1=admin("admin.txt");
                    //System.out.println(i);
            }
            else{
                System.out.println("The admin does not exist");
            }*/
            if (flag2== 1) {// if the username is valid then it gets into the loop
                for (int i = 0; i < arr.length; i++) {
                    // System.out.println(arr[i]);
                    if (uname.equals(arr[i])) {
                        //System.out.println("The capatcha number is " + i);// here it asks to enter the captcha to login
                                                                          // successfully
                        String[] data1 = admin("admin.txt");
                        // System.out.println(i);
                    }
                }
            }
            else {
                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println("\nThe Admin Do Not EXIST ");
                System.out.println("\nPlease LOGIN again");
                //String[] data12=adminname("names.txt");
                LMS2 obj12=new LMS2();
                obj12.lms2();        

            }


            //System.out.println("User does not exist");
            /*for(int i=0;i<arr.length;i++){
                arr[i]=s1.nextLine();
            }*/
            return arr;
        }
        catch(Exception ex){
            return null;
        }
    }
    public static String[] admin(String file){// coverting the data of file into array and appending data into the files
        try{
            File f1 =new File(file);
            Scanner s1=new Scanner(f1);//s is the scanner object
            int c1=0;
            int flag1=0,ind;
            boolean s;
            String ind1;
            while(s1.hasNextLine()){//reading the lines of text files
                c1++;
                s1.nextLine();
            }
            String[] arr1=new String[c1];//here we create an array arr
            Scanner s2=new Scanner(f1);//s1 is the scanner object
            /*for(int i=0;i<arr.length;i++){
                arr[i]=s1.nextLine();
            }*/
            File fi=new File("admin.txt");
            System.out.println("\nEnter the captcha number:");//if the admin name found reads the captcha
            String index = sca.next();// takes the input of captcha
            s=isNumeric(index);
            if(!s){
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("\nMake sure the CAPTCHA you entered is a NUMBER");
                System.out.println("\nPlease LOGIN again");
                //String[] data5=adminname("names.txt");
                LMS2 obj12=new LMS2();
                obj12.lms2();        
            }
            else{
                ind=Integer.parseInt(index);
                ind1=Integer.toString(ind);
                    //System.out.println(index);
                    //System.out.println(ind);
                    //System.out.println(ind1);


                System.out.println("\nEnter the Admin-id:");
                String pass=sca.next();//pass takes the input of admin id
                for(int i=0;i<arr1.length;i++){//making sure of finding the admin id at specific index
                    arr1[i]=s2.nextLine();
                }
                //System.out.println(arr[index]);
                //File fi=new File("C:\\Users\\USER\\Desktop\\tanmayee\\password.txt");
                if(index.equals(ind1)){
                    if(ind<arr1.length){
                        if(arr1[ind].equals(pass)){//if matches then login
                            System.out.println("\033[H\033[2J");
                            System.out.flush();    
                            System.out.println("\nYou have SUCCESSFULLY LOGGED into the library management software as admin ");
                        }
                        else{//if the deatils doesnot match
                            System.out.println("\033[H\033[2J");
                            System.out.flush();    
                            System.out.println("\nDetails Do Not MATCH\n");
                            System.out.println("Please LOGIN again");
                            LMS2 obj12=new LMS2();
                            obj12.lms2();                    
                            //String[] data5=adminname("names.txt");
                        }
                    }
                    else{
                        System.out.println("\033[H\033[2J");
		                System.out.flush();
                        System.out.println("\nDetails Do Not MATCH\n");
		                System.out.println("Please LOGIN Again");
                        LMS2 obj12=new LMS2();
                        obj12.lms2();                
                        //String[] data5 = adminname("names.txt");

                    }
                }
                else{
                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("\nDetails Do Not Match\n");               
                    System.out.println("Please LOGIN again");
                    LMS2 obj12=new LMS2();
                    obj12.lms2();            
                    //String[] data5 = adminname("names.txt");
                }
            }
            return arr1;
        }
        catch(Exception e){
            return null;
        }
    }
    public static void main(String[]args){
        String[] data = adminname("names.txt");
    }
}
