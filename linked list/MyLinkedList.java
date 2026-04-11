//! Design Linked List..

//? Leetcode problem 707....

public class MyLinkedList {
    class Node {
        private int val;
        private Node next;

        Node() {
            val = 0;
        }

        Node(int val) {
            this.val = val;
            next = null;
        }

        Node(int val , Node next)
        {
            this.val = val;
            this.next = next;
        }
    }

    Node head;
    int size;

    public MyLinkedList() {
        head = new Node();  // Fixed: initialize instance variable, not local variable
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;  
        }
        Node curr = head;
        for (int i = 0; i <= index; i++) {  
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        Node newnode = new Node(val);
        newnode.next = curr.next;
        curr.next = newnode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return; 
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }

    public void printList() {
        Node curr = head.next;  // Start from first actual node
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Test addAtTail
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        System.out.print("After adding 1,2,3 at tail: ");
        list.printList();  // Expected: 1 -> 2 -> 3 -> null

        // Test addAtHead
        list.addAtHead(0);
        System.out.print("After adding 0 at head: ");
        list.printList();  // Expected: 0 -> 1 -> 2 -> 3 -> null

        // Test get
        System.out.println("Get index 2: " + list.get(2));  // Expected: 2
        System.out.println("Get index 0: " + list.get(0));  // Expected: 0
        System.out.println("Get index -1: " + list.get(-1)); // Expected: -1 (invalid)
        System.out.println("Get index 10: " + list.get(10)); // Expected: -1 (invalid)

        // Test addAtIndex
        list.addAtIndex(2, 5);
        System.out.print("After adding 5 at index 2: ");
        list.printList();  // Expected: 0 -> 1 -> 5 -> 2 -> 3 -> null

        // Test deleteAtIndex
        list.deleteAtIndex(2);
        System.out.print("After deleting at index 2: ");
        list.printList();  // Expected: 0 -> 1 -> 2 -> 3 -> null

        // Test delete at head
        list.deleteAtIndex(0);
        System.out.print("After deleting at index 0: ");
        list.printList();  // Expected: 1 -> 2 -> 3 -> null

        // Test delete at tail
        list.deleteAtIndex(list.size - 1);
        System.out.print("After deleting at last index: ");
        list.printList();  // Expected: 1 -> 2 -> null
    }
}
