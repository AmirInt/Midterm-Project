import java.io.*;
import java.util.ArrayList;

public class Saviour {

    public void writeStudents(ArrayList<Student> students) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Students.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Student student:
             students) {
            objectWriter.writeObject(student);
        }
        outputStream.close();
    }

    public void writeTeachers(ArrayList<Teacher> teachers) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Teachers.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Teacher teacher:
                teachers) {
            objectWriter.writeObject(teacher);
        }
        outputStream.close();
    }

    public void writeCourses(ArrayList<Course> courses) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Courses.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        for (Course course:
                courses) {
            objectWriter.writeObject(course);
        }
        outputStream.close();
    }

    public void writeAdmin(Administrator admin) throws IOException{
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Administrator.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(admin);
        outputStream.close();
    }

    public void writeRefectorySchedule(String[][] refectorySchedule) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Refectory Schedule.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(refectorySchedule);
        objectWriter.close();
        outputStream.close();
    }

    public void writeRefectoryPrices(float[][] refectoryPrices) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("Project Files\\Files\\Refectory Prices.dat");
        ObjectOutputStream objectWriter = new ObjectOutputStream(outputStream);
        objectWriter.writeObject(refectoryPrices);
        objectWriter.close();
        outputStream.close();
    }
}
