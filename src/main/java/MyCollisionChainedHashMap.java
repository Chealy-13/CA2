import java.util.LinkedList;

public class MyCollisionChainedHashMap {
    private LinkedList<Entry>[] map;
    private int count;

    public MyCollisionChainedHashMap(int capacity) {
        map = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            map[i] = new LinkedList<>();
        }
        count = 0;
    }

    private int calcSlot(String key) {
        return Math.abs(key.hashCode()) % map.length;
    }



    public Patient put(String key, Patient patient) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                Patient oldPatient = entry.value;
                entry.value = patient;
                return oldPatient;
            }
        }
        map[slot].add(new Entry(key, patient));
        return null;
    }


    public Patient get(String key) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public Patient remove(String key) {
        int slot = calcSlot(key);
        for (Entry entry : map[slot]) {
            if (entry.key.equals(key)) {
                map[slot].remove(entry);
                count--;
                return entry.value;
            }
        }
        return null;
    }

    private class Entry {
        String key;
        Patient value;

        Entry(String key, Patient value) {
            this.key = key;
            this.value = value;
        }
    }
}

