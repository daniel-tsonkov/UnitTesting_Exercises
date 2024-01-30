package p02_ExtendedDatabase;

import org.junit.Before;

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


}
