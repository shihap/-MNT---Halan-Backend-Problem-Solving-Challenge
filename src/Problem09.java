import java.util.ArrayList;
import java.util.List;

class Node { // class structure for Node
    int value; // value of the node
    List<Node> children; // list of child nodes

    public Node(int value) { // constructor
        this.value = value;
        this.children = new ArrayList<>();
    }
}

public class Problem09 {

    // function to get the sum of values in the tree starting from the given node
    public static int sum(Node node) {

        //halt condition , if we pass empty node
        if (node == null) {
            return 0;
        }


        int totalSum = node.value; // add the value of current node

        // add the values of children to the sum by call each one of them with the same function recursively
        for (int i = 0 ; i < node.children.size() ; i++) {
            totalSum += sum(node.children.get(i)); // add the sum of the child subtree
        }

        return totalSum; // return the total sum of the tree
    }

    public static void main(String[] args) {

        // test cases
        Node rootNode = new Node(1);
        Node childNode1 = new Node(2);
        Node childNode2 = new Node(3);
        rootNode.children.add(childNode1);
        rootNode.children.add(childNode2);
        childNode1.children.add(new Node(4));
        childNode1.children.add(new Node(5));
        childNode2.children.add(new Node(6));

        Node testTree1 = new Node(1);
        testTree1.children.add(new Node(2));
        testTree1.children.add(new Node(3));
        assert sum(testTree1) == 6 : "Test failed, expected sum is 6"; // 1 + 2 + 3

        Node testTree2 = new Node(10);
        assert sum(testTree2) == 10 : "Test failed, expected sum is 10 for a single node"; // 10

        Node testTree3 = new Node(5);
        testTree3.children.add(new Node(1));
        testTree3.children.add(new Node(2));
        testTree3.children.add(new Node(3));
        assert sum(testTree3) == 11 : "Test failed, expected sum is 11"; // 5 + 1 + 2 + 3

        Node testTree4 = new Node(0);
        assert sum(testTree4) == 0 : "Test failed, expected sum for a node with value 0 is 0"; // 0

        Node testTree5 = new Node(1);
        testTree5.children.add(new Node(0));
        testTree5.children.add(new Node(0));
        assert sum(testTree5) == 1 : "Test failed, expected sum is 1"; // 1 + 0 + 0

        // if all tests pass
        System.out.println("All tests passed!");
    }
}
