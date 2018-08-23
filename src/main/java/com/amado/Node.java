package com.amado;

import org.apache.commons.lang3.Validate;

public class Node {
    private final Integer value;

    private Node left;
    private Node right;

    public Node(final Integer value) {
        Validate.notNull(value, "value cannot be null.");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(final Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }
}
