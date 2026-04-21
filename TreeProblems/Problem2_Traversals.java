public class Problem2_Traversals {

    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node("root");
        root.left = new Node("home");
        root.right = new Node("var");

        root.left.left = new Node("user");
        root.left.right = new Node("docs");
        root.right.right = new Node("log");
        root.left.left.left = new Node("config");

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }
}