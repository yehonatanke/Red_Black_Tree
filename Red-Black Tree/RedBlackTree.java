class RedBlackTree {

     Node root;
     Node nil;

    public RedBlackTree() {

        nil = new Node(-1);
        nil.color = Color.BLACK;
        root = nil;
    }

    private void leftRotate(Node x) {

        Node y = x.right;
        x.right = y.left;

        if (y.left != nil) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == nil) {
            root = y;
        }
        else if (x == x.parent.left) {
            x.parent.left = y;
        }
        else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    public Node getRoot() {
        return root;
    }

    public Node getNil() {
        return nil;
    }

    private void rightRotate(Node y) {

        Node x = y.left;
        y.left = x.right;

        if (x.right != nil) {
            x.right.parent = y;
        }

        x.parent = y.parent;

        if (y.parent == nil) {
            root = x;
        }
        else if (y == y.parent.left) {
            y.parent.left = x;
        }
        else {
            y.parent.right = x;
        }

        x.right = y;
        y.parent = x;
    }

    private void insertFixup(Node z) {

        while (z.parent.color == Color.RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                }
                else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    rightRotate(z.parent.parent);
                }
            }
            else {
                Node y = z.parent.parent.left;
                if (y.color == Color.RED) {
                    z.parent.color = Color.BLACK;
                    y.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    z = z.parent.parent;
                }
                else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.color = Color.BLACK;
                    z.parent.parent.color = Color.RED;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.color = Color.BLACK;
    }

    public void insert(int key) {

        Node z = new Node(key);
        Node y = nil;
        Node x = root;

        while (x != nil) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            }
            else {
                x = x.right;
            }
        }

        z.parent = y;

        if (y == nil) {
            root = z;
        }
        else if (z.key < y.key) {
            y.left = z;
        }
        else {
            y.right = z;
        }

        z.left = nil;
        z.right = nil;
        z.color = Color.RED;

        insertFixup(z);
    }

    public Node search(int key) {

        return search(root, key);
    }

    private Node search(Node x, int key) {

        if (x == nil || key == x.key) {
            return x;
        }

        if (key < x.key) {
            return search(x.left, key);
        }
        else {
            return search(x.right, key);
        }
    }

    public void delete(int key) {

        Node z = search(root, key);
        if (z != nil) {
            delete(z);
        }
    }

    private void delete(Node z) {

        Node y = z;
        Color yOriginalColor = y.color;
        Node x;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        }
        else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        }
        else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;

            if (y.parent == z) {
                x.parent = y;
            }
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == Color.BLACK) {
            deleteFixup(x);
        }
    }

    private void deleteFixup(Node x) {

        while (x != root && x.color == Color.BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                }
                else {
                    if (w.right.color == Color.BLACK) {
                        w.left.color = Color.BLACK;
                        w.color = Color.RED;
                        rightRotate(w);
                        w = x.parent.right;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = root;
                }
            }
            else {
                Node w = x.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                }
                else {
                    if (w.left.color == Color.BLACK) {
                        w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        leftRotate(w);
                        w = x.parent.left;
                    }
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private void transplant(Node u, Node v) {

        if (u.parent == nil) {
            root = v;
        }
        else if (u == u.parent.left) {
            u.parent.left = v;
        }
        else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private Node minimum(Node x) {

        while (x.left != nil) {
            x = x.left;
        }
        return x;
    }



}