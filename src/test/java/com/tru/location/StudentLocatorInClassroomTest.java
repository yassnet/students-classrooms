package com.tru.location;

import com.tru.model.Classroom;
import com.tru.model.Position;
import com.tru.model.Student;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class StudentLocatorInClassroomTest {

    @Test
    public void testStudentsInClasses_allStudentsInClassrooms() throws Exception {

        Student john = new Student("John Wilson", new Position(34.069149, -118.442639));
        Student jane = new Student("Jane Graham", new Position(34.069601, -118.441862));
        Student pam = new Student("Pam Pam", new Position(34.071513, -118.441181));

        List<Student> students = Arrays.asList(john, jane, pam);

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        List<Student> studentsInClasses = studentLocatorInClassroom.studentsInClasses(students, getClassrooms());

        System.out.println("Final result testStudentsInClasses_allStudentsInClassrooms (Example 1): [" +
                studentsInClasses.stream().map(Student::getName).collect(Collectors.toList()) + "]");

        assertThat(studentsInClasses, not(IsEmptyCollection.empty()));
        assertThat(studentsInClasses, hasSize(3));
        assertThat(studentsInClasses, containsInAnyOrder(jane, john, pam));
    }

    @Test
    public void testStudentsInClasses_onlyOneInClassroom() throws Exception {

        Student john = new Student("John Wilson", new Position(34.069849, -118.443539));
        Student jane = new Student("Jane Graham", new Position(34.069901, -118.441562));
        Student pam = new Student("Pam Pam", new Position(34.071523, -118.441171));

        List<Student> students = Arrays.asList(john, jane, pam);

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        List<Student> studentsInClasses = studentLocatorInClassroom.studentsInClasses(students, getClassrooms());

        System.out.println("Final result testStudentsInClasses_onlyOneInClassroom (Example 2): [" +
                studentsInClasses.stream().map(Student::getName).collect(Collectors.toList()) + "]");

        assertThat(studentsInClasses, not(IsEmptyCollection.empty()));
        assertThat(studentsInClasses, hasSize(1));
        assertThat(studentsInClasses, hasItem(pam));
    }

    @Test
    public void testStudentsInClasses_noOneInClassroom() throws Exception {

        Student john = new Student("John Wilson", new Position(30.069849, -118.443539));
        Student jane = new Student("Jane Graham", new Position(30.069901, -118.441562));
        Student pam = new Student("Pam Pam", new Position(30.071523, -118.441171));

        List<Student> students = Arrays.asList(john, jane, pam);

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        List<Student> studentsInClasses = studentLocatorInClassroom.studentsInClasses(students, getClassrooms());

        System.out.println("Final result testStudentsInClasses_noOneInClassroom: [" +
                studentsInClasses.stream().map(Student::getName).collect(Collectors.toList()) + "]");

        assertThat(studentsInClasses, IsEmptyCollection.empty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStudentsInClasses_withEmptyParams() throws Exception {

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        studentLocatorInClassroom.studentsInClasses(new ArrayList<>(), new ArrayList<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStudentsInClasses_withNullStudents() throws Exception {

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        studentLocatorInClassroom.studentsInClasses(null, getClassrooms());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStudentsInClasses_withNullClassrooms() throws Exception {

        Student john = new Student("John Wilson", new Position(30.069849, -118.443539));

        List<Student> students = Arrays.asList(john);

        StudentLocatorInClassroom studentLocatorInClassroom = new StudentLocatorInClassroom();

        studentLocatorInClassroom.studentsInClasses(students, null);
    }

    private List<Classroom> getClassrooms() throws Exception {
        Classroom engineeringClassroom = new Classroom("Principles of computational geo-location analysis",
                new Position(34.069140, -118.442689), 20, 20);

        Classroom geologyClassroom = new Classroom("Sedimentary Petrology",
                new Position(34.069585, -118.441878), 20, 20);

        Classroom psychologyClassroom = new Classroom("Introductory Psychobiology",
                new Position(34.069742, -118.441312), 20, 20);

        Classroom musicClassroom = new Classroom("Art of Listening",
                new Position(34.070223, -118.440193), 20, 20);

        Classroom humanitiesClassroom = new Classroom("Art Hitory",
                new Position(34.071528, -118.441211), 20, 20);

        return Arrays.asList(engineeringClassroom, geologyClassroom,
                psychologyClassroom, musicClassroom, humanitiesClassroom);
    }
}