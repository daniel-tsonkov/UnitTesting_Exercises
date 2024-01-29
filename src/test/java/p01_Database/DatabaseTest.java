package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {3, 4, 5, 8, 9, 10};

    @Before //This run before evty test
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasCreateCorrectObject() {
        //Integer[] numbers = {3, 4, 5, 8, 9, 10};
        //Database database = new Database(numbers);
        Integer[] databaseElemets = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same", NUMBERS, databaseElemets);
        Assert.assertEquals("Count of element is incorect", database.getElementsCount(), NUMBERS.length);
        Assert.assertEquals("Index is incorect!", NUMBERS.length - 1, database.getIndex());
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
    // add null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionNullParameter() throws OperationNotSupportedException {
        //Integer[] numbers = {3, 4, 5, 8, 9, 10};
        //Database database = new Database(numbers);
        database.add(null);
    }

    //add success element
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        int valueToLoad = 64;
        //Integer[] numbers = {3, 4, 5, 8, 9, 10};
        //Database database = new Database(numbers);
        Integer[] elementsBefore = database.getElements();
        database.add(valueToLoad);
        Integer[] elementsAfter = database.getElements();

        //check if element is added
        Assert.assertEquals("Invalid add operation", elementsBefore.length + 1, elementsAfter.length);
        //check is correct element added
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(valueToLoad));
    }
}
