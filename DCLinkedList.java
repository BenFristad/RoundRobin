//Ben Fristad

import java.io.*;
import java.util.*;

public class DCLinkedList
{
   protected DNode cursor; // define a pointer for the Linked List
   protected int size;
   
   public DCLinkedList() 
   {
      cursor = null;
      size = 0;
   
   }// end DVC
   
   public void advance() // moves the cursor foward one Node
   {
      if(size > 1)
         cursor = cursor.getNext();
   
   }// end advance
   
   public void decrement() // moves the cursor back one Node
   {
      if(size > 1)
         cursor = cursor.getPrev();
   
   }// end decrement
   
   public void addBefore(DNode v)
   {
      if(v == null)
         throw new IllegalArgumentException("DNode v is null");
      
      if(size <= 1)
      {
         addAfter(v);
         
      }// end if
      
      else
      {
         v.setPrev(cursor.getPrev());
         v.setNext(cursor);
         cursor.getPrev().setNext(v);
         cursor.setPrev(v);
         size++;
         
      }// end else
         
   }// end addBefore
   
   public void addAfter(DNode v)
   {
      if(v == null)
         throw new IllegalArgumentException("DNode v is null");
         
      if(size == 0)
      {
         cursor = v;
         cursor.setNext(v);
         cursor.setPrev(v);
         size++;
      }// end if
      
      else
      { 
         v.setPrev(cursor);
         v.setNext(cursor.getNext());
         cursor.getNext().setPrev(v);
         cursor.setNext(v);
         size++;
         
      }// end else   
   
   }// end addAfter
   
   public void remove(DNode v)
   {
      if(v == null)
         throw new IllegalArgumentException("v is null");
      
      if(size == 1)
      {
         cursor = null;
         size--;
         
      }// end if
      
      else
      {
         cursor = v.getNext();   
         v.getPrev().setNext(v.getNext());
         v.getNext().setPrev(v.getPrev());
         v.setPrev(null);
         v.setNext(null);
         size--;
         
      }// end else  
      
   }// end remove
   
   public void DCSort(DNode v)
   { 
      if(size <= 1) // if the size is less than 1 then the order of the Nodes does not matter
      {
         addAfter(v);
            
      }// end if

      else
      {
         boolean valuePlaced = false; // create a boolen conditon that will is false until the Node is sorted
         
         while(valuePlaced != true)
         {
     
            if(v.getId() < cursor.getId()) // check which direction the Linked List needs to iterate
            {
               DNode cur = cursor.getPrev(); // set up a new pointer to check the value ahead of the cursor
               
               if(v.getId() > cur.getId()) // do a check to see if the value can be added before iterating
               {
                  decrement();
                  addAfter(v); 
                  valuePlaced = true; // insert the value and exit the loop 
               
               }// end if
               
               else
               {
                  while(valuePlaced != true) // iterate through the Linked List to add the value in the sorted position
                  {
                     if(cursor.getId() > v.getId() && cur.getId() < v.getId()) // add the value between cursor and cur
                     {
                        addBefore(v);
                        valuePlaced = true; // insert the value and exit the loop
                        
                     }// end if
                     
                     if(cursor.getId() > v.getId() && cur.getId() > cursor.getId()) // add the value at the end of the list
                     {
                        addBefore(v);
                        valuePlaced = true; // insert the value and exit the loop
                     
                     }// end if
                     
                     cur = cur.getPrev(); // the value was not added to the Linked List, so iterate
                     decrement(); 
                     
                  }// end nested while loop
                                
               }// end else
               
            } // end if
            
            else
            {
               DNode cur = cursor.getNext();
                  
               if(v.getId() < cur.getId()) // do a check to see if the value can be added before iterating
               {
                  advance();
                  addBefore(v);
                  valuePlaced = true; // insert the value and exit the loop
                  
               }// end if
               
               else
               {
                  while(valuePlaced != true) // iterate through the Linked List to add the value in the sorted position
                  {
                     if(cursor.getId() < v.getId() && cur.getId() > v.getId()) // add the value between cursor and cur
                     {
                        addAfter(v);
                        valuePlaced = true; // insert the value and exit the loop
                        
                     }// end if
                     
                     if(cursor.getId() < v.getId() && cur.getId() < cursor.getId()) // add the value at the end of the list
                     {
                        addAfter(v);
                        valuePlaced = true; // insert the value and exit the loop
                     
                     }// end if
                     
                     cur = cur.getNext(); // the value was not added to the Linked List, so iterate
                     advance(); 
                     
                  }// end nested while loop
                                    
               }// end else  
   
            }// end else
       
         }// end while loop
      
      }// end else
      
   }// end DCSort
   
   public void removeTime(int removalTime)
   {
      DNode cur = cursor.getNext();
      
      while(cur.getId() > cursor.getId()) // iterate to the beginning of the list
      {
         cur = cur.getNext();
         advance();
      
      }// end while loop
      
      while(size != 0) // this loop iterates through each Node and removes a certain amount of seconds off the process time depending on the value of the removalTime vairable
      {
         
         if(cur.getTime() <= removalTime) // this conditon checks if the process will be complete during this iteration
         {
            if(size == 1)
            {
               cur.setTime(0);
               System.out.print(cur.getId());
               cur = cur.getNext();
               remove(cur.getPrev());
               
            }// end if
            
            else
            {
               cur.setTime(0); // set time to zero because so the value wont be negative
               System.out.print(cur.getId() + ", "); // print the ID of the Node being deleted
               cur = cur.getNext(); // make cur step foward one Node
               remove(cur.getPrev()); // remove the process that is complete
               
            }// end else
            
         }// end if
         
         else // this case means that the process will not be complete during this iteration
         {
            cur.setTime(cur.getTime() - removalTime); // subract the time off the process
            cur = cur.getNext(); // make cur step foward one Node
            
         }// end else       
         
      }// end while loop
      
   }// end removeTime
   
}// end DCLinkedList