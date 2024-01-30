public class Utility {


    // Method to check if the tree is a valid Red-Black Tree
    public static boolean isValidRedBlackTree(RedBlackTree tree) {

        return isValidRedBlackTree(tree, tree.root);
    }

    // Method to print the tree using in-order traversal
    public static void inOrderTraversal(RedBlackTree tree, Node root) {

        if (root != null && root != tree.nil) {
            inOrderTraversal(tree, root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(tree, root.right);
        }
    }


    // Method to calculate the height of the tree
    public static int calculateHeight(RedBlackTree tree, Node root) {

        if (root == null || root == tree.nil) {
            return 0;
        }
        else {
            int leftHeight = calculateHeight(tree, root.left);
            int rightHeight = calculateHeight(tree, root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private static boolean isValidRedBlackTree(RedBlackTree tree, Node root) {
        // Check Red-Black Tree properties recursively
        if (root == null || root == tree.nil) {
            return true;
        }

        // Property 1: Red/Black property
        if (root.color != Color.RED && root.color != Color.BLACK) {
            return false;
        }

        // Property 2: Root is always black
        if (root == tree.root && root.color != Color.BLACK) {
            return false;
        }

        // Property 3: Red nodes have only black children
        if (root.color == Color.RED && (root.left.color != Color.BLACK || root.right.color != Color.BLACK)) {
            return false;
        }

        // Property 4: Every path from a node to its descendant leaves has the same number of black nodes
        int leftBlackHeight = calculateBlackHeight(tree, root.left);
        int rightBlackHeight = calculateBlackHeight(tree, root.right);
        if (leftBlackHeight != rightBlackHeight) {
            return false;
        }

        // Recursively check for the left and right subtrees
        return isValidRedBlackTree(tree, root.left) && isValidRedBlackTree(tree, root.right);
    }

    private static int calculateBlackHeight(RedBlackTree tree, Node node) {

        if (node == null || node == tree.nil) {
            return 0;
        }
        else {
            int leftHeight = calculateBlackHeight(tree, node.left);
            int rightHeight = calculateBlackHeight(tree, node.right);
            return (node.color == Color.BLACK ? 1 : 0) + Math.max(leftHeight, rightHeight);
        }
    }

}
