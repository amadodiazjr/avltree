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

    public Boolean isEmpty() {
        return null == getRoot();
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
                parent.setLeftHeight(1);
                return parent.getLeftHeight();
            }

            final Integer height = insert(left, child);
            parent.setLeftHeight(parent.getLeftHeight() + height);

            if (!isBalanced(parent)) {
                System.out.println("L Rotation Needed!");
            }

            return parent.getLeftHeight();
        }

        final Node right = parent.getRight();
        if (null == right) {
            parent.setRight(child);
            parent.setRightHeight(1);
            return parent.getRightHeight();
        }

        final Integer height = insert(right, child);
        parent.setRightHeight(parent.getRightHeight() + height);

        if (!isBalanced(parent)) {
            System.out.println("R Rotation Needed!");
        }

        return parent.getRightHeight();
    }

    private Boolean isBalanced(final Node node) {
        return Math.abs(node.getLeftHeight() - node.getRightHeight()) <= 1;
    }
}