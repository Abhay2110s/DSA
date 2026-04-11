//! Doubly Linked List...

public class dblinkedlist {
    class Node {
        int val;
        Node next;
        Node prev;

        Node(){};

        Node(int val)
        {
            this.val = val;
            next = null;
            prev = null;
        }
    }

    Node head ;
    Node tail ; 
    dblinkedlist(){
        head = null;
        tail = null;
    };

    void addfirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            // Empty list
            head = newnode;
            tail = newnode;
        } else {
            // Add at the beginning
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }

    //display the linked list
    void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + "<->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    

    public static void main(String[] args) {
        dblinkedlist sl = new dblinkedlist();
        sl.addfirst(10);
        sl.addfirst(20);
        sl.display();

    }

}
