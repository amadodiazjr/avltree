package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class AvlTreeUtilTest {

    @Test
    public void getInstanceShallReturnInstance() {
        // ~given
        AvlTreeUtil instance = null;

        // ~when
        instance = AvlTreeUtil.getInstance();

        // ~then
        assertThat(instance, notNullValue());
    }

    @Test
    public void toJsonShallReturnJsonNode() {
        final AvlTree tree = new AvlTree();
        final Integer number = 10;
        tree.insert(number);

        // ~given
        final AvlTreeUtil instance = AvlTreeUtil.getInstance();

        // ~when
        final JsonNode json = instance.toJson(tree);

        // ~then
        assertThat(json, notNullValue());

        final JsonNode root = json.get("root");
        assertThat(root, notNullValue());
        assertThat(root.get("value"), notNullValue());
    }

    @Test
    public void rotateLeftShallMakeParentTheRoot() {
        final Node grandParent = new Node(10);
        final Node parent = new Node(20);
        final Node child = new Node(30);
        parent.setRight(child);
        grandParent.setRight(parent);

        final Stack<Node> nodes = new Stack<>();
        nodes.push(child);
        nodes.push(parent);
        nodes.push(grandParent);

        // ~given
        final JsonNode before = AvlTreeUtil.getInstance().toJson(nodes.lastElement());
        assertThat(before.get("value").asInt(), equalTo(10));
        assertThat(before.get("right").get("value").asInt(), equalTo(20));
        assertThat(before.get("right").get("right").get("value").asInt(), equalTo(30));

        // ~when
        final Node root = AvlTreeUtil.getInstance().rotateLeft(nodes);

        // ~then
        final JsonNode after = AvlTreeUtil.getInstance().toJson(root);
        assertThat(after.get("value").asInt(), equalTo(20));
        assertThat(after.get("left").get("value").asInt(), equalTo(10));
        assertThat(after.get("right").get("value").asInt(), equalTo(30));
    }

    @Test
    public void rotateRightShallMakeParentTheRoot() {
        final Node grandParent = new Node(30);
        final Node parent = new Node(20);
        final Node child = new Node(10);
        parent.setLeft(child);
        grandParent.setLeft(parent);

        final Stack<Node> nodes = new Stack<>();
        nodes.push(child);
        nodes.push(parent);
        nodes.push(grandParent);

        // ~given
        final JsonNode before = AvlTreeUtil.getInstance().toJson(nodes.lastElement());
        assertThat(before.get("value").asInt(), equalTo(30));
        assertThat(before.get("left").get("value").asInt(), equalTo(20));
        assertThat(before.get("left").get("left").get("value").asInt(), equalTo(10));

        // ~when
        final Node root = AvlTreeUtil.getInstance().rotateRight(nodes);

        // ~then
        final JsonNode after = AvlTreeUtil.getInstance().toJson(root);
        assertThat(after.get("value").asInt(), equalTo(20));
        assertThat(after.get("left").get("value").asInt(), equalTo(10));
        assertThat(after.get("right").get("value").asInt(), equalTo(30));
    }

    @Test
    public void rotateRightThenLeftShallMakeChildTheRoot() {
        final Node grandParent = new Node(30);
        final Node parent = new Node(50);
        final Node child = new Node(40);
        parent.setLeft(child);
        grandParent.setRight(parent);

        final Stack<Node> nodes = new Stack<>();
        nodes.push(child);
        nodes.push(parent);
        nodes.push(grandParent);

        // ~given
        final JsonNode before = AvlTreeUtil.getInstance().toJson(nodes.lastElement());
        assertThat(before.get("value").asInt(), equalTo(30));
        assertThat(before.get("right").get("value").asInt(), equalTo(50));
        assertThat(before.get("right").get("left").get("value").asInt(), equalTo(40));

        // ~when
        final Node root = AvlTreeUtil.getInstance().rotateRightThenLeft(nodes);

        // ~then
        final JsonNode after = AvlTreeUtil.getInstance().toJson(root);
        assertThat(after.get("value").asInt(), equalTo(40));
        assertThat(after.get("left").get("value").asInt(), equalTo(30));
        assertThat(after.get("right").get("value").asInt(), equalTo(50));
    }
/*
    @Test
    public void rotateLeftThenRightShallMakeChildTheRoot() {
        final Node grandParent = new Node(30);
        final Node parent = new Node(50);
        final Node child = new Node(40);
        parent.setLeft(child);
        grandParent.setRight(parent);

        final Stack<Node> nodes = new Stack<>();
        nodes.push(child);
        nodes.push(parent);
        nodes.push(grandParent);

        // ~given
        final JsonNode before = AvlTreeUtil.getInstance().toJson(nodes.lastElement());
        assertThat(before.get("value").asInt(), equalTo(30));
        assertThat(before.get("right").get("value").asInt(), equalTo(50));
        assertThat(before.get("right").get("left").get("value").asInt(), equalTo(40));

        // ~when
        final Node root = AvlTreeUtil.getInstance().rotateRightThenLeft(nodes);

        // ~then
        final JsonNode after = AvlTreeUtil.getInstance().toJson(root);
        assertThat(after.get("value").asInt(), equalTo(40));
        assertThat(after.get("left").get("value").asInt(), equalTo(30));
        assertThat(after.get("right").get("value").asInt(), equalTo(50));
    }
*/
}
