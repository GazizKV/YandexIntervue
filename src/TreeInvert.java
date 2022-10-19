import java.io.*;
import java.util.Arrays;

public class TreeInvert {

    public static Node rootNode = new Node(1, true);

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputStr = reader.readLine().split(" ");
        int N = Integer.parseInt(inputStr[0]);
        int Q = Integer.parseInt(inputStr[1]);

        int[] nodesToSwap = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Node[] nodes = new Node[N];
        int nextRoot = 0;

        for (int i = 0; i < N / 2; i++) {
            nextRoot = i + 1;
            if (nextRoot == 1) nodes[i] = rootNode;
            if (nextRoot * 2 <= N && nextRoot * 2 + 1 <= N) {
                if (nodes[i] == null) {
                    nodes[i] = new Node(nextRoot);
                }
                nodes[i].left = new Node(nextRoot * 2);
                nodes[nextRoot * 2 - 1] = nodes[i].left;
                nodes[i].left.ancestor = nodes[i];

                nodes[i].right = new Node(nextRoot * 2 + 1);
                nodes[nextRoot * 2] = nodes[i].right;
                nodes[i].right.ancestor = nodes[i];
            } else if (nextRoot * 2 <= N && !(nextRoot * 2 + 1 <= N)) {
                if (nodes[i] == null) {
                    nodes[i] = new Node(nextRoot);
                }
                nodes[i].left = new Node(nextRoot * 2);
                nodes[nextRoot * 2 - 1] = nodes[i].left;
                nodes[i].left.ancestor = nodes[i];
            } else if (!(nextRoot * 2 <= N) && nextRoot * 2 + 1 <= N) {
                if (nodes[i] == null) {
                    nodes[i] = new Node(nextRoot);
                }
                nodes[i].right = new Node(nextRoot * 2 + 1);
                nodes[nextRoot * 2] = nodes[i].right;
                nodes[i].right.ancestor = nodes[i];
            }
        }
        int asdf = 0;
        for (int i = 0; i < nodesToSwap.length; i++) {
            deepCrawl(rootNode);
            System.out.print("\n");
//            rearrangingIntoArray(nodes, rootNode, 0);
            findAndSwap(nodesToSwap[i]);
        }


        reader.close();
        writer.close();

    }

    private static void rearrangingIntoArray(Node[] nodes, Node rootNode, int i) {
        if (rootNode == null) {
            return;
        }
        nodes[i++] = rootNode;
        rearrangingIntoArray(nodes, rootNode.left, i);
        rearrangingIntoArray(nodes, rootNode.right, i);
    }

    private static void findAndSwap(int nodeData) {
        int adfasdfsa = 0;
        Node toSwap = findNode(rootNode, nodeData);
        if (null == toSwap) {
            System.out.println("Node " + nodeData + " not found");
            return;
        }
        if (toSwap.isRoot) {
            return;
        } else {
            if (toSwap.ancestor.left.data == toSwap.data) {
                Node ancestor = toSwap.ancestor;
                Node ancestorOfAncestor = ancestor.ancestor;
                Node left = toSwap.left;

                toSwap.left = ancestor;
                toSwap.ancestor = ancestorOfAncestor;
                if (null != ancestorOfAncestor && ancestorOfAncestor.left.data == ancestor.data) {
                    ancestorOfAncestor.left = toSwap;
                } else {
                    ancestorOfAncestor.right = toSwap;
                }

                ancestor.ancestor = toSwap;
                ancestor.left = left;
                if (null != left) {
                    left.ancestor = ancestor;
                }
                if (ancestor.isRoot) {
                    ancestor.isRoot = false;
                    toSwap.isRoot = true;
                }
            } else {
                Node ancestor = toSwap.ancestor;
                Node ancestorOfAncestor = ancestor.ancestor;
                Node right = toSwap.right;

                toSwap.right = ancestor;
                toSwap.ancestor = ancestorOfAncestor;
                if (null != ancestorOfAncestor && ancestorOfAncestor.left.data == ancestor.data) {
                    ancestorOfAncestor.left = toSwap;
                } else {
                    ancestorOfAncestor.right = toSwap;
                }

                ancestor.ancestor = toSwap;
                ancestor.right = right;
                if (null != right) {
                    right.ancestor = ancestor;
                }
                if (ancestor.isRoot) {
                    ancestor.isRoot = false;
                    toSwap.isRoot = true;
                }
            }
        }
    }

    private static Node findNode(Node rootNode, int nodeData) {
        int asdf = 0;
        Node result;

        if (null == rootNode) return null;
        if (rootNode.data == nodeData) {
            return rootNode;
        }

        result = findNode(rootNode.left, nodeData);
        if (null != result) return result;
        result = findNode(rootNode.right, nodeData);
        return result;

    }

    static class Node {
        int data;

        boolean isRoot = false;

        Node ancestor = null;

        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }

        public Node(int data, boolean b) {
            this.data = data;
            this.isRoot = b;
        }
    }


    public static void deepCrawl(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        deepCrawl(root.left);
        deepCrawl(root.right);

    }

}

