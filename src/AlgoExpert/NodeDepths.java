package AlgoExpert;

public class NodeDepths {

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

    //DFS
    // O(n) time |  O(H) height of the tree
    static int nodeDepths(BinaryTree node, int depth) {
        if (node == null)
            return 0;
        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
    }

    static int nodeDepths(BinaryTree tree) {
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

        System.out.println(nodeDepths(tree));
        System.out.println(nodeDepths2(tree));
    }


    //BFS
    // O(n) time | O(H) height of the tree
   static int sum = 0;
    static void nodeDepths2(BinaryTree node, int depth) {
        if (node == null)
            return;
        sum+=depth;
        nodeDepths2(node.left, depth + 1);
        nodeDepths2(node.right, depth + 1);
    }

    static int nodeDepths2(BinaryTree tree) {

        if (tree == null)
            return 0;

        nodeDepths2(tree, 0);
        return sum;
    }

}
