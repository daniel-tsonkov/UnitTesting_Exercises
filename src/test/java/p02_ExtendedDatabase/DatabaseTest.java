package p02_ExtendedDatabase;

import org.junit.Before;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private p01_Database.Database database;
    private static final Integer[] NUMBERS = {3, 4, 5, 8, 9, 10};

    @Before //This run before evty test
    public void prepareDatabase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }


}
