package com.amado;

import org.apache.commons.lang3.Validate;

import java.util.Set;

public class SetNode {
    private final Set<Integer> value;
    private SetNode left;
    private SetNode right;

    public SetNode(final Set<Integer> value) {
        Validate.notNull(value, "value cannot be null.");
        this.value = value;

        left = null;
        right = null;
    }

    public Set<Integer> getValue() {
        return value;
    }

    public SetNode getLeft() {
        return left;
    }

    public void setLeft(SetNode left) {
        this.left = left;
    }

    public SetNode getRight() {
        return right;
    }

    public void setRight(SetNode right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        final SetNode set = (SetNode) obj;
        if (set.getValue().size() != value.size()) {
            return false;
        }

        return value.containsAll(set.getValue());
    }
}
