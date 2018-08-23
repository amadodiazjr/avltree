package com.amado;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.Validate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    @JsonProperty("value") private final Integer value;
    @JsonProperty("left") private Node left;
    @JsonProperty("right") private Node right;

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
