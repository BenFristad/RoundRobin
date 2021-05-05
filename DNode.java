//Ben Fristad

public class DNode
{
   private int id;
   private int time;
   
   private DNode prev; // the link referencing the previous node in the linked list
   private DNode next; // the link referencing the next node in the linked list
   
   public DNode(int id, int time, DNode prev, DNode next)
   {
      this.id = id;
      this.time = time;
      this.prev = prev;
      this.next = next;
   
   }// end EVC
   
   public int getId()
   { 
      return this.id; 
   
   }// end getId
   
   public int getTime()
   {
      return this.time;
   
   }// end getTime
   
   public DNode getNext()
   {
      return this.next;
   
   }// end getNext
   
   public DNode getPrev()
   {
      return this.prev;
   
   }// end getPrev
   
   public void setTime(int time)
   {
      this.time = time;
   
   }// end setTime
   
   public void setNext(DNode next)
   {
      this.next = next;
   
   }// end setNext
   
   public void setPrev(DNode prev)
   {
      this.prev = prev;
   
   }// end setPrev
   
}// end DNode
