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

    public Node insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");

        final Node node = new Node(number);
        if (null == root) {
            root = node;
        }

        return insert(root, node);
    }

    private Node insert(Node parent, final Node child) {
        final Integer parentValue = parent.getValue();
        final Integer childValue = child.getValue();
        if (childValue == parentValue) {
            return parent;
        }

        if (childValue < parentValue) {
            final Node left = parent.getLeft();
            if (null == left) {
                parent.setLeft(child);
                return parent;
            }

            insert(left, child);
        }

        final Node right = parent.getRight();
        if (null == right) {
            parent.setRight(child);
            return parent;
        }

        return insert(right, child);
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

    public Integer getHeight(final Node node) {
        return getHeight(node, 0);
    }

    private Integer getHeight(final Node node, final Integer height) {
        if (null == node) {
            return height;
        }

        final Integer leftHeight = getHeight(node.getLeft(), height+1);
        final Integer rightHeight = getHeight(node.getRight(), height+1);

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}