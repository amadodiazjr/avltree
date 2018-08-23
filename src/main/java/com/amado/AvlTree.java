package com.amado;

import org.apache.commons.lang3.Validate;

public class AvlTree {

    private Node root;

    public AvlTree() {
        root = null;
    }

    public void insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");

        if (null == root) {
            root = new Node(number);
            return;
        }

        insertNode(root, new Node(number));
    }

    private void insertNode(Node parent, final Node child) {
        if (null == parent) {
            parent = child;
            return;
        }

        final Integer parentValue = parent.getValue();
        final Integer childValue = child.getValue();
        if (childValue == parentValue) {
            return;
        }

        if (childValue < parentValue) {
            insertNode(parent.getLeft(), child);
        }

        insertNode(parent.getRight(), child);
    }


    public Node getRoot() {
        return root;
    }
}