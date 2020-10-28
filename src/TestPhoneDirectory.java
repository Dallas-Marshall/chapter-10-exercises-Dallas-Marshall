/**
 * Class to test PhoneDirectory Class methods.
 */
public class TestPhoneDirectory {

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // add Contacts
        phoneDirectory.addContact("Paul", "0438863138");
        phoneDirectory.addContact("Susan", "0438863136");
        phoneDirectory.addContact("Dallas", "0438863167");
        phoneDirectory.addContact("Cain", "0438863110");
        phoneDirectory.addContact("Phoebe", "0414918586");
        System.out.println("Dallas' number:");
        System.out.println(phoneDirectory.getNumber("Dallas"));
        phoneDirectory.printDirectory();
    } // end main

} // end class TestPhoneDirectory
