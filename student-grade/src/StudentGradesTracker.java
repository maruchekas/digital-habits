import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentGradesTracker {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<String, List<Integer>> studentGrades = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Enter 'load' to load an existing file or 'new' to create a new file:");
        String action = scanner.nextLine();
        if ("load".equals(action)) {
            System.out.println("Enter the file name to load:");
            String fileName = scanner.nextLine();
            loadFile(fileName);
        }

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Add student");
                    break;
                case 2:
                    System.out.println("Remove student");
                    break;
                case 3:
                    System.out.println("Update student grade");
                    break;
                case 4:
                    System.out.println("View all student grades");
                    break;
                case 5:
                    System.out.println("View student grades");
                    break;
                case 6:
                    System.out.println("Save to file");
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Choose an option: ");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student");
        System.out.println("3. Update student's grade");
        System.out.println("4. View grades of all students");
        System.out.println("5. View grades of a specific student");
        System.out.println("6. Save to File");
        System.out.println("7. Quit");
    }

    private static void loadFile(String fileName) {
        System.out.println("Data loaded from file");
    }

}
