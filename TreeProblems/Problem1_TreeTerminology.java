public class Problem1_TreeTerminology {

    static class Node {
        String name;
        Node left, right;

        Node(String name) {
            this.name = name;
        }
    }

    static int height(Node root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int depth(Node root, String target, int d) {
        if (root == null) return -1;
        if (root.name.equals(target)) return d;

        int left = depth(root.left, target, d + 1);
        if (left != -1) return left;

        return depth(root.right, target, d + 1);
    }

    static boolean printAncestors(Node root, String target) {
        if (root == null) return false;

        if (root.name.equals(target)) return true;

        if (printAncestors(root.left, target) || printAncestors(root.right, target)) {
            System.out.print(root.name + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node CEO = new Node("CEO");
        CEO.left = new Node("CTO");
        CEO.right = new Node("CFO");

        CEO.left.left = new Node("Dev Lead");
        CEO.left.right = new Node("Manager");

        CEO.right.right = new Node("HR");

        CEO.left.left.left = new Node("Dev1");
        CEO.left.left.right = new Node("Dev2");

        System.out.println("Height: " + height(CEO));
        System.out.println("Depth of Dev Lead: " + depth(CEO, "Dev Lead", 0));

        System.out.print("Ancestors of Dev1: ");
        printAncestors(CEO, "Dev1");
    }
}