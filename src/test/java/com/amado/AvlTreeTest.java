package com.amado;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
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
    public void getRootShallReturnRootWhenInsertIsSuccessful() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;

        // ~given
        tree.insert(number);

        // ~when
        final Node root = tree.getRoot();

        // ~then
        assertThat(root, notNullValue());
    }

    @Test
    public void isEmptyShallReturnTrueWhenRootIsNull() {
        // ~given
        final AvlTree tree = new AvlTree();

        // ~when
        final Boolean isEmpty = tree.isEmpty();

        // ~then
        assertThat(isEmpty, equalTo(true));
    }

    @Test
    public void isEmptyShallReturnFalseWhenRootIsNotNull() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;

        // ~given
        tree.insert(number);

        // ~when
        final Boolean isEmpty = tree.isEmpty();

        // ~then
        assertThat(isEmpty, equalTo(false));
    }

    @Test
    public void anInsertOnAnEmptyTreeShallReturnHeightOfZero() {
        final AvlTree tree = new AvlTree();

        // ~given
        final Integer number = 10;

        // ~when
        final Integer height = tree.insert(number);

        // ~then
        assertThat(height, equalTo(0));
    }

    @Test
    public void anInsertOnANodeWithAHeightOfZeroShallReturnHeightOfOne() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(10);

        // ~when
        final Integer height = tree.insert(20);

        // ~then
        assertThat(height, equalTo(1));
    }

    @Test
    public void anInsertOnANodeWithAHeightOfOneShallReturnHeightOfTwo() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(10);
        tree.insert(20);

        // ~when
        final Integer height = tree.insert(30);

        // ~then
        assertThat(height, equalTo(2));
    }

}