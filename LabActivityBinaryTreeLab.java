
package labactivitybinarytreelab;

class TreeNode {
    String name;
    TreeNode left, right;

    TreeNode(String name) {
        this.name = name;
        left = right = null;
    }
}

class TreeOperations {
    TreeNode root;

    void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.name + " ");
            inOrderTraversal(node.right);
        }
    }

    String search(TreeNode node, String key) {
        if (node == null) {
            return "Key not found";
        }
        if (node.name.equals(key)) {
            return "Key found";
        }
        if (key.compareTo(node.name) < 0) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    void mirror(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    int countLeafNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    boolean isBST(TreeNode node, String min, String max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.name.compareTo(min) <= 0) {
            return false;
        }
        if (max != null && node.name.compareTo(max) >= 0) {
            return false;
        }
        return isBST(node.left, min, node.name) && isBST(node.right, node.name, max);
    }
}

    public class LabActivityBinaryTreeLab {
    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.root = new TreeNode("Regie");
        tree.root.left = new TreeNode("Elsa");
        tree.root.right = new TreeNode("Zedrick");
        tree.root.left.left = new TreeNode("Denmark");
        tree.root.left.right = new TreeNode("Heart");
        tree.root.right.left = new TreeNode("Marie");
        tree.root.right.right = new TreeNode("Clairy");

        System.out.print("In-order Traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Search result for key 'Heart': " + tree.search(tree.root, "Heart"));
        System.out.println("Search result for key 'Michael': " + tree.search(tree.root, "Michael"));

        System.out.println("Tree height: " + tree.height(tree.root));

        System.out.print("Mirrored Binary Tree: ");
        tree.mirror(tree.root);
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Leaf node count: " + tree.countLeafNodes(tree.root));

        System.out.println("Is the tree a valid Binary Search Tree? " + tree.isBST(tree.root, null, null));
    }
}
