import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showStudentByID(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
            }
        }
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
    public boolean updateStudent(int id, String name, String email) {
        Student student = findStudent(id);
        if (student != null) {
            student.setName(name);
            student.setEmail(email);
            return true;
        }
        return false;
    }
    }


