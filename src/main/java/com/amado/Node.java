package com.amado;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.Validate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    @JsonProperty("value") private final Integer value;

    @JsonProperty("left") private Node left;
    @JsonProperty("right") private Node right;
    @JsonProperty("leftHeight") private Integer leftHeight;
    @JsonProperty("rightHeight") private Integer rightHeight;

    @JsonIgnore private Node parent;

    public Node(final Integer value) {
        Validate.notNull(value, "value cannot be null.");

        this.value = value;
        parent = null;
        leftHeight = 0;
        rightHeight = 0;
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

    public Node getParent() {
        return parent;
    }

    public void setParent(final Node parent) {
        this.parent = parent;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(final Node right) {
        this.right = right;
    }

    public Integer getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(Integer leftHeight) {
        this.leftHeight = leftHeight;
    }

    public Integer getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(Integer rightHeight) {
        this.rightHeight = rightHeight;
    }
}
