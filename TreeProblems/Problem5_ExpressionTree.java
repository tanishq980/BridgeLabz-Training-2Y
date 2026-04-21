import java.util.Stack;

public class Problem5_ExpressionTree {

    static class Node {
        String value;
        Node left, right;

        Node(String v) {
            value = v;
        }
    }

    static void inorder(Node root) {
        if (root != null) {
            System.out.print("(");
            inorder(root.left);
            System.out.print(root.value);
            inorder(root.right);
            System.out.print(")");
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.value + " ");
        }
    }

    static int evaluatePostfix(String[] exp) {
        Stack<Integer> stack = new Stack<>();

        for (String s : exp) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(Integer.parseInt(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (s) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Node root = new Node("*");

        root.left = new Node("+");
        root.right = new Node("-");

        root.left.left = new Node("3");
        root.left.right = new Node("5");

        root.right.left = new Node("8");
        root.right.right = new Node("2");

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        String[] postfix = {"3", "5", "+", "8", "2", "-", "*"};
        System.out.println("\nResult: " + evaluatePostfix(postfix));
    }
}