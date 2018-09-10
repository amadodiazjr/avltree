package com.amado;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class SetNodeTest {

    @Test(expected = Exception.class)
    public void constructorShallThrowAnExceptionWhenNumberIsNull() {
        SetNode node = null;

        // ~given
        final Set<Integer> set = null;

        // ~when
        node = new SetNode(set);

        // ~then
        // exception is thrown
    }

    @Test
    public void constructorShallCreateAnInstanceWhenSetIsNotNull() {
        SetNode node = null;

        // ~given
        final Set<Integer> set = new HashSet<>();

        // ~when
        node = new SetNode(set);

        // ~then
        assertThat(node, notNullValue());
    }

    @Test
    public void equalsShallReturnTrueWhenAllIntegersInSetExist() {
        final Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        // ~given
        final SetNode nodeOne = new SetNode(set);
        final SetNode nodeTwo = new SetNode(set);

        // ~when
        final Boolean isEqual = nodeOne.equals(nodeTwo);

        // ~then
        assertThat(isEqual, equalTo(true));
    }

    @Test
    public void equalsShallReturnTrueWhenSetsAreDifferentSizes() {
        final Set<Integer> setOne = new HashSet<>();
        setOne.add(1);
        setOne.add(2);
        setOne.add(3);

        final Set<Integer> setTwo = new HashSet<>();
        setTwo.add(1);

        // ~given
        final SetNode nodeOne = new SetNode(setOne);
        final SetNode nodeTwo = new SetNode(setTwo);

        // ~when
        final Boolean isEqual = nodeOne.equals(nodeTwo);

        // ~then
        assertThat(isEqual, equalTo(false));
    }

    @Test
    public void equalsShallReturnTrueWhenSetsAreDifferent() {
        final Set<Integer> setOne = new HashSet<>();
        setOne.add(1);
        setOne.add(2);
        setOne.add(3);

        final Set<Integer> setTwo = new HashSet<>();
        setTwo.add(1);
        setTwo.add(2);
        setTwo.add(4);

        // ~given
        final SetNode nodeOne = new SetNode(setOne);
        final SetNode nodeTwo = new SetNode(setTwo);

        // ~when
        final Boolean isEqual = nodeOne.equals(nodeTwo);

        // ~then
        assertThat(isEqual, equalTo(false));
    }

    @Test
    public void testWTF() {
        final Integer[] numbers = {1,2,3};
        all_subsets(numbers);
    }

    private void all_subsets(final Integer[] numbers) {
        final Integer[] subset = new Integer[numbers.length];
        helper(numbers, subset, 0);
    }

    private void helper(final Integer[] numbers, final Integer[] subset, Integer index) {
        if (index == numbers.length) {
            print_set(subset);
        } else {
            subset[index] = null;
            helper(numbers, subset, index+1);
            subset[index] = numbers[index];
            helper(numbers, subset, index+1);
        }
    }

    private void print_set(final Integer[] set) {
        String result = new String();
        for (int i=0; i<set.length; i++) {
            final Integer number = set[i];
            if (number != null) {
                if (!result.isEmpty()) {
                    result = result + ",";
                }

                result = result + number;
            }
        }

        System.out.println("{" + result + "}");
    }
}
