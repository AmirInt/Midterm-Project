import java.util.ArrayList;

public class UniversitySystem {

    Administrator administrator;
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;
    ArrayList<Course> courses;
    UI systemUI;

    public UniversitySystem() {
        administrator = Administrator.getInstance("Admin", "admiN");
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
        systemUI = new UI();
    }

    public void addTeacher(Teacher newTeacher) {
        for (Teacher existingTeacher:
             teachers)
            if(existingTeacher.equals(newTeacher)) {
                System.err.println("Username already in use");
                return;
            }
        teachers.add(newTeacher);
    }

    public void removeTeacher(Teacher teacher) {
        if(!teachers.remove(teacher))
            System.err.println("Teacher not found");
    }

    public void addStudent(Student newStudent) {
        for (Student existingStudent:
                students)
            if(existingStudent.equals(newStudent)) {
                System.err.println("Username already in use");
                return;
            }
        students.add(newStudent);
    }

    public void removeStudent(Student student) {
        if(!students.remove(student))
            System.err.println("Student not found");
    }

    public void addCourse(Course newCourse) {
        for (Course existingCourse:
                courses)
            if(existingCourse.equals(newCourse)) {
                System.err.println("Username already in use");
                return;
            }
        courses.add(newCourse);
    }

    public void removeCourse(Course course) {
        if(!courses.remove(course))
            System.err.println("Course not found");
    }
}
