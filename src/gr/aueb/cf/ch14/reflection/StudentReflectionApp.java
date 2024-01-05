package gr.aueb.cf.ch14.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Creates an instance of {@link Student} and uses its methods through reflection.
 * Reflection makes it possible despite the fact that the constructor is private.
 *
 * @author thodoris
 */
public class StudentReflectionApp {

    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("gr.aueb.cf.ch14.reflection.Student");
            Constructor<?> defaultCtr = cls.getDeclaredConstructor();
            defaultCtr.setAccessible(true);
            Student student1 = (Student) defaultCtr.newInstance();

            Method setFirstname = cls.getMethod("setFirstname", String.class);
            setFirstname.invoke(student1, "Teo");

            Method getFirstname = cls.getMethod("getFirstname");
            System.out.println(getFirstname.invoke(student1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
