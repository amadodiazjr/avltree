package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

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
}
