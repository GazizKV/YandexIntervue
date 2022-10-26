import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;

public class LoopInspector {
    public static void main(String[] args) {

    }

    public static int loopSize(Node node) {
        HashMap<Node, Integer> map = new HashMap<>();
        int index = 1;
        map.put(node, index++);
        Node next;
        while (true) {
            next = node.getNext();
            if (map.keySet().contains(next)) {
                return map.get(node) - map.get(next) + 1;
            }
            map.put(next, index++);
            node = next;
        }
    }

    public static class Node {

        public Node getNext() {
            return null;
        }
    }

}
