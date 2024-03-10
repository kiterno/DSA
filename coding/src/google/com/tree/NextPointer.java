package google.com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointer {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-->0) {
                Node q = queue.poll();

                if(size==0) {
                    q.next = null;
                } else {
                    q.next = queue.peek();
                }
                if(q.left != null) {
                    queue.add(q.left);
                }

                if(q.right != null)
                    queue.add(q.right);
            }
        }

        return root;
    }
}
