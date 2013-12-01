import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.*;
import java.util.*;

public class markEditAttend { 
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
            String choice; 
            String getWeek;
            Scanner scanWeek = new Scanner(System.in);
            Scanner scanner = new Scanner(new File("getNames.csv"));
	    Scanner in = new Scanner(System.in);
 
            login();
            
                   System.out.println("Please choose an input: Key 1 to Mark Attendance, Key 2 to Edit Attendance, Key 3 to Cancel.");
                    choice = in.nextLine();
                    int choose = Integer.parseInt(choice);
                        switch (choose){
                        case 1:
                                System.out.println("Mark Attendance for week : ");
                                getWeek = scanWeek.next();
                                generateCsvFile("Attendance for Week "+ getWeek+".csv");
                                scanner.close();
                                break;
                        case 2:
                                System.out.println("Edit Attendance for week : ");
                                getWeek = scanWeek.next();
                                editCsvFile("Attendance for Week "+ getWeek+".csv");
                                scanner.close();
                                break;
                        default:
                                 scanner.close();
                                 break;

    }
}

private static void login() throws NullPointerException {
    String user = "tutor";
    String password = "tutor123";
    String getUser;
    String getPassword;
    Scanner scanUser = new Scanner(System.in);
    Scanner scanPassword = new Scanner(System.in);
 
    System.out.println("Please enter UserID : ");
    getUser = scanUser.next(); 
    System.out.println("Please enter Password : ");
    getPassword = scanPassword.next();

    if (!getUser.equals(user) || !getPassword.equals(password)) {
    System.out.println("Incorret UserID or password");
    login();
        }
   
    }
    
private static void generateCsvFile(String sFileName) throws IOException {
    
            Scanner scanner = new Scanner(new File("getNames.csv"));
	    Scanner in = new Scanner(System.in);
            String store = "";
            scanner.useDelimiter(",");
           
            while(scanner.hasNext()){  
                   // System.out.print(scanner.next());
                    store = store + scanner.nextLine() + "\n";
                }  
               // System.out.println(store);    
                  String[] data = store.split("\n");
                //System.out.println(data.length);
               // System.out.println(data[0]);
                              
                Scanner scanAttendance = new Scanner(System.in);
                String getAttendance = "";
                for (int a = 0; a < data.length; a++) {
                System.out.println("Mark Attendance for " +data[a] + " : ");
                getAttendance = getAttendance + scanAttendance.next() + "\n";
                }
                String[] attendance = getAttendance.split("\n");
       
                //System.out.println(getAttendance);
               
              // Set up the FileWriter with our file name.
              FileWriter saveFile = new FileWriter(sFileName);

              // Write the data to the file.
              saveFile.write("Name"); //First column
              saveFile.write(","); //Push the next input to the next column
              saveFile.write("Attendance" + "\n"); //Second column
              
              for (int i = 0; i < data.length; i++) {
                    saveFile.write(data[i] + ","); //First column ; push
                    saveFile.write(attendance[i] + '\n'); //second column
                }
            
             // All done, close the FileWriter.
             saveFile.close();
    }

private static void editCsvFile(String sFileName) throws IOException {
    try{
        
      //   System.out.println(sFileName);
    
        Scanner scanner = new Scanner(new File(sFileName));
        Scanner in = new Scanner(System.in);
        Scanner scanName = new Scanner(System.in);
        Scanner scanAttendance = new Scanner(System.in);
        String store = "";
        String getName;
        String getAttendance;
        String choice;
        
        scanner.useDelimiter(",");
      
        while(scanner.hasNext()){
          // System.out.print(scanner.next() + " ");
             store = store + scanner.nextLine() + ",";
        }
          String[] data = store.split(",");
    
          System.out.println("Enter the name to edit: ");
          getName = scanName.next();
      
          for (int a = 0; a < data.length; a++) {
            if (getName.toLowerCase().equals(data[a].toString().toLowerCase())) {
                //System.out.println(data[a]);
               // System.out.println(data[a+1]);
                System.out.println("Edit Attendance: ");
                getAttendance = scanAttendance.next();
                 //System.out.println(getAttendance);
                data[a+1] = getAttendance;
                   //System.out.println("data+1 " +data[a+1].toString());
            } else {
            System.out.println("Name not found!");
            break;
            }
            
        }
         // System.out.println(data.length);
       FileWriter saveFile = new FileWriter(sFileName);
           
       for (int b = 0; b < data.length; b++) {
          if (b % 2 == 0) {
             saveFile.write(data[b] + ","); //First column ; push
          } else {
             saveFile.write(data[b] + "\n");
          }
            }
       
       saveFile.close();
   
        System.out.println("Please choose an input: Key 1 to continue, Key 2 to cancel.");
        choice = in.nextLine();
        int choose = Integer.parseInt(choice);
        switch (choose){
             case 1:
                editCsvFile(sFileName);
                scanner.close();
                break;
            default:
                scanner.close();
                break;
            }
                 
    }  catch(IOException e){
        System.out.println("Could not find file " + sFileName);
    }           
  }
  
      
}
