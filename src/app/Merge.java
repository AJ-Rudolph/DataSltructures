package app;


public class Merge {
    public static void main(String [] args) {
        
         Node b1 = new Node(8,null);
         Node a1 = new Node(7, b1);
         Node head1 = new Node(1,a1); 

         Node b2 = new Node(11,null);
         Node a2 = new Node(6,b2);
         Node head2 = new Node(1,a2); 

         merge(head1,head2);
        
    }

    private static Node merge (Node head1, Node head2) {
        Node ptr1 = head1;
        Node ptr2 = head2;

        Node itr = null;
        Node mergedList = null;
        // make a for loop to the length of the lists combined
        //create two poitnters and set them eqaul to each head
        //compare head to the other head
        if (ptr1.val<ptr2.val)
        {
            itr=ptr1;
            mergedList=itr;
            ptr1=ptr1.next;
            itr=itr.next;
        }
        else if (ptr1.val>ptr2.val){
            itr=ptr2;
            mergedList=itr;
            ptr2=ptr2.next;
            itr=itr.next;

        }
        else if(ptr1.val==ptr2.val) {
            itr=ptr1;
            itr.next=ptr2;
            mergedList=ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
            itr=itr.next.next;
            
        }
        for (int i =1; i < 6; i++) {
            if (ptr1.val < ptr2.val) {
                itr=ptr1;
                ptr1=ptr1.next;
                itr=itr.next;
                
            }
            else if (ptr1.val>ptr2.val){
                itr=ptr2;
                ptr2=ptr2.next;
                itr=itr.next;
            }
            else if (ptr1.val == ptr2.val) {
                itr=ptr1;
                itr.next=ptr2;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
                itr=itr.next.next;

            }
        }
            itr=mergedList;
        for(int i =0; i < 6; i ++) {
          
            System.out.println (itr.val);
            itr=itr.next;
        }
        return mergedList;
    }
}  
    
class Node {
    public int val;
    public Node next;

    public Node (int val, Node next) {
        this.val = val;
        this.next = next;
    }

}



