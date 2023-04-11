import java.io.*;
import java.util.*;

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
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    updateStudentGrade();
                    break;
                case 4:
                    viewAllStudentGrades();
                    break;
                case 5:
                    viewStudentGrades();
                    break;
                case 6:
                    saveToFile();
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

    private static void addStudent() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        if (studentGrades.containsKey(name)) {
            System.out.println("Student already exists! Please remove the student first.");
        } else {
            studentGrades.put(name, new ArrayList<>());
            System.out.println("Student added.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter the student's name to remove: ");
        String name = scanner.nextLine();
        if (studentGrades.containsKey(name)) {
            studentGrades.remove(name);
            System.out.println("Student removed");
        } else {
            System.out.println("Student not found");
        }
    }

    private static void updateStudentGrade() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        if (studentGrades.containsKey(name)) {
            System.out.print("Enter student's grade: ");
            int grade = scanner.nextInt();
            List<Integer> grades = studentGrades.get(name);
            grades.add(grade);
            studentGrades.put(name, grades);
        } else {
            System.out.println("Student not found");
        }
    }

    private static void viewAllStudentGrades() {
        for (Map.Entry<String, List<Integer>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void viewStudentGrades() {
        System.out.print("Enter the student's name: ");
        String name = scanner.nextLine();
        if (!studentGrades.containsKey(name)) {
            System.out.println("Student not found");
        } else {
            List<Integer> grades = studentGrades.get(name);
            System.out.println(name + ": " + grades);
            grades.forEach(System.out::println);
        }
    }

    private static void loadFile(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            studentGrades = (Map<String, List<Integer>>) objectInputStream.readObject();
            System.out.println("Data loaded from file.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error while loading data from file.");
        }
    }

    private static void saveToFile() {
        System.out.print("Enter the file name to save: ");
        String fileName = scanner.nextLine();

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(studentGrades);
            System.out.println("Data saved to file.");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while saving data to file.");
        }
    }

}
