package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.Validate;

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
}