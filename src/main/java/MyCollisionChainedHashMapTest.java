import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

 class MyCollisionChainedHashMapTest {

    @Test
    void testPutAndGet() {
        MyCollisionChainedHashMap map = new MyCollisionChainedHashMap(10);  // Small capacity for testing collision
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1985, 5, 15), LocalDate.now());
        Patient patient2 = new Patient("Jane", "Doe", LocalDate.of(1990, 6, 15), LocalDate.now());

        assertNull(map.put("1234", patient1), "Put should return null on new key");
        assertEquals(patient1, map.put("1234", patient2), "Put should return old value on existing key");
        assertEquals(patient2, map.get("1234"), "Get should return the most recently put value");

        // Testing handling of keys with the same hash index (simulated or real collision)
        assertNull(map.put("abcd", patient1), "Should handle new key correctly, even if colliding");
        assertEquals(patient1, map.get("abcd"), "Should retrieve correct patient for key 'abcd'");
    }

    @Test
    void testRemove() {
        MyCollisionChainedHashMap map = new MyCollisionChainedHashMap(10);
        Patient patient1 = new Patient("John", "Doe", LocalDate.of(1985, 5, 15), LocalDate.now());
        map.put("1234", patient1);
        assertEquals(patient1, map.remove("1234"), "Remove should return the removed patient");
        assertNull(map.get("1234"), "Get should return null after the patient is removed");
    }
}
