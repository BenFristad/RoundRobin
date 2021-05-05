//Ben Fristad

import java.util.*;
import java.io.*;

public class RoundRobin
{  
   public static void main(String[] args) throws Exception
   {
      DCLinkedList processes = new DCLinkedList(); // initalize Linked List
      String fileName = args[0]; // initalize command line args
      int removalTime = Integer.parseInt(args[1]);
      
      fillLinkedList(processes, fileName);
      processes.removeTime(removalTime); 
         
   }// end main
   
   public static void fillLinkedList(DCLinkedList processes, String fileName) throws Exception
   {   
      File inputFile = RoundRobin.openInputFile(fileName); // open the file
      Scanner fileInput = new Scanner(inputFile); // make a Scanner to scan the file
      int total = RoundRobin.countRecords(fileInput); // find how many records are in the file
      fileInput.close();
      
      fileInput = new Scanner(inputFile); // reset scanner
            
      for(int i = 0; i < total; i++) // fill the Linked List from the file
      {
          String data = fileInput.nextLine(); // read in the line
         String[] split = data.split(", ", 2); // split the record in to 2 parts (Process ID, Time)
         
         int id = Integer.parseInt(split[0]);
         int time = Integer.parseInt(split[1]);
        
         processes.DCSort(new DNode(id, time, null, null)); // add the records to the Linked List and sort them at the same time

      }// end for loop
      
      fileInput.close();
      
   }// end fillLinkedList
      
   public static File openInputFile(String fileName)
   {
      if(fileName == null || fileName == "")
         throw new IllegalArgumentException("file name is null or empty");
         
      File inputFile = new File(fileName); // try to open the file
      
      if(inputFile.exists() == false)
         throw new RuntimeException("file could not be opened");
         
      return inputFile;
      
   }// end openInputFile
   
   public static int countRecords(Scanner fileInput)
   {
      if(fileInput == null)
         throw new IllegalArgumentException("Scanner fileInput is null");
     
      int counter = 0;
      
      while(fileInput.hasNextLine()) // the loop will run until it reaches EOF
      {
         fileInput.nextLine(); // checks next line
         counter++; // increment counter
      
      }// end while loop
      
      return counter; // returns number of records
      
   }// end countRecords
   
}// end class