package AlgoExpert;

import java.util.ArrayList;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void branchSums(BinaryTree root, ArrayList<Integer> list, int sum) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(sum + root.value);
            return;
        }
        branchSums(root.left, list, root.value + sum);
        branchSums(root.right, list, root.value + sum);
    }

    static ArrayList<Integer> branchSums(BinaryTree root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayList<Integer> list = new ArrayList<>();
        branchSums(root, list, 0);
        return list;
    }

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        BinaryTree child1 = new BinaryTree(2);
        BinaryTree child2 = new BinaryTree(3);
        BinaryTree child3 = new BinaryTree(4);
        BinaryTree child4 = new BinaryTree(5);
        BinaryTree child5 = new BinaryTree(6);
        BinaryTree child6 = new BinaryTree(7);
        BinaryTree child7 = new BinaryTree(8);
        BinaryTree child8 = new BinaryTree(9);

        tree.left = child1;
        tree.right = child2;

        child1.left = child3;
        child1.right = child4;

        child3.left = child7;
        child3.right = child8;

        child2.left = child5;
        child2.right = child6;

        System.out.println(branchSums(tree).toString());
    }
}
