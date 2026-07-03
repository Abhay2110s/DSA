import java.util.Scanner;

class binarytree {
    
    // Nested private Node class
    private class Node {
        private int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Public method to start populating the tree
    public void populate(Scanner scanner) {
        System.out.println("Enter the root node value:");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    // Private helper method to recursively populate the tree
    private void populate(Scanner scanner, Node node) {
        // --- LEFT CHILD LOGIC ---
        System.out.println("Do you want to enter a left child for " + node.value + "? (true/false)");
        boolean insertLeft = scanner.nextBoolean();
        if (insertLeft) {
            System.out.println("Enter the value for the left child of " + node.value + ":");
            int value = scanner.nextInt(); // Fixed typo: next.Int() -> nextInt()
            node.left = new Node(value);   // Use instance variable 'node', not the class name 'Node'
            populate(scanner, node.left);  // Recurse down the left side
        }

        // --- RIGHT CHILD LOGIC ---
        System.out.println("Do you want to enter a right child for " + node.value + "? (true/false)");
        boolean insertRight = scanner.nextBoolean();
        if (insertRight) {
            System.out.println("Enter the value for the right child of " + node.value + ":");
            int value = scanner.nextInt();
            node.right = new Node(value);  // Use instance variable 'node'
            populate(scanner, node.right); // Recurse down the right side
        }
    }

    // Helper method to display the tree structure visually
    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) System.out.print("|\t");
            System.out.println("|-------" + node.value);
        } else {
            System.out.println(node.value);
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        binarytree tree = new binarytree();
        
        tree.populate(scanner);
        
        System.out.println("\n--- Your Binary Tree Structure ---");
        tree.display();
        
        scanner.close();
    }
}