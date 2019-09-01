package app;

public class App {
    public static void main(String[] args)  {
        LinkedList <String> list= new LinkedList<String>();
        LinkedList <String> list2 = new LinkedList<String>();

        list.add("apple");
        list.add("banana");
        list.add("carrot");


        list2.add("one");
        list2.add("two");
        list2.add("three");

        list.addAll(list2);

        System.out.print(list);
        

    }
}

class LinkedList <T> {
    class Node <T> {

        public T val;
        public Node<T> next;
        
        public Node(T val)
        {
            this.val=val;
            this.next = null;
    
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int length;


    public LinkedList() {
        this.head = null;
        this.tail= null;
        this.length = 0;

    }

    public void add (T n) {
        Node <T> node = new Node<T> (n);

        if (head == null) {
            head = node;
            tail=node;
        }
        else {
            tail.next=node;
            tail=tail.next;
        }
        
        this.length+=1;
        

    }
    public void add(T newVal, int index)  {
        Node<T> node= new Node <T>(newVal);
         
        
        //trying to add a node to the beginning of the list
        if(index == 0) {
            node.next = head;
            head=node;
        }

        // if adding to the end of the list
        else if (index >= length) {
            add(newVal);
            return;
        }

         //add a negative index
        else if (index< 0) {
            return;
        } 
         //adding a node in the middle 
        else { 
            Node <T> ptr = this.head;
            for (int i= 0 ; i < index -1 ; i++) {
                ptr = ptr.next;    
            }

            Node <T>temp = ptr.next;
            ptr.next =node;
            node.next=temp;

        
        }
       this.length+=1;

    }

    public void remove(int index) {

        //if the index is below zero
        if (index<0) {
            return;
        }

        //if the index is zero
        else if (index == 0){
            head=head.next;
        }
        //if the index is in the middle
        else if (index<length-1) {
            Node <T>ptr = head;
            for (int i=0;i<index-1;i++ ) {
                ptr=ptr.next;
            }
            ptr.next=ptr.next.next;
        }
        //if the index is equal to the length and the next node is null 
        else if(index == length ) {
            Node <T> ptr=head;
            for (int i =0; i< index -1; i++) {
                ptr=ptr.next;
            }
            ptr.next=null;
        }
        //if index is greater than length
        else  {
            return;
        }
        this.length-=1;
    }




   public String toString() {
        String ListVals = "";
        Node <T> ptr = head;
       for (int i =0; i < length; i++) {
            ListVals+= ptr.val + "->";
            ptr=ptr.next;

       }
       return ListVals;
   } 

   public T get(int index) {

        
        if(index<0 || index >length) {
            return null;
        }
        
        else {
            Node <T> ptr= head;
            for (int i =0; i<index;i++) {
                ptr=ptr.next;
            }

            return ptr.val;
        }
        

   }

   public void clear() {
        this.head=null;
        this.tail=null;
        this.length = 0;
   }

   public int size() {
       return this.length;
   }

   public  void copy (LinkedList <T> list ) {
        this.clear();
        for (int i =0; i<list.size();i++) {
            this.add(list.get(i));
        }

   }

   public void addAll(LinkedList <T> list) {
       for (int i =0; i <list.size();i++) {
           this.add(list.get(i));
       }

   }
   
    
   

    
    



}
