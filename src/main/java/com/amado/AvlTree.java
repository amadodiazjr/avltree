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

    public void insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");

        if (null == root) {
            root = new Node(number);
        }

        final Node node = insert(root, number);
        //balanceTree(node);
    }

    private Node insert(final Node current, final Integer number) {
        final Integer currentValue = current.getValue();

        // Already exists, don't insert
        if (number == currentValue) {
            return current;
        }

        // Traverse Left
        if (number < currentValue) {
            final Node left = current.getLeft();
            if (null == left) {
                final Node node = new Node(number);
                node.setParent(current);
                current.setLeft(node);

                return node;
            }

            return insert(left, number);
        }

        // Traverse Right
        final Node right = current.getRight();
        if (null == right) {
            final Node node = new Node(number);
            node.setParent(current);
            current.setRight(node);

            return node;
        }

        return insert(current.getRight(), number);
    }

    private Node balanceTree(final Node node) {
        if (null == node) {
            return null;
        }

        final Integer leftHeight = getHeight(node, 0);
        final Integer rightHeight = getHeight(node, 0);
        

        //if (height <= 1) {
//            return balanceTree(node.getParent());
  //      }

        return node;
    }

    private Integer getHeight(final Node node, final Integer height) {
        Integer leftHeight = 0;
        Integer rightHeight = 0;

        if (node != null) {
            leftHeight = getHeight(node.getLeft(), height + 1);
            rightHeight = getHeight(node.getRight(), height + 1);
        }

        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}