package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.Validate;

import java.util.Stack;

public class AvlTreeUtil {
    private static class InstanceHolder {
        private static final AvlTreeUtil INSTANCE = new AvlTreeUtil();
    }

    public static AvlTreeUtil getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private AvlTreeUtil() {}

    public JsonNode toJson(final AvlTree tree) {
        Validate.notNull(tree, "tree cannot be null.");

        JsonNode node = null;
        try {
            final String jsonString = new ObjectMapper().writeValueAsString(tree);
            node = toJsonNode(jsonString);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        Validate.notNull(node, "json not created.");

        return node;
    }

    public JsonNode toJson(final Node subTree) {
        Validate.notNull(subTree, "subTree cannot be null.");

        JsonNode node = null;
        try {
            final String jsonString = new ObjectMapper().writeValueAsString(subTree);
            node = toJsonNode(jsonString);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        Validate.notNull(node, "json not created.");

        return node;
    }

    public JsonNode toJsonNode(final String jsonText) {
        Validate.notNull(jsonText, "jsonText cannot be null.");

        JsonNode node = null;
        try {
            node = new ObjectMapper().readTree(jsonText);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        Validate.notNull(node, "json not parsed correctly.");

        return node;
    }

    // parent becomes new root.
    public Node rotateLeft(final Stack<Node> nodes) {
        Validate.isTrue(nodes.size() == 3, "incorrect number of nodes found.");

        final Node grandParent = nodes.pop();
        final Node parent = nodes.pop();
        //final Node child = nodes.pop();

        parent.setParent(grandParent.getParent());
        parent.setLeft(grandParent);
        grandParent.setParent(parent);
        grandParent.setRight(null);

        return parent;
    }

    public Node rotateRight(final Stack<Node> nodes) {
        Validate.isTrue(nodes.size() == 3, "incorrect number of nodes found.");

        final Node grandParent = nodes.pop();
        final Node parent = nodes.pop();
        //final Node child = nodes.pop();

        parent.setParent(grandParent.getParent());
        parent.setRight(grandParent);
        grandParent.setParent(parent);
        grandParent.setLeft(null);

        return parent;
    }

    public Node rotateRightThenLeft(final Stack<Node> nodes) {
        Validate.isTrue(nodes.size() == 3, "incorrect number of nodes found.");

        final Node grandParent = nodes.pop();
        final Node parent = nodes.pop();
        final Node child = nodes.pop();

        grandParent.setRight(child);
        child.setRight(parent);
        child.setParent(grandParent);
        parent.setParent(child);
        parent.setLeft(null);

        final Stack<Node> rotatedNodes = new Stack<>();
        rotatedNodes.push(parent);
        rotatedNodes.push(child);
        rotatedNodes.push(grandParent);

        return rotateLeft(rotatedNodes);
    }

    public Node rotateLeftThenRight(final Stack<Node> nodes) {
        Validate.isTrue(nodes.size() == 3, "incorrect number of nodes found.");

        final Node grandParent = nodes.pop();
        final Node parent = nodes.pop();
        final Node child = nodes.pop();

        grandParent.setLeft(child);
        child.setLeft(parent);
        child.setParent(grandParent);
        parent.setParent(child);
        parent.setRight(null);

        final Stack<Node> rotatedNodes = new Stack<>();
        rotatedNodes.push(parent);
        rotatedNodes.push(child);
        rotatedNodes.push(grandParent);

        return rotateRight(rotatedNodes);
    }

}