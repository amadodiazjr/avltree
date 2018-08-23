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
    public void findShallReturnNullIfRootDoesNotExist() {

        // ~given
        final AvlTree tree = new AvlTree();

        // ~when
        final Node node = tree.find(tree.getRoot(), 10);

        // ~then
        assertThat(node, nullValue());
    }

    @Test
    public void findShallReturnNodeIfRootDoesExist() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;
        tree.insert(number);
        final Node root = tree.getRoot();

        // ~given
        assertThat(root, notNullValue());

        // ~when
        final Node node = tree.find(root, 10);

        // ~then
        assertThat(node, notNullValue());
    }

    @Test
    public void getHeightShallReturnOneOnRootNodeWithZeroChildren() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;
        tree.insert(number);
        final Node root = tree.getRoot();

        // ~given
        assertThat(root, notNullValue());

        // ~when
        final Integer height = tree.getHeight(root);

        // ~then
        assertThat(height, equalTo(1));
    }

    @Test
    public void getHeightShallReturnZeroWhenNodeHasNoLeftChild() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;
        tree.insert(number);
        final Node root = tree.getRoot();
        final Node left = root.getLeft();

        // ~given
        assertThat(left, nullValue());

        // ~when
        final Integer height = tree.getHeight(left);

        // ~then
        assertThat(height, equalTo(0));
    }

    @Test
    public void getHeightShallReturnOneWhenNodeHasOneLeftChild() {
        final AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(5);
        final Node root = tree.getRoot();
        final Node left = root.getLeft();

        // ~given
        assertThat(left, notNullValue());

        // ~when
        final Integer height = tree.getHeight(left);

        // ~then
        assertThat(height, equalTo(1));
    }

    @Test
    public void getHeightShallReturnZeroWhenNodeHasNoRightChild() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;
        tree.insert(number);
        final Node root = tree.getRoot();
        final Node right = root.getRight();

        // ~given
        assertThat(right, nullValue());

        // ~when
        final Integer height = tree.getHeight(right);

        // ~then
        assertThat(height, equalTo(0));
    }

    @Test
    public void getHeightShallReturnOneWhenNodeHasOneRightChild() {
        final AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(20);
        final Node root = tree.getRoot();
        final Node right = root.getRight();

        // ~given
        assertThat(right, notNullValue());

        // ~when
        final Integer height = tree.getHeight(right);

        // ~then
        assertThat(height, equalTo(1));
    }

}