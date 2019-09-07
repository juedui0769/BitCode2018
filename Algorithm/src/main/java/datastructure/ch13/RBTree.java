package datastructure.ch13;

import com.sun.org.apache.regexp.internal.RE;

public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isRed(Node node) {
        if (node == null) { // 空节点是黑色的
            return BLACK;
        }
        return node.color;
    }

    /**
     * 左旋转
     * https://coding.imooc.com/lesson/207.html#mid=15183
     *      node                     x
     *     /   \    左旋转          /  \
     *    T1   x  --------->   node   T3
     *        / \              /  \
     *       T2 T3            T1  T2
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {

        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        // 维护颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 右旋转
     * https://coding.imooc.com/lesson/207.html#mid=15184
     *          node                  x
     *          /  \     右旋转      /  \
     *         x   T3  -------->   T1  node
     *        / \                      / \
     *       T1 T2                    T2 T3
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        // 维护颜色
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     *
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK; // 最终根节点为黑色节点
    }

    /**
     *------------------------------------------
     *      42                42
     *     /    +  66 ---->  /  \
     *    37                37  66
     *------------------------------------------
     *      42               42         37
     *     /    + 12 ---->  /   ---->  / \
     *    37               37         12 42
     *                    /
     *                   12
     *------------------------------------------
     *      42              42         40
     *     /    + 40 ----> /   ---->  /  \
     *    37              37         37  42
     *                     \
     *                     40
     *------------------------------------------
     *  Black     Black       Black        Black           Red
     *   /   --->  /   --->    /    --->   /  \   --->   /    \
     *  Red       Red        Red         Red Red       Black Black
     *             \         /
     *             Red     Red
     *------------------------------------------
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }
}
