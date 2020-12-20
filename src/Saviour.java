import java.io.*;
import java.util.ArrayList;

/**
 * Class saviour is responsible for saving the progress of the
 * programme. This class uses "object-writing" method to write the
 * given objects
 * @author AmirFazlollahi
 * @since the dawn of time
 * @version -1
 */
public class Saviour {
    /**
     * Gets an arrayList of students and writes it to a specific file
     * @param students The students list
     * @throws IOException when not finding proper access to storage
     */
    public void writeStudents(ArrayList<Student> students) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Students.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Student student:
             students) {
            objectWriter.writeObject(student);
        }
        objectWriter.close();
        outputStream.close();
    }

    /**
     * Gets an arrayList of teachers and writes it to a specific file
     * @param teachers The teachers list
     * @throws IOException when not finding proper access to storage
     */
    public void writeTeachers(ArrayList<Teacher> teachers) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Teachers.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Teacher teacher:
                teachers) {
            objectWriter.writeObject(teacher);
        }
        objectWriter.close();
        outputStream.close();
    }

    /**
     * Gets an arrayList of courses and writes it to a specific file
     * @param courses The students list
     * @throws IOException when not finding proper access to storage
     */
    public void writeCourses(ArrayList<Course> courses) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Courses.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Course course:
                courses) {
            objectWriter.writeObject(course);
        }
        objectWriter.close();
        outputStream.close();
    }

    /**
     * Gets the admin and writes it to a specific file
     * @param admin The administrator object
     * @throws IOException when not finding proper access to storage
     */
    public void writeAdmin(Administrator admin) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Administrator.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(admin);
        objectWriter.close();
        outputStream.close();
    }

    /**
     * Gets the array of refectory meals and writes it to a specific file
     * @param refectorySchedule The refectory meals array
     * @throws IOException when not finding proper access to storage
     */
    public void writeRefectorySchedule(String[][] refectorySchedule) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Refectory Schedule.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(refectorySchedule);
        objectWriter.close();
        outputStream.close();
    }

    /**
     * Gets the array of refectory prices and writes it to a specific file
     * @param refectoryPrices The students list
     * @throws IOException when not finding proper access to storage
     */
    public void writeRefectoryPrices(float[][] refectoryPrices) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Refectory Prices.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(refectoryPrices);
        objectWriter.close();
        outputStream.close();
    }
}
