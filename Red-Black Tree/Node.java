
public class Node {

    int key;
    Node parent, left, right;
    Color color;

    public Node(int key) {

        this.key = key;
        this.color = Color.RED;
        this.parent = this.left = this.right = null;
    }

}
