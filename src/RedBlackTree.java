public class RedBlackTree {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left, right;
        boolean color;

        public Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    // Метод для добавления нового узла в дерево
    public void insert(int key) {
        root = insert(root, key);
        root.color = BLACK;
    }

    // Рекурсивный метод для добавления нового узла в дерево
    private Node insert(Node node, int key) {
        if (node == null)
            return new Node(key, RED);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    // Метод для проверки, является ли узел красным
    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;
    }

    // Метод для выполнения левого малого поворота
    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    // Метод для выполнения правого малого поворота
    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    // Метод для смены цвета узлов
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    // Метод для вывода дерева
    public void printTree() {
        printTree(root, 0);
    }

    // Рекурсивный метод для вывода дерева
    private void printTree(Node node, int level) {
        if (node == null)
            return;

        printTree(node.right, level + 1);

        for (int i = 0; i < level; i++)
            System.out.print("    ");

        if (node.color == RED)
            System.out.println("\033[31m" + node.key + "\033[0m");
        else
            System.out.println("\033[30m" + node.key + "\033[0m");

        printTree(node.left, level + 1);
    }

    // Метод для поиска элемента в дереве
    public boolean search(int key) {
        return search(root, key);
    }

    // Рекурсивный метод для поиска элемента в дереве
    private boolean search(Node node, int key) {
        if (node == null)
            return false;

        if (key < node.key)
            return search(node.left, key);
        else if (key > node.key)
            return search(node.right, key);
        else
            return true;
    }

}