package com.amado;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class NodeTest {

    @Test(expected = Exception.class)
    public void constructorShallThrowAnExceptionWhenNumberIsNull() {
        Node node = null;

        // ~given
        final Integer number = null;

        // ~when
        node = new Node(number);

        // ~then
        // exception is thrown
    }

    @Test
    public void constructorShallCreateAnInstanceWhenNumberIsNotNull() {
        Node node = null;

        // ~given
        final Integer number = 10;

        // ~when
        node = new Node(number);

        // ~then
        assertThat(node, notNullValue());
    }
}