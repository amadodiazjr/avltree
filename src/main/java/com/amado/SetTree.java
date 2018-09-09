package com.amado;

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

        final Set<Integer> rootValue = root.getValue();
        if (!rootValue.containsAll(value)) {
            final Set<Integer> newValue = new HashSet<>();
            newValue.addAll(rootValue);
            newValue.addAll(value);

            root.setLeft(insert(root.getLeft(), newValue));
            root.setRight(insert(root.getRight(), rootValue));
            return root;
        }

        root.setLeft(insert(root.getLeft(), value));
        root.setRight(insert(root.getRight(), value));

        return root;
    }


}
