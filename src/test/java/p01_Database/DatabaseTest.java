package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    @Test
    public void testConstructorHasCreateCorrectObject() throws OperationNotSupportedException {
        Integer [] numbers = {3, 4, 5, 8, 9, 10};
        Database database = new Database(numbers);
        Integer [] databaseElemets = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same", numbers, databaseElemets);
        Assert.assertEquals("Current count of element is incorect", databaseElemets.length, numbers.length);
        Assert.assertEquals("Index is element is incorect", numbers.length - 1, database.getIndex() );
    }
}
