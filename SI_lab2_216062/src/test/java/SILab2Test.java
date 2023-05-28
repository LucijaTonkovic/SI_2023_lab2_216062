import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    //The users needed for testing, as specified in the README.md
    private static final User user1 = null;
    private static final User user2 = new User("name", "name1234", "email@gmail.com");
    private static final User user3 = new User(null, "p@ssw0rd", "email@gmail.com");
    private static final User user4 = new User("name", "s0m3th!ng3ls3", "other@gmail.com");
    private static final User user5 = new User("username", "0th3rp@ss", "email@gmail.com");
    private static final User user6 = new User("username123", "p@ss w0rd", "email");
    private static final User user7 = new User("username123", "passw0rd", "email");
    //The lists needed for testing, as specified in the README.md
    private static final List<User> list1 = List.of(user4, user5);
    private static final List<User> list2 = new ArrayList<User>();

    @Test
    void everyBranchTest() {
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(user1, list1));
        assertTrue(exception.getMessage().equals("Mandatory information missing!"));

        assertFalse(SILab2.function(user2, list1));
        assertTrue(SILab2.function(user3, list2));
        assertFalse(SILab2.function(user6, list2));
        assertFalse(SILab2.function(user7, list2));
    }

    @Test
    void multipleConditionTest(){
        RuntimeException exception;

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(null, list1));
        assertTrue(exception.getMessage().equals("Mandatory information missing!"));


        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User("name", null, null), list1));
        assertTrue(exception.getMessage().equals("Mandatory information missing!"));

        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User("name", "p@ssw0rd", null), list1));
        assertTrue(exception.getMessage().equals("Mandatory information missing!"));

        assertTrue(SILab2.function(user3, list2));
    }
}