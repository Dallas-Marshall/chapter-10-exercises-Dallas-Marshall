import textio.TextIO;

import java.util.TreeSet;

public class SetCalculator {

    public static void main(String[] args) {
        System.out.println("Enter set computation, press enter to end.");
        System.out.println("E.g. [4, 5, 6] + [7, 5, 9]");
        while (true) {
            char ch;
            System.out.print("\n>>> ");
            TextIO.skipBlanks();
            if (TextIO.peek() == '\n') break; // User wants to exit

            try {
                calculateSet();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            TextIO.getln();  // Discard line.
        }
    } // end main

    private static void calculateSet() {

        // Sets a and B
        TreeSet<Integer> A;
        TreeSet<Integer> B;
        char operator;

        // Read Set A
        A = getSet();

        TextIO.skipBlanks();
        if (TextIO.peek() != '*' && TextIO.peek() != '+' && TextIO.peek() != '-')
            throw new IllegalArgumentException("Error: *, +, or  - between sets");

        // Read operator.
        operator = TextIO.getAnyChar();

        // Read Set B
        B = getSet();

        // Check no further input
        TextIO.skipBlanks();
        if (TextIO.peek() != '\n') throw new IllegalArgumentException("Error: Too much input");

        // Do calculation
        if (operator == '+') A.addAll(B);
        else if (operator == '*') A.retainAll(B);
        else A.removeAll(B);

        // Show Answer
        System.out.print("Answer:  " + A);
    } // end calculateSet

    private static TreeSet<Integer> getSet() {

        TreeSet<Integer> set = new TreeSet<>();

        TextIO.skipBlanks();
        if (TextIO.peek() != '[') throw new IllegalArgumentException("Error: Expected [");
        TextIO.getAnyChar();

        TextIO.skipBlanks();
        if (TextIO.peek() == ']') { // Empty Set
            TextIO.getAnyChar();
            return set;
        }

        while (true) {
            // Check isDigit
            TextIO.skipBlanks();
            if (!Character.isDigit(TextIO.peek())) throw new IllegalArgumentException("Error: not an int");
            int n = TextIO.getInt();
            set.add(n);
            TextIO.skipBlanks();

            // Check for , or ]
            if (TextIO.peek() == ']') {
                break;
            } else if (TextIO.peek() == ',') {
                TextIO.getAnyChar();
            } else {
                throw new IllegalArgumentException("Error: expected , or ]");
            }
        }

        TextIO.getAnyChar();
        return set;
    } // end getSet

} // end class SetCalculator
