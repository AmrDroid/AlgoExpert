package AlgoExpert;

import java.util.Stack;

public class NodeDepths {

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


    //DFS
    // O(n) time |  O(H) height of the tree
    static int nodeDepths(Node node, int depth) {
        if (node == null)
            return 0;
        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
    }

    static int nodeDepths(Node tree) {
        if (tree == null)
            return 0;
        return nodeDepths(tree, 0);
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

        System.out.println(nodeDepths(tree));
        System.out.println(nodeDepths2(tree));
        System.out.println(nodeDepths3(tree));
    }


    //BFS
    // O(n) time | O(H) height of the tree
    static int sum = 0;

    static void nodeDepths2(Node node, int depth) {
        if (node == null)
            return;
        sum += depth;
        nodeDepths2(node.left, depth + 1);
        nodeDepths2(node.right, depth + 1);
    }

    static int nodeDepths2(Node tree) {

        if (tree == null)
            return 0;

        nodeDepths2(tree, 0);
        return sum;
    }

    //    Average: O(n) time | O(h) space, where n is the number of nodes in the Binary Tree and h is the height of the Binary Tree.
//
//    Worst(imbalanced Binary Tree): O(n) time | O(n) space, where n is the number of nodes in the Binary Tree.
    static int nodeDepths3(Node root) {
        int sumOfDepths = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));


        while (stack.size() > 0) {
            Pair pair = stack.pop();

            sumOfDepths += pair.depth;

            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, pair.depth + 1));
            }

            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, pair.depth + 1));
            }
        }

        return sumOfDepths;
    }

    static class Pair {
        NodeDepths.Node node;
        int depth;

        Pair(NodeDepths.Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}




