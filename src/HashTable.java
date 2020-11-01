public class HashTable {


    private ListNode[] hashTable;
    private int numPairs;

    public HashTable(int size) {
        if (size <= 0) throw new IllegalArgumentException("Illegal table size");
        hashTable = new ListNode[size];
    } // end HashTable

    public HashTable() {
        hashTable = new ListNode[64];
    } // end HashTable

    void printTable() {
        System.out.println();
        for (int i = 0; i < hashTable.length; i++) {
            System.out.print(i + ":");
            ListNode list = hashTable[i];
            while (list != null) { // null means end of list
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.nextNode;
            }
            System.out.println();
        }
    } // end printTable

    public void put(String key, String value) {
        assert key != null : "Key cannot be null";
        int location = computeHash(key);

        ListNode list = hashTable[location];
        while (list != null) { // null means end of list
            if (list.key.equals(key)) break;
            list = list.nextNode; // Traverse list
        }

        if (list != null) { // key found
            list.value = value;
        } else { // Key doesn't exist
            if (numPairs >= 0.75 * hashTable.length) { // Resize Hash Table when above 75% full
                resize();
                location = computeHash(key); // Get key new location
            }
            // Add to list
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.nextNode = hashTable[location];
            hashTable[location] = newNode;
            numPairs++;  // Update counter
        }
    } // end put

    public String get(String key) {
        int location = computeHash(key);
        ListNode list = hashTable[location];
        while (list != null) { // null means end of list
            if (list.key.equals(key)) return list.value; // Key found
            list = list.nextNode;  // Traverse list
        }
        return null; // Key not found
    } // end get

    public void remove(String key) {
        int location = computeHash(key);  // At what location should the key be?
        if (hashTable[location] == null) { // Key doesnt exist
            return;
        }
        if (hashTable[location].key.equals(key)) { // First Key
            hashTable[location] = hashTable[location].nextNode; // Remove first Node
            numPairs--; // Update counter
            return;
        }
        ListNode previousNode = hashTable[location];
        ListNode currentNode = previousNode.nextNode;
        while (currentNode != null && !currentNode.key.equals(key)) { // Traverse while list not empty and key not found.
            currentNode = currentNode.nextNode;
            previousNode = currentNode;
        }
        if (currentNode != null) { // Key found
            previousNode.nextNode = currentNode.nextNode;
            numPairs--;  // Update counter
        }
    } // end remove

    private static class ListNode {
        String key;
        String value;
        ListNode nextNode;
    } // end nested class ListNode

    public boolean containsKey(String key) {
        int location = computeHash(key);
        ListNode list = hashTable[location];
        while (list != null) { // null means end of list
            if (list.key.equals(key)) return true; // Key found
            list = list.nextNode;
        }
        return false; // Key not found
    } // end containsKey

    public int size() {
        return numPairs;
    } // end size

    private int computeHash(Object key) {
        return (Math.abs(key.hashCode())) % hashTable.length;
    } // end computeHash

    private void resize() {
        ListNode[] newTable = new ListNode[hashTable.length * 2];
        for (ListNode listNode : hashTable) {
            ListNode list = listNode;
            while (list != null) { // null means end of list
                ListNode next = list.nextNode; // Transverse list
                int hash = (Math.abs(list.key.hashCode())) % newTable.length;
                list.nextNode = newTable[hash]; // Copy across
                newTable[hash] = list;
                list = next;
            }
        }
        hashTable = newTable;  // Replace old Table
    } // end resize
} // end class HashTable