class LinkedList {

    // Instance Variables
    static ListNode head;

    // Linked List Node
    class ListNode {
        int data;
        ListNode next, prev;

        ListNode(int d) {
            data = d;
            next = prev = null;
        }
    }

    // Binary Tree Node
    class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int d) {
            data = d;
            left = right = null;
        }
    }

    // Linked List to Binary Tree Method
    // Continously divides linked list into two. Uses uses middle element as root
    // then as left and right elements

    TreeNode listToBT() {
        int n = countreeNodes(head);

        return listToBTRecur(n);
    }

    TreeNode listToBTRecur(int n) {

        if (n <= 0)
            return null;

        // Construct Left Subtree
        TreeNode left = listToBTRecur(n / 2);

        // Set Middle of List to Root Node of the Tree
        TreeNode root = new TreeNode(head.data);

        // Set pointer to left subtree
        root.left = left;

        head = head.next;

        // Allocates Data to Right Subtree
        root.right = listToBTRecur(n - n / 2 - 1);

        return root;
    }

    // Count Method for Number of Elements in Linked List
    int countreeNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // Add Data to Beginning of Linked List
    void push(int new_data) {
        /* allocate node */
        ListNode new_node = new ListNode(new_data);

        new_node.prev = null;

        new_node.next = head;

        if (head != null)
            head.prev = new_node;

        head = new_node;
    }

    // Print List Method
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Preorder Display Method
    void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Main Method
    public static void main(String[] args) {

        // Linked List Creation
        LinkedList llist = new LinkedList();

        // Add elements to Linked List
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        // Display Linked List
        System.out.println("\nGiven Linked List ");
        llist.printList(head);

        TreeNode root = llist.listToBT();

        // Call List to Binary Tree Method and Display Result
        System.out.println("\n");

        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
        System.out.println("\n");
    }
}
