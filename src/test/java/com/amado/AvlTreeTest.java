package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
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
    public void aRightRightImbalancedTreeShallGetBalanced() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(10);
        tree.insert(20);

        // ~when
        final Integer height = tree.insert(30);

        // ~then
        assertThat(height, equalTo(0));


        final JsonNode json = AvlTreeUtil.getInstance().toJson(tree);
        final JsonNode root = json.get("root");
        assertThat(root.get("value").asInt(), equalTo(20));
        assertThat(root.get("left").get("value").asInt(), equalTo(10));
        assertThat(root.get("right").get("value").asInt(), equalTo(30));
    }

    @Test
    public void aLeftLeftImbalancedTreeShallGetBalanced() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(30);
        tree.insert(20);

        // ~when
        final Integer height = tree.insert(10);

        // ~then
        assertThat(height, equalTo(0));

        final JsonNode json = AvlTreeUtil.getInstance().toJson(tree);
        final JsonNode root = json.get("root");
        assertThat(root.get("value").asInt(), equalTo(20));
        assertThat(root.get("left").get("value").asInt(), equalTo(10));
        assertThat(root.get("right").get("value").asInt(), equalTo(30));
    }

    @Test
    public void aLeftRightImbalancedTreeShallGetBalanced() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(30);
        tree.insert(20);

        // ~when
        final Integer height = tree.insert(25);

        // ~then
        assertThat(height, equalTo(0));

        final JsonNode json = AvlTreeUtil.getInstance().toJson(tree);
        final JsonNode root = json.get("root");
        assertThat(root.get("value").asInt(), equalTo(25));
        assertThat(root.get("left").get("value").asInt(), equalTo(20));
        assertThat(root.get("right").get("value").asInt(), equalTo(30));
    }

    @Test
    public void aRightLeftImbalancedTreeShallGetBalanced() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(30);
        tree.insert(40);

        // ~when
        final Integer height = tree.insert(35);

        // ~then
        assertThat(height, equalTo(0));

        final JsonNode json = AvlTreeUtil.getInstance().toJson(tree);
        final JsonNode root = json.get("root");
        assertThat(root.get("value").asInt(), equalTo(35));
        assertThat(root.get("left").get("value").asInt(), equalTo(30));
        assertThat(root.get("right").get("value").asInt(), equalTo(40));
    }

    @Test
    public void aRecursiveRightImbalancedTreeShallGetBalanced() {
        final AvlTree tree = new AvlTree();

        // ~given
        tree.insert(30);
        tree.insert(40);
        tree.insert(20);
        tree.insert(35);
        tree.insert(50);

        // ~when
        final Integer height = tree.insert(60);

        // ~then
        assertThat(height, equalTo(0));

        final JsonNode json = AvlTreeUtil.getInstance().toJson(tree);
        final JsonNode root = json.get("root");
        assertThat(root.get("value").asInt(), equalTo(40));
        assertThat(root.get("left").get("value").asInt(), equalTo(30));
        assertThat(root.get("left").get("left").get("value").asInt(), equalTo(20));
        assertThat(root.get("left").get("right").get("value").asInt(), equalTo(35));
        assertThat(root.get("right").get("value").asInt(), equalTo(50));
        assertThat(root.get("right").get("right").get("value").asInt(), equalTo(60));
    }

}