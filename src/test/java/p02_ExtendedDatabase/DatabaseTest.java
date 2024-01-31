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
        Person[] databaseElemets = database.getElements();

        Assert.assertArrayEquals("Arrays are not the same", PEOPLE, databaseElemets);
        Assert.assertEquals("Count of element is incorect", database.getElementsCount(), PEOPLE.length);
        Assert.assertEquals("Index is incorect!", PEOPLE.length - 1, database.getIndex());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
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
        Person newPerson = new Person(4, "DD");
        Person[] elementsBefore = database.getElements();
        database.add(newPerson);
        Person[] elementsAfter = database.getElements();

        //check if element is added
        Assert.assertEquals("Invalid add operation", elementsBefore.length + 1, elementsAfter.length);
        //check is correct element added
        Person lastPerson = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(lastPerson.getId(), 4);
        Assert.assertEquals(lastPerson.getUsername(), "DD");
    }

    //remove
    //success remove element
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        Person[] elementsBefore = database.getElements();
        database.remove();
        Person[] elementsAfter = database.getElements();

        Assert.assertEquals("Invalid remove operation", elementsBefore.length - 1, elementsAfter.length);
        Person currentLast = elementsAfter[elementsAfter.length - 1];
        Assert.assertEquals(currentLast.getId(), 2);
        Assert.assertEquals(currentLast.getUsername(), "BB");
    }

    //unsuccessful remove ArrayIndexOutOfBoundException
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionInvalidIndex() throws OperationNotSupportedException {
        //database = new Database(); //database = new Database(new Integer[0]);
        //database is empty we will recive exception
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    //find by username
    //1. username is null
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowExceptionNullParameter() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFineByUsername() throws OperationNotSupportedException {
        Person person = database.findByUsername("BB");
        Assert.assertEquals("Invalid ID of the taken person", person.getId(), 2);
        Assert.assertEquals("Invalid Username of the taken person", person.getUsername(), "BB");
    }

    //have more than one person with the same name
    @Test(expected = OperationNotSupportedException.class)
    public void testFindMoreThanOnePersonWithSameName() throws OperationNotSupportedException {
        database.add(new Person(4, "BB"));
        database.findByUsername("BB");
    }

    //do not exist user with same name
    @Test(expected = OperationNotSupportedException.class)
    public void testFineByUsernameNonExistingUsername() throws OperationNotSupportedException {
        database.findByUsername("ZZ");
    }

    //fine by ID
    @Test(expected = OperationNotSupportedException.class)
    public void testFindeById() throws OperationNotSupportedException {
        Person person = database.findById(2);
        Assert.assertEquals("Invalid ID of the taken person", person.getId(), 2);
        Assert.assertEquals("Invalid Username of the taken person", person.getUsername(), "BB");
    }
}
