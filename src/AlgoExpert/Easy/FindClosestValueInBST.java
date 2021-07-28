package AlgoExpert.Easy;

public class FindClosestValueInBST {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //    Average: O(log(n)) time | O(log(n)) space, where n is the number of nodes in the Binary Search Tree.
    //    Worst: O(n) time | O(n) space, where n is the number of nodes in the Binary Search Tree.
    //    The space complexity is on average O(log(n)) and the worst O(n), because each recursive call to findClosestValueInBst adds a new frame on the call stack, which means we are using extra memory. In other words, we'll be using O(h) memory, where h is the height of the tree.
    public static int findClosestValueInBstHelper(Node tree, int target, int closest) {

        if (tree == null)
            return closest;

        if (Math.abs(target - closest) > Math.abs(target - tree.value))
            closest = tree.value;

        if (target > tree.value && tree.right != null)
            return findClosestValueInBstHelper(tree.right, target, closest);
        else if (target < tree.value && tree.left != null)
            return findClosestValueInBstHelper(tree.left, target, closest);

        return closest;
    }

    public static int findClosestValueInNode(Node tree, int target) {
        return findClosestValueInBstHelper(tree, target, tree.value);
    }


    ///////////////////////////////////////////

    //    Iterative:
//    Average: O(log(n)) time | O(1) space, where n is the number of nodes in the Binary Search Tree.
//    Worst: O(n) time | O(1) space, , where n is the number of nodes in the Binary Search Tree.
    static int findClosestValueInBst2(Node tree, int target) {
        int currentClosestValue = 0;
        int currentSmallestDifference = Integer.MAX_VALUE;
        Node currentNode = tree;

        while (currentNode != null) {
            int value = currentNode.value;

            int currentDiff = Math.abs(value - target);

            if (currentDiff < currentSmallestDifference) {
                currentSmallestDifference = currentDiff;
                currentClosestValue = value;
            }

            if (target > value)
                currentNode = currentNode.right;
            else if (target < value)
                currentNode = currentNode.left;
            else
                break;
        }
        return currentClosestValue;
    }

    public static void main(String[] args) {

        Node tree = new Node(10);
        Node child1 = new Node(8);
        Node child2 = new Node(7);
        Node child3 = new Node(9);
        Node child4 = new Node(12);
        Node child5 = new Node(15);
        Node child6 = new Node(13);

        tree.left = child1;
        tree.right = child4;
        child1.left = child2;
        child1.right = child3;
        child4.right = child6;
        child6.right = child5;

        System.out.println(findClosestValueInNode(tree, 6));
        System.out.println(findClosestValueInBst2(tree, 6));
    }
}
