import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentManager manager=new StudentManager();
      int choice;
      do {
          System.out.println("1. Add Student");
          System.out.println("2. Show Students");
          System.out.println("3. Find Student");
          System.out.println("4. Update Student");
          System.out.println("5. Delete Student");
          System.out.println("6. Exit");
          System.out.println("Enter your choice");
          choice = scanner.nextInt();  //stores the number inside the choice variable
          scanner.nextLine();
          switch (choice) {
              case 1:
                  System.out.println("Enter ID:");
                  int id = scanner.nextInt();  //only reads the typed number, leaves the invisible "Enter" key press in the input buffer
                  scanner.nextLine();  //clears the leftover newline
                  System.out.println("Enter Name:");
                  String name = scanner.nextLine();  //reads and consumes the rest of the current line until the user presses enter
                  System.out.println("Enter Email:");
                  String email = scanner.nextLine();
                  manager.addStudent(new Student(id, name, email));
                  System.out.println("Student added successfully");
                  break;
              case 2:
                  manager.showAllStudents();
                  break;
              case 3:
                  System.out.println("Enter ID:");
                  int searchedId = scanner.nextInt();
                  Student found = manager.findStudent(searchedId);
                  if (found != null) {
                      System.out.println("Student found successfully");
                      manager.showStudentByID(searchedId);
                  } else {
                      System.out.println("Student not found");
                  }
                  break;
              case 4:
                  System.out.println("Enter ID:");
                  int updatedId = scanner.nextInt();
                  System.out.println("Enter Name:");
                  String updatedName = scanner.nextLine();
                  System.out.println("Enter Email:");
                  String updatedEmail = scanner.nextLine();
                  boolean updated = manager.updateStudent(updatedId, updatedName, updatedEmail);
                  if (updated) {
                      System.out.println("Student updated successfully");
                  } else {
                      System.out.println("Student not updated");
                  }
                  break;
              case 5:
                  System.out.println("Enter ID:");
                  int deletedId = scanner.nextInt();
                  boolean deleted = manager.deleteStudent(deletedId);
                  if (deleted) {
                      System.out.println("Student deleted successfully");
                  } else {
                      System.out.println("Student not deleted");
                  }
                  break;
              case 6:
                  System.out.println("Exiting...");
                  break;
              default:
                  System.out.println("Invalid choice.");
                  break;
          }
      } while(choice!=6);
        scanner.close();
      }
    }
