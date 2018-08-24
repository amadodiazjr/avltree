package com.amado;

import org.apache.commons.lang3.Validate;

public class AvlTree {
    private Node root;

    public AvlTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public Integer insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");

        final Node node = new Node(number);
        if (null == root) {
            root = node;
        }

        return insert(root, node);
    }

    private Integer insert(final Node parent, final Node child) {
        final Integer parentValue = parent.getValue();
        final Integer childValue = child.getValue();

        if (childValue == parentValue) {
            return 0;
        }

        if (childValue < parentValue) {
            final Node left = parent.getLeft();
            if (null == left) {
                parent.setLeft(child);
                return 1;
            }

            return parent.getLeftHeight() + insert(parent.getLeft(), child);
        }

        final Node right = parent.getRight();
        if (null == right) {
            parent.setRight(child);
            return 1;
        }

        return parent.getRightHeight() + insert(parent.getRight(), child);
    }

}