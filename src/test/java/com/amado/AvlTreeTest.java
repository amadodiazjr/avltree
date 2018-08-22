package com.amado;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AvlTreeTest {

    @Test
    public void constructorShallCreateAnInstance() {
        // ~given
        AvlTree tree = null;

        // ~when
        tree = new AvlTree();

        // ~then
        assertThat(tree, notNullValue());
    }

}