package Pocket_Gem;

import java.util.Arrays;

/**
 * Created by xiaochen on 10/2/17.
 */
public class sortColorClass {
    public static void main(String[] args) {
        Node[] nodes = new Node[]{new Node('c'), new Node('b'), new Node('r'), new Node('r'), new Node('c')};
        sortColor(nodes);
    }

    public static void sortColor(Node[] nodes) {
        Arrays.sort(nodes, (a, b) ->{
            if (a.color == 'c' || b.color == 'r') {
                return 1;
            } else if (a.color == 'r' || b.color == 'c') {
                return  -1;
            } else {
                return 0;
            }
        });
        for (Node node : nodes) System.out.println(node.color);
    }

    static class Node {
        char color;
        public Node (char c) {
            color = c;
        }
    }
}


