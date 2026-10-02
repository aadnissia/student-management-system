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
          String input = scanner.nextLine();
          try {
              choice = Integer.parseInt(input);
          }
          catch (NumberFormatException e) {
              System.out.println("Please enter a number between 1 and 6");
              choice = 0;
              continue;
          }
          switch (choice) {
              case 1:
                  System.out.println("Enter ID:");
                  String idInput = scanner.nextLine();
                  int id;
                  try{
                      id=Integer.parseInt(idInput);
                  }
                  catch (NumberFormatException e){
                      System.out.println("Please enter a valid ID");
                      continue;
                  }
                  System.out.println("Enter Name:");
                  String name = scanner.nextLine();
                  if(name.trim().isEmpty()){
                      System.out.println("Name can not be empty");
                      continue;
                  }
                  System.out.println("Enter Email:");
                  String email = scanner.nextLine();
                  if(email.trim().isEmpty()){
                      System.out.println("Email can not be empty");
                      continue;
                  }
                  if(!email.contains("@") || !email.contains(".")) {
                      System.out.println("Please enter a valid email address");
                      continue;
                  }
                  manager.addStudent(new Student(id, name, email));
                  System.out.println("Student added successfully");
                  break;
              case 2:
                  manager.showAllStudents();
                  break;
              case 3:
                  System.out.println("Enter ID:");
                  String searchedInput = scanner.nextLine();
                  int searchedId;
                  try{
                      searchedId=Integer.parseInt(searchedInput);
                  }
                  catch (NumberFormatException e){
                      System.out.println("Please enter a valid ID");
                  continue;
                  }
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
                  String updatedInput = scanner.nextLine();
                  int updatedId;
                  try{
                      updatedId=Integer.parseInt(updatedInput);
                  }
                  catch (NumberFormatException e){
                      System.out.println("Please enter a valid ID");
                  continue;
                  }
                  System.out.println("Enter Name:");
                  String updatedName = scanner.nextLine();
                  if(updatedName.trim().isEmpty()){
                      System.out.println("Name can not be empty");
                      continue;
                  }
                  System.out.println("Enter Email:");
                  String updatedEmail = scanner.nextLine();
                  if(updatedEmail.trim().isEmpty()) {
                      System.out.println("Email can not be empty");
                      continue;
                  }
                  if(!updatedEmail.contains("@") || !updatedEmail.contains(".")){
                      System.out.println("Please enter a valid email.");
                      continue;
                  }

                  boolean updated = manager.updateStudent(updatedId, updatedName, updatedEmail);
                  if (updated) {
                      System.out.println("Student updated successfully");
                  } else {
                      System.out.println("Student not updated");
                  }
                  break;
              case 5:
                  System.out.println("Enter ID:");
                  String deletedInput = scanner.nextLine();
                  int deletedId;
                  try{
                      deletedId=Integer.parseInt(deletedInput);
                  }
                  catch (NumberFormatException e){
                      System.out.println("Please enter a valid ID");
                      continue;
                  }
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
