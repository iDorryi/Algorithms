public class Main {
    public static void main(String[] args) {

        RedBlackTree tree = new RedBlackTree();

        // Добавляем узлы в дерево
        for (int i = 5; i < 200; i+=5) {
            tree.insert(i);
        }
        tree.insert(41);
        tree.insert(73);
        tree.insert(67);


        // Выводим дерево в порядке in-order
        tree.printTree();

        System.out.println("ищем 20");
        System.out.println(tree.search(20)); // true
    }
}