import java.util.Map;
import java.util.TreeMap;

/**
 * An object of type PhoneDirectory is a dictionary of contacts (name: number) pairs.
 */
public class PhoneDirectory {
    private final TreeMap<String, String> contacts;

    /**
     * Constructor to create new PhoneDirectory object.
     */
    public PhoneDirectory() {
        contacts = new TreeMap<String, String>();
    } // end PhoneDirectory

    /**
     * Method to return number of contact from PhoneDirectory
     *
     * @param name The name of the contact you want the number for
     * @return Phone number if contact exists otherwise returns null
     */
    public String getNumber(String name) {
        return contacts.get(name);
    } // end getNumber

    /**
     * Method to add a contact to the PhoneDirectory,
     * name and number must not be null
     *
     * @param name   The name of the contact to be added.
     * @param number The number of the contact to be added.
     */
    public void addContact(String name, String number) {
        if (name.strip().equals("") || number.length() < 10)
            throw new IllegalArgumentException("Invalid name or number");
        contacts.put(name, number);
    } // end addContact

    /**
     * Method to print out the phone directory.
     */
    public void printDirectory() {
        System.out.println("\nPhone Directory:");
        for (Map.Entry<String, String> contact : contacts.entrySet())
            System.out.printf("%10s: %s\n", contact.getKey(), contact.getValue());
    } // end printDirectory

} // end class PhoneDirectory
