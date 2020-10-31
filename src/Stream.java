import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    private static class ScoreData {
        public String firstName;
        public String lastName;
        public int score;

        public ScoreData(String lName, String fName, int s) {
            this.firstName = fName;
            this.lastName = lName;
            this.score = s;
        } // end ScoreData

    } // end nested class ScoreData

    private static final ScoreData[] scoreData = new ScoreData[]{ // Array of ScoreData
            new ScoreData("Smith", "John", 70),
            new ScoreData("Doe", "Mary", 85),
            new ScoreData("Page", "Alice", 82),
            new ScoreData("Cooper", "Jill", 97),
            new ScoreData("Flintstones", "Fred", 66),
            new ScoreData("Rubble", "Barney", 80),
            new ScoreData("Smith", "Judy", 48),
            new ScoreData("Dean", "James", 90),
            new ScoreData("Russ", "Joe", 55),
            new ScoreData("Wolfe", "Bill", 73),
            new ScoreData("Dart", "Mary", 54),
            new ScoreData("Rogers", "Chris", 78),
            new ScoreData("Toole", "Pat", 51),
            new ScoreData("Khan", "Omar", 93),
            new ScoreData("Smith", "Ann", 95)
    };

    public static void main(String[] args) {
        // Count
        long count = Arrays.stream(scoreData).parallel().count();
        System.out.printf("Number of students: %d\n\n", count);

        // Average
        int total = Arrays.stream(scoreData).parallel().mapToInt(s -> s.score).sum();
        System.out.printf("Average Grade: %1.2f\n\n", ((double) total / count));

        // A Students
        long countAStudents = Arrays.stream(scoreData).parallel().filter(s -> s.score >= 90).count();
        System.out.printf("Number of Students with an A: %d\n\n", countAStudents);

        // Failing Students
        List<String> failing = Arrays.stream(scoreData).filter(s -> (s.score < 70)).map(s -> (s.firstName + " " + s.lastName)).collect(Collectors.toList());
        System.out.println("Students Failing:");
        failing.forEach(System.out::println);
        System.out.println();

        // Sort by Last Name
        System.out.println("ScoreData - last name:");
        Arrays.stream(scoreData).sorted(Comparator.comparing(lastName -> lastName.lastName)).forEach(s -> System.out.printf("%s, %s: %d\n", s.lastName, s.firstName, s.score));
        System.out.println();

        // Sort by Score
        System.out.println("ScoreData - score:");
        Arrays.stream(scoreData).sorted(Comparator.comparingInt(scoreData -> scoreData.score)).forEach(s -> System.out.printf("%s, %s: %d%n", s.lastName, s.firstName, s.score));
    } // end main

} // end class Stream
