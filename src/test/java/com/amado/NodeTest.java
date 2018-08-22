package com.amado;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test
    public void constructorShallCreateAnInstance() {
        // ~given
        Node node = null;

        // ~when
        node = new Node();

        // ~then
        assertThat(node, notNullValue());
    }
}