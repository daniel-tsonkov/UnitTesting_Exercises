package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testBubbleSort() {
        int[] numbers = {5, 2, 4, 1, 3, 6, 8, 7};
        Bubble.sort(numbers);
        int [] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        Assert.assertArrayEquals(numbers, expected);
    }
}
