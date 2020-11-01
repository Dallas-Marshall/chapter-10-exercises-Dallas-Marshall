import textio.TextIO;

public class TestHashTable {

    public static void main(String[] args) {
        HashTable table = new HashTable(2);
        String key, value;
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("   1. Test put()");
            System.out.println("   2. Test get()");
            System.out.println("   3. Test containsKey()");
            System.out.println("   4. Test remove()");
            System.out.println("   5. Test printTable()");
            System.out.println("   6. Quit");
            System.out.print(">>> ");
            switch (TextIO.getlnInt()) {
                case 1:
                    System.out.print("\n   Key: ");
                    key = TextIO.getln();
                    System.out.print("   Value: ");
                    value = TextIO.getln();
                    table.put(key, value);
                    break;
                case 2:
                    System.out.print("\n   Key: ");
                    key = TextIO.getln();
                    System.out.println("   Value: " + table.get(key));
                    break;
                case 3:
                    System.out.print("\n   Key: ");
                    key = TextIO.getln();
                    System.out.println("   " + table.containsKey(key));
                    break;
                case 4:
                    System.out.print("\n   Key: ");
                    key = TextIO.getln();
                    table.remove(key);
                    break;
                case 5:
                    table.printTable();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("   Error: Illegal Option");
                    break;
            }
            System.out.println("\nHashTable size: " + table.size());
        }
    } // end main
} // end class TestHashTable