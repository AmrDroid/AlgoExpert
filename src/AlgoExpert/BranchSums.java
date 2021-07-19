package AlgoExpert;

import java.util.ArrayList;
import java.util.Stack;

public class BranchSums {
    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void branchSums(Node root, ArrayList<Integer> list, int sum) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(sum + root.value);
            return;
        }
        branchSums(root.left, list, root.value + sum);
        branchSums(root.right, list, root.value + sum);
    }

    static ArrayList<Integer> branchSums(Node root) {
        if (root == null) return new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        branchSums(root, list, 0);
        return list;
    }

    public static void main(String[] args) {

//        tree =   1
//                /     \
//                2       3
//                /   \   /   \
//                4     5 6     7
//                / \
//                8   9


        Node tree = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);
        Node child4 = new Node(5);
        Node child5 = new Node(6);
        Node child6 = new Node(7);
        Node child7 = new Node(8);
        Node child8 = new Node(9);

        tree.left = child1;
        tree.right = child2;

        child1.left = child3;
        child1.right = child4;

        child3.left = child7;
        child3.right = child8;

        child2.left = child5;
        child2.right = child6;

        System.out.println(branchSums(tree).toString());
        System.out.println(branchSums2(tree).toString());
    }

    public static ArrayList<Integer> branchSums2(Node root) {
        Stack<Pair> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Pair current;
        stack.push(new Pair(root, root.value));
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.node.left == null && current.node.right == null) {
                list.add(current.runningSum);
            }
            if (current.node.right != null) {
                stack.push(new Pair(current.node.right, current.runningSum + current.node.right.value));
            }
            if (current.node.left != null) {
                stack.push(new Pair(current.node.left, current.runningSum + current.node.left.value));
            }
        }
        return list;
    }

}

class Pair {
    BranchSums.Node node;
    int runningSum;

    Pair(BranchSums.Node node, int sum) {
        this.node = node;
        this.runningSum = sum;
    }
}