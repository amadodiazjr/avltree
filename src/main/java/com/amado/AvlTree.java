package com.amado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.Validate;

public class AvlTree {
    private Node root;

    public AvlTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    @JsonIgnore
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
            return insertLeft(parent, child);
        }

        return insertRight(parent, child);
    }

    private Integer insertLeft(final Node parent, final Node child) {
        final Node left = parent.getLeft();
        if (null == left) {
            child.setParent(parent);
            parent.setLeft(child);
            parent.setLeftHeight(1);
            return parent.getLeftHeight();
        }

        final Integer height = insert(left, child);
        parent.setLeftHeight(parent.getLeftHeight() + height);

        if (!isBalanced(parent)) {
            final Node grandParent = parent.getParent();  // null
            Node parentChild = parent.getLeft();    // 20

            if (null != parentChild.getRight()) {
                final Node parentChildRight = parentChild.getRight();
                parentChildRight.setParent(parentChild.getParent());
                parentChildRight.setLeft(parentChild);
                parentChildRight.setLeftHeight(1);
                parentChild.setRight(null);
                parentChild.setRightHeight(0);
                parentChild.setParent(parentChildRight);
                parentChild = parentChildRight;
            }

            parentChild.setParent(grandParent);           // 20 > null
            if (null == grandParent) {
                root = parentChild;
            }

            parentChild.setRight(parent);                 //
            parentChild.setRightHeight(1);
            parent.setParent(parentChild);
            parent.setLeft(null);
            parent.setLeftHeight(0);
        }

        return parent.getLeftHeight();
    }

    private Integer insertRight(final Node parent, final Node child) {
        final Node right = parent.getRight();
        if (null == right) {
            child.setParent(parent);
            parent.setRight(child);
            parent.setRightHeight(1);
            return parent.getRightHeight();
        }

        final Integer height = insert(right, child);
        parent.setRightHeight(parent.getRightHeight() + height);

        if (!isBalanced(parent)) {
            final Node grandParent = parent.getParent();
            Node parentChild = parent.getRight();

            if (null != parentChild.getLeft()) {
                final Node parentChildLeft = parentChild.getLeft();
                parentChildLeft.setParent(parentChild.getParent());
                parentChildLeft.setRight(parentChild);
                parentChildLeft.setRightHeight(1);
                parentChild.setLeft(null);
                parentChild.setLeftHeight(0);
                parentChild.setParent(parentChildLeft);
                parentChild = parentChildLeft;
            }

            parentChild.setParent(grandParent);
            if (null == grandParent) {
                root = parentChild;
            }

            parentChild.setLeft(parent);
            parentChild.setLeftHeight(1);
            parent.setParent(parentChild);
            parent.setRight(null);
            parent.setRightHeight(0);
        }

        return parent.getRightHeight();
    }


    private Boolean isBalanced(final Node node) {
        return Math.abs(node.getLeftHeight() - node.getRightHeight()) <= 1;
    }
}