package com.amado;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetTree {
    private final SetNode root;

    public SetTree() {
        root = new SetNode(new HashSet<>());
    }

    public SetNode insert(final Set<Integer> value) {
        return insert(root, value);
    }

    public SetNode insert(final SetNode root, Set<Integer> value) {
        if (null == root) {
            return new SetNode(value);
        }

        if (root.equals(new SetNode(value))) {
            return root;
        }

        if (root.getValue().isEmpty()) {
            root.setLeft(insert(root.getLeft(), value));
            root.setRight(insert(root.getRight(), root.getValue()));
        } else {
            final Set<Integer> rootValue = root.getValue();
            Set<Integer> newSet = new HashSet<>();
            newSet.addAll(value);
            newSet.addAll(rootValue);
            root.setLeft(insert(root.getLeft(), newSet));
            root.setRight(insert(root.getRight(), rootValue));
        }

        return root;
    }


}
