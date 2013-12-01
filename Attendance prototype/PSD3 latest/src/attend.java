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

public class attend { 
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
            String choice;
            Scanner scanWeek = new Scanner(System.in);
            Scanner scanner = new Scanner(new File("getNames.csv"));
	    Scanner in = new Scanner(System.in);
  
                String getWeek;
                System.out.println("Mark Attendance for week : ");
                getWeek = scanWeek.next();

                System.out.println("Proceed to mark attendant? Key 1 to continue, Key 2 cancel.");
                    choice = in.nextLine();
                    int choose = Integer.parseInt(choice);
                        switch (choose){
                        case 1:
                        generateCsvFile("Attendance for Week "+ getWeek+".csv");
                                scanner.close();
                                break;
                        default:
                                 scanner.close();
                                 break;

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
      
}
