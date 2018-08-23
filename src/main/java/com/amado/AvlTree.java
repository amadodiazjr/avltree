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

    public void insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");

        final Node node = new Node(number);
        if (null == root) {
            root = node;
        }

        insert(root, node);
    }

    private void insert(Node parent, final Node child) {
        final Integer parentValue = parent.getValue();
        final Integer childValue = child.getValue();
        if (childValue == parentValue) {
            return;
        }

        if (childValue < parentValue) {
            final Node left = parent.getLeft();
            if (null == left) {
                parent.setLeft(child);
                return;
            }

            insert(left, child);
        }

        final Node right = parent.getRight();
        if (null == right) {
            parent.setRight(child);
            return;
        }

        insert(right, child);
    }

    public Node find(final Node node, final Integer number) {
        if (null == node) {
            return null;
        }

        final Integer nodeValue = node.getValue();
        if (number == nodeValue) {
            return node;
        }

        if (number < nodeValue) {
            return find(node.getLeft(), number);
        }

        return find(node.getRight(), number);
    }
}