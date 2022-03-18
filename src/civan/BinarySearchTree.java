package civan;

public class BinarySearchTree {

    Node root;
    Node min;
    private int size = 0;

    class Node {
        Node left;
        Node right;
        Node parent;
        Node minReachable;
        int value;

        public Node(int n) {
            this.value = n;
            left = null;
            right = null;
            minReachable = this;
        }

        public boolean hasLeft() {
            return left != null;
        }

        public boolean hasRight() {
            return right != null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public Node getMin() {
        return this.min;
    }
    public int getMinAsInt() {
        return this.min.value;
    }

    public void insert(int input) {
        size++;
        Node z = new Node(input);
        Node y = null;
        Node x = this.root;
        while (x != null) {
            //noinspection SuspiciousNameCombination
            y = x;
            if (x.minReachable.value > z.value) {
                x.minReachable = z;
            }
            if (z.value < x.value) {
                x = x.left;
            } else {
                x = x.right;
            }

        }
        z.parent = y;
        if (y == null) {
            this.root = z;
            this.min = z;
        } else if (z.value < y.value) {
            y.left = z;
        } else {
            y.right = z;
        }

        if (min.value > z.value) {
            this.min = z;
        }
    }

    public Node extract_min() throws Exception {
        if (this.root == null) {
            throw new IllegalArgumentException("Empty Tree");
        }
        size--;
        Node min = getMin();

        if (min.parent == null){
            if(min.hasLeft()){
                throw new Exception("Min shouldn't has a left node");
            }

            if(min.hasRight()){
                this.root = min.right;
                min.right.parent = null;
                this.min = min.right.minReachable;
            }

            return min;
        }

        if (min.parent.left == min) {
            this.min = min.parent;
            if (min.hasRight()) {
                min.parent.left = min.right;
                min.right.parent = min.parent;
                this.min = min.right.minReachable;
            }else{
                min.parent.left = null;
            }
            if(min.hasLeft()){
                throw new Exception("Min shouldn't has a left node");
            }
        }

        return min;

    }

    public int getSize() {
        return size;
    }
}
