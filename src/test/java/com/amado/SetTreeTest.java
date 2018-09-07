package com.amado;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SetTreeTest {

    @Test
    public void constructorShallCreateAnInstance() {
        // ~given
        SetTree tree = null;

        // ~when
        tree = new SetTree();

        // ~then
        assertThat(tree, notNullValue());
    }

    @Test
    public void insertShallInsertASetNode() {
        final SetTree tree = new SetTree();

        // ~given
        final Set<Integer> setOne = new HashSet<>();
        setOne.add(1);

        // ~when
        SetNode node = tree.insert(setOne);

        // ~then
        assertThat(node, notNullValue());
        JsonNode json = AvlTreeUtil.getInstance().toJson(node);
        assertThat(json, notNullValue());

        final Set<Integer> setTwo = new HashSet<>();
        setTwo.add(2);

        node = tree.insert(setTwo);
        json = AvlTreeUtil.getInstance().toJson(node);
        assertThat(json, notNullValue());
    }

}
