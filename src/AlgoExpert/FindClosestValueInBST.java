package AlgoExpert;

public class FindClosestValueInBST {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    //    Average: O(log(n)) time | O(log(n)) space, where n is the number of nodes in the Binary Search Tree.
    //    Worst: O(n) time | O(n) space, where n is the number of nodes in the Binary Search Tree.
    //    The space complexity is on average O(log(n)) and the worst O(n), because each recursive call to findClosestValueInBst adds a new frame on the call stack, which means we are using extra memory. In other words, we'll be using O(h) memory, where h is the height of the tree.
    public static int findClosestValueInBstHelper(BST tree, int target, int closest) {

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

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBstHelper(tree, target, tree.value);
    }


    ///////////////////////////////////////////

    //    Iterative:
//    Average: O(log(n)) time | O(1) space, where n is the number of nodes in the Binary Search Tree.
//    Worst: O(n) time | O(1) space, , where n is the number of nodes in the Binary Search Tree.
    static int findClosestValueInBst2(BST tree, int target) {
        int currentClosestValue = 0;
        int currentSmallestDifference = Integer.MAX_VALUE;
        BST currentNode = tree;

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

        BST tree = new BST(10);
        BST child1 = new BST(8);
        BST child2 = new BST(7);
        BST child3 = new BST(9);
        BST child4 = new BST(12);
        BST child5 = new BST(15);
        BST child6 = new BST(13);

        tree.left = child1;
        tree.right = child4;
        child1.left = child2;
        child1.right = child3;
        child4.right = child6;
        child6.right = child5;

        System.out.println(findClosestValueInBst(tree, 6));
        System.out.println(findClosestValueInBst2(tree, 6));
    }
}
