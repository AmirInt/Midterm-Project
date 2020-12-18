import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class UniversitySystem {

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private Administrator administrator;
    private String[][] refectorySchedule;
    private float[][] refectoryPrices;

    public UniversitySystem() {
        Saviour saver = new Saviour();
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
        setUp();
        UI.getInstance(administrator, students, teachers, courses, refectorySchedule, refectoryPrices, saver);
    }

    private void setUp() {
        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Teachers.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            Teacher teacher = (Teacher) objectReader.readObject();
            while(teacher != null) {
                teachers.add(teacher);
                teacher = (Teacher) objectReader.readObject();
            }
        } catch (IOException | ClassNotFoundException ignored) { }

        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Students.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            Student student = (Student) objectReader.readObject();
            while(student != null) {
                students.add(student);
                student = (Student) objectReader.readObject();
            }
        } catch (IOException | ClassNotFoundException ignored) { }

        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Courses.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            Course course = (Course) objectReader.readObject();
            while(course != null) {
                courses.add(course);
                course = (Course) objectReader.readObject();
            }
        } catch (IOException | ClassNotFoundException ignored) { }

        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Administrator.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            administrator = (Administrator) objectReader.readObject();
            objectReader.close();
        } catch (IOException | ClassNotFoundException ex) {
            administrator = Administrator.getInstance("Admin", new char[]{'a', 'd', 'm', 'i', 'n', 'a', 'd', 'm', 'i', 'n'});
        }

        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Refectory Prices.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            refectoryPrices = (float[][]) objectReader.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            refectoryPrices = new float[7][2];
            setRefectoryPrices();
        }

        try(FileInputStream inputStream = new FileInputStream("Project Files\\Files\\Refectory Schedule.dat");
            ObjectInputStream objectReader = new ObjectInputStream(inputStream)) {
            refectorySchedule = (String[][]) objectReader.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            refectorySchedule = new String[7][2];
            setRefectorySchedule();
        }
    }

    private void setRefectoryPrices() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                refectoryPrices[i][j] = 0;
            }
        }
    }

    private void setRefectorySchedule() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 2; ++j) {
                refectorySchedule[i][j] = "";
            }
        }
    }
}
