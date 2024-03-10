package google.com.tree;

public class Height {
    int height(Node node)
    {
        if(node == null) {
            return 0;
        }

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight, rheight) + 1;
    }
}
