class node{
    int val;
    node next;

    //constructor
    node(int val)
    {
        this.val = val;
        next = null;
    }
}

public class singlylinkedlist {
    private node head;

    singlylinkedlist()
    {
        head = null;
    }

    //Insert At first
    void insertfirst(int value)
    {
        node newnode = new node(value);
        newnode.next = head;
        head = newnode;
        System.out.println("Element inserted at the first .");
    }

    //Insert at the last.
    void insertlast(int value)
    {
        node newnode = new node(value);
        if(head == null)
        {
            head = newnode;
        }
        else
        {
            node temp = head;
            while(temp.next!= null)
            {
                temp = temp.next;
            }
            temp.next = newnode;
        }
        System.out.println("Element inserted at the last.");
    }

    //Inserted at the position.
    void insertposition(int pos , int value)
    {
        node newnode = new node(value);
        if(head == null)
        {
            System.out.println("Empty list");
        }
        else if(pos < 1)
        {
            System.out.println("Invalid position");
        }
        else if(pos == 1)
        {
            insertfirst(value);
        }
        else{
            node temp = head;
            for(int i =1 ; i<pos-1 ; i++)
            {
                if(temp.next == null)
                {
                    System.out.println("Position out of bounds");
                    return;
                }
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
            System.out.println("Element add at the position .");
        }
    }

void deletefirst()
    {
        if (head == null)
        {
            System.out.println("Linked List is empty." );
            return;
        }
        else
        {
            node temp = head;
            head = temp.next;
            System.out.println("First node is deleted. ");
        }
    }

    // Delete from the last
    void deletelast()
    {
        if (head == null)
        {
            System.out.println("Linked List is empty." );
            return;
        }
        else if (head.next == null)
        {
            head = null;
            System.out.println("Only one node in the list - deleted.");
            return;
        }
        else
        {
            node temp = head;
            while (temp.next.next != null)
            {
                temp = temp.next;
            }
            
            temp.next = null;
            System.out.println("Delete from the last. ");
        }
    }

    // Delete from a specific position
    void deletefromposition(int pos)
    {
        if (head == null)
        {
            System.out.println("Linked List is empty.");
            return;
        }

        if (pos < 1)
        {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1)
        {
            deletefirst();
            return;
        }

        node temp = head;
        for (int i = 1; i < pos - 1; i++)
        {
            if (temp.next == null)
            {
                System.out.println("OUT OF BOUND");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        System.out.println("Node deleted");
    }

    // Search element
    void search(int ele)
    {
        node temp = head;
        while (temp != null)
        {
            if (temp.val == ele)
            {
                System.out.println( "Element is present." );
                return;
            }
            temp = temp.next;
        }
        System.out.println("Element is not present." );
    }

    //Update 
    void update(int old , int newval)
    {
        node temp = head;
        while (temp != null)
        {
            if (temp.val == old)
            {
                temp.val = newval;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Element is not present." );
    }

    //count node
    void nodes()
    {
        node temp =head;
        int count = 0;
        while(temp!= null)
        {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Nodes : " + count);
    }

    //Reverse of Linked List
    void reverse()
    {
        node prev = null;
        node curr = head;
        node next = null;
        while(curr!= null)
        {
            next= curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Display linked list
    void display()
    {
        if (head == null)
        {
            System.out.println("List is Empty.");
        }
        else
        {
            node temp = head;
            while (temp != null)
            {
                System.out.print(temp.val+" -> ");
                temp = temp.next;
            }
            System.out.println("NULL");
        }
    }
    
    public static void main(String[] args) {
        singlylinkedlist list = new singlylinkedlist();
        
        // Test insert
        list.insertfirst(10);
        list.insertfirst(20);
        list.insertlast(30);
        list.insertposition(2, 25);
        
        // Display
        System.out.println("Linked List:");
        list.display();
        
        // Count nodes
        list.nodes();
        
        // Search
        list.search(25);
        
        // Update
        list.update(25, 50);
        System.out.println("After update:");
        list.display();
        
        // Reverse
        list.reverse();
        System.out.println("After reverse:");
        list.display();
        
        // Delete operations
        list.deletefirst();
        System.out.println("After deleting first:");
        list.display();
        
        list.deletelast();
        System.out.println("After deleting last:");
        list.display();
    }
}
