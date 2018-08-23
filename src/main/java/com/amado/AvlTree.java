package com.amado;

import org.apache.commons.lang3.Validate;

public class AvlTree {

    private Node root;

    public AvlTree() {
        root = null;
    }

    public void insert(final Integer number) {
        Validate.notNull(number, "number cannot be null.");


    }

    public Node getRoot() {
        return root;
    }
}