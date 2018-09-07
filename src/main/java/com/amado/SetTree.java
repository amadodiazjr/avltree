package com.amado;

import java.util.Collections;
import java.util.Set;

public class SetTree {
    private final SetNode root;

    public SetTree() {
        root = new SetNode(Collections.emptySet());
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

        root.setLeft(insert(root.getLeft(), value));
        root.setRight(insert(root.getRight(), root.getValue()));

        return root;
    }


}
