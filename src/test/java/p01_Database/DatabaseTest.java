package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    @Test
    public void testConstructorHasCreateCorrectObject() throws OperationNotSupportedException {
        Integer[] numbers = {3, 4, 5, 8, 9, 10};
        Database database = new Database(numbers);
        Integer[] databaseElemets = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same", numbers, databaseElemets);
        Assert.assertEquals("Count of element is incorect", database.getElementsCount(), numbers.length);
        Assert.assertEquals("Index is incorect!", numbers.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    //Testing method add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionNullParameter() throws OperationNotSupportedException {
        Integer[] numbers = {3, 4, 5, 8, 9, 10};
        Database database = new Database(numbers);
        database.add(null);
    }
}
