package com.amado;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
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

    @Test
    public void getRootShallReturnNullWhenNoRootIsSet() {
        // ~given
        final AvlTree tree = new AvlTree();

        // ~when
        final Node root = tree.getRoot();

        // ~then
        assertThat(root, nullValue());
    }

    @Test(expected = Exception.class)
    public void insertShallThrowAnExceptionWhenNumberIsNull() {
        // ~given
        final AvlTree tree = new AvlTree();
        final Integer number = null;

        // ~when
        tree.insert(number);

        // ~then
        // an exception is thrown
    }

    @Test
    public void getRootShallReturnRootWhenInsertIsCalled() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;

        // ~given
        tree.insert(number);

        // ~when
        final Node root = tree.getRoot();

        // ~then
        assertThat(root, notNullValue());
    }
}