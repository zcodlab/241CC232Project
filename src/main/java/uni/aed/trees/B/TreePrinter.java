package uni.aed.trees.B;

public class TreePrinter<T extends Comparable<T>> {    
    public String getString(BTree<T> tree) {
        if (tree.root == null) return "Tree no tiene nodos.";
        return getString(tree.root, "", true);
    }

    private String getString(Node<T> node, String prefix, boolean isTail) {
        StringBuilder builder = new StringBuilder();

        builder.append(prefix).append((isTail ? "+-- " : "|-- "));
        for (int i = 0; i < node.numberOfKeys(); i++) {
            T value = node.getKey(i);
            builder.append(value);
            if (i < node.numberOfKeys() - 1)
                builder.append(", ");
        }
        builder.append("\n");

        if (node.children != null) {
            for (int i = 0; i < node.numberOfChildren() - 1; i++) {
                Node<T> obj = node.getChild(i);
                builder.append(getString(obj, prefix + (isTail ? "    " : "|   "), false));
            }
            if (node.numberOfChildren() >= 1) {
                Node<T> obj = node.getChild(node.numberOfChildren() - 1);
                builder.append(getString(obj, prefix + (isTail ? "    " : "|   "), true));
            }
        }

        return builder.toString();
    }
}
