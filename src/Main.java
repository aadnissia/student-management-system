public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student student1 = new Student(1, "Adna", "mhmtvcadna@gmail.com");
        manager.addStudent(student1);
        manager.showAllStudents();
        Student foundStudent = manager.findStudent(1);
        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }
        boolean deleted = manager.deleteStudent(9);
        if(deleted) {
            System.out.println("Student deleted.");
        }
        else {
            System.out.println("Student not deleted.");
        }
        manager.showAllStudents();
        boolean updated = manager.updateStudent(1, "Adna Updated", "newmhmtvc@gmail.com");
        if(updated) {
            System.out.println("Student updated.");
        }
        else {
            System.out.println("Student not updated.");
        }
        manager.showAllStudents();
    }
}
