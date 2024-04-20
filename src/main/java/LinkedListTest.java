import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testAdd() {
        MyLinkedList list = new MyLinkedList();
        assertTrue(list.isEmpty(), "List should be initially empty");

        Appointment appt = new Appointment("John", "Doe", LocalDate.now(), "Checkup", LocalDate.now(), 3, "Dr. Smith");
        list.add(appt);
        assertFalse(list.isEmpty(), "List should not be empty after adding an appointment");
        assertEquals(1, list.size(), "List size should be 1 after addition");
    }
}
