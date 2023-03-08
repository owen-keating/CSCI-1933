public class BinaryTree<V extends Comparable<V>> {
    private Node<V> root;

    public BinaryTree(Node<V> root) {
        this.root = root;
    }

    public Node<V> getRoot() {
        return this.root;
    }

    public void printInorder() {
        printInOrderHelper(root);
    }

    private void printInOrderHelper(Node<V> node) {
        if (node == null)
            return;
        printInOrderHelper(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrderHelper(node.getRight());
    }

    public void printPreorder() {
        printPreorderHelper(root);
    }

    private void printPreorderHelper(Node<V> node) {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        printPreorderHelper(node.getLeft());
        printPreorderHelper(node.getRight());
    }

    public void printPostorder() {
        printPostorderHelper(root);
    }

    private void printPostorderHelper(Node<V> node) {
        if (node == null)
            return;
        printPostorderHelper(node.getLeft());
        printPostorderHelper(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    private int size(Node<V> node) {
        if (node == null)
            return 0;
        else
            return(size(node.getLeft()) + 1 + size(node.getRight()));
    }

    public V[] toArray() {
        V[] result = (V[]) new Comparable[size(root)];
        toArrayHelp(root, result, 0);
        return result;
    }

    private int toArrayHelp(Node<V> ref, V[] result, int x) {
        if (ref == null) {
            return x;
        }
        result[x] = ref.getValue();
        x++;
        int left = toArrayHelp(ref.getLeft(), result, x);
        int right = toArrayHelp(ref.getRight(), result, left);
        return right;
    }

    public V[] flatten() {
        V[] arr = (V[]) toArray();
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j].compareTo(arr[j+1]) > 0)
                {
                    V temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    // bubble sort
    // useful for flatten
    public void sort(Comparable[] a) {
        int i, j;
        Comparable temp;
        boolean swapped = true;
        for (i = 0; i < a.length && swapped == true; i++) {
            swapped = false;
            for (j = 1; j < a.length - i; j++) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    swapped = true;
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public void invert() {
        invertHelper(root);
    }

    public Node<V> invertHelper(Node<V> node) {
        if(node!=null){
            Node<V> t = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(t);
            invertHelper(node.getLeft());
            invertHelper(node.getRight());
        }
        return node;
    }

    public boolean isSubtree(Node<V> root1, Node<V> root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.getValue() == root2.getValue()
                && isSubtree(root1.getLeft(), root2.getLeft())
                && isSubtree(root1.getRight(), root2.getRight()));
    }

    public boolean traverse(Node<V> move, Node<V> find){
        if(isSubtree(move,find))
            return true;
        else if(move.getLeft()!=null && move.getRight()!=null)
            return traverse(move.getLeft(), find) || traverse(move.getRight(), find);
        return false;
    }

    public boolean containsSubtree(BinaryTree<V> other) {
        if (other == null)
            return true;
        else
            return traverse(root, other.getRoot());
    }


    // Main contains tests for each milestone.
    // Do not modify existing tests.
    // Un-comment tests by removing '/*' and '*/' as you move through the milestones.
    public static void main(String args[]) {
        // Tree given for testing on
        BinaryTree<Integer> p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));

        // Milestone 1 (Traversing)
        System.out.println("--- Milestone 1 ---");
        System.out.print("Expected: 4 2 5 1 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 2 4 5 3" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 4 5 2 3 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();

        // Milestone 2 (flatten) -- expected output: 1 2 3 4 5

        System.out.println(System.lineSeparator() + "--- Milestone 2 ---");
        System.out.print("Expected: 1 2 3 4 5" + System.lineSeparator() + "Actual: ");

        Comparable[] array_representation = p1Tree.flatten();
        for (int i = 0; i < array_representation.length; i++) {
            System.out.print(array_representation[i] + " ");
        }
        System.out.println();


        // Milestone 3 (invert)

        System.out.println(System.lineSeparator() + "--- Milestone 3 ---");

        p1Tree.invert();

        System.out.print("Expected: 3 1 5 2 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printInorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 1 3 2 5 4" + System.lineSeparator() + "Actual: ");
        p1Tree.printPreorder();
        System.out.println(System.lineSeparator());
        System.out.print("Expected: 3 5 4 2 1" + System.lineSeparator() + "Actual: ");
        p1Tree.printPostorder();
        System.out.println();


        // Milestone 4 (containsSubtree)

        System.out.println(System.lineSeparator() + "--- Milestone 4 ---");

        p1Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2,
                        new Node<Integer>(4, null, null),
                        new Node<Integer>(5, null, null)),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p2Tree = new BinaryTree<Integer>(new Node<Integer>(2,
                new Node<Integer>(4, null, null),
                new Node<Integer>(5, null, null)));
        BinaryTree<Integer> p3Tree = new BinaryTree<Integer>(new Node<Integer>(1,
                new Node<Integer>(2, null, null),
                new Node<Integer>(3, null, null)));
        BinaryTree<Integer> p4Tree = null;

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p2Tree));
        System.out.println();

        System.out.print("Expected: false" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p3Tree));
        System.out.println();

        System.out.print("Expected: true" + System.lineSeparator() + "Actual: ");
        System.out.println(p1Tree.containsSubtree(p4Tree));


    }
}
