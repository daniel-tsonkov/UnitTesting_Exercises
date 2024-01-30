package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "AA"),
                                            new Person(2, "BB"),
                                            new Person(3, "CC")};

    @Before //This run before evty test
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testConstructorHasCreateCorrectObject() {
        //Integer[] numbers = {3, 4, 5, 8, 9, 10};
        //Database database = new Database(numbers);
        Person[] databaseElemets = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same", PEOPLE, databaseElemets);
        Assert.assertEquals("Count of element is incorect", database.getElementsCount(), PEOPLE.length);
        Assert.assertEquals("Index is incorect!", PEOPLE.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new p01_Database.Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new p01_Database.Database(numbers);
    }

    //Testing method add
    // add null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExceptionNullParameter() throws OperationNotSupportedException {
        database.add(null);
    }

    //add success element
    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        int valueToLoad = 64;
        Integer[] elementsBefore = database.getElements();
        database.add(valueToLoad);
        Integer[] elementsAfter = database.getElements();

        //check if element is added
        Assert.assertEquals("Invalid add operation", elementsBefore.length + 1, elementsAfter.length);
        //check is correct element added
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], Integer.valueOf(valueToLoad));
    }

    //remove
    //success remove element
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Integer[] elementsBefore = database.getElements();
        database.remove();
        Integer[] elementsAfter = database.getElements();
        Assert.assertEquals("Invalid remove operation", elementsBefore.length - 1, elementsAfter.length);
        Assert.assertEquals(elementsAfter[elementsAfter.length - 1], elementsBefore[elementsBefore.length - 2]);
    }

    //unsuccessful remove ArrayIndexOutOfBoundException
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        //database = new Database(); //database = new Database(new Integer[0]);
        //database is empty we will recive exception
        //for (int i = 0; i < NUMBERS.length; i++) {
        //   database.remove();
        //}
        for (Integer data : NUMBERS) {
            database.remove();
        }
        database.remove();
    }
}
