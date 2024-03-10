package algorithms;

public class CustomHashMap<Key, Value> {
    private Entry<Key, Value>[] table;
    private int capacity = 4;

    static class Entry<Key, Value> {
        Key key;
        Value value;
        Entry<Key, Value> next;

        public Entry(Key key, Value value, Entry<Key, Value> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public CustomHashMap() {
        this.table = new Entry[capacity];
    }

    public void put(Key key, Value value) {
        int hash = hash(key);
        Entry<Key, Value> newEntry = new Entry<>(key, value, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<Key, Value> previous = null;
            Entry<Key, Value> current = table[hash];

            while(current != null) { //we have reached last entry of bucket.
                if (current.key.equals(key)) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
            }
        }
    }


    private int hash(Key key){
        return Math.abs(key.hashCode()) % capacity;
    }

}
