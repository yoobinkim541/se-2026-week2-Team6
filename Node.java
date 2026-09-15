import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Node {
    public String label;
    public Node parent;
    public List<Node> children;

    public Node(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }

    public boolean hasChild(Node child){
        return !children.isEmpty();
    }

    public int height(){
        if (children.isEmpty()) {
            return 0;
        } else {
            int maxHeight = 0;
            for (Node child : children) {
                int childHeight = child.height();
                if (childHeight > maxHeight) {
                    maxHeight = childHeight;
                }
            }
            return maxHeight + 1;
        }
    }

    public static void BFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        List<Node> visited = new ArrayList<Node>();
        visited.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println(currentNode.label);

            for (Node child : currentNode.children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                }
            }
        }
    }

    public static void DFS(Node currentNode, List<Node> visited) {
        if (currentNode == null) {
            return;
        }

        System.out.printf("visited %s.\n", currentNode.label);
        visited.add(currentNode);

        for (Node child : currentNode.children) {
            if (!visited.contains(child)) {
                DFS(child, visited);
            }
        }
    }
}
