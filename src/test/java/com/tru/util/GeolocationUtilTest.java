package com.tru.util;

import com.tru.model.Classroom;
import com.tru.model.Position;
import com.tru.model.Student;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class GeolocationUtilTest {

    public List<Classroom> getClassrooms() throws Exception {
        Classroom engineeringClassroom = new Classroom("Principles of computational geo-location analysis",
                new Position(-118.442689, 34.069140), 20, 20);

        Classroom geologyClassroom = new Classroom("Sedimentary Petrology",
                new Position(-118.441878, 34.069585), 20, 20);

        Classroom psychologyClassroom = new Classroom("Introductory Psychobiology",
                new Position(-118.441312, 34.069742), 20, 20);

        Classroom musicClassroom = new Classroom("Art of Listening",
                new Position(-118.440193, 34.070223), 20, 20);

        Classroom humanitiesClassroom = new Classroom("Art Hitory",
                new Position(-118.441211, 34.071528), 20, 20);

        return Arrays.asList(engineeringClassroom, geologyClassroom,
                psychologyClassroom, musicClassroom, humanitiesClassroom);
    }

    @Test
    public void testStudentsInClassesExample1() throws Exception {

        Student john = new Student("John Wilson", new Position(-118.442639, 34.069149));
        Student jane = new Student("Jane Graham", new Position(-118.441862, 34.069601));
        Student pam = new Student("Pam Pam", new Position(-118.441181, 34.071513));


        List<Student> tes = Arrays.asList(john, jane, pam);

        GeolocationUtil utils = new GeolocationUtil();

        List<Student> res = utils.studentsInClasses(tes, getClassrooms());

        Assert.assertEquals(3, res.size());
        Assert.assertEquals("John Wilson", res.get(0).getName());
        Assert.assertEquals("Jane Graham", res.get(1).getName());
        Assert.assertEquals("Pam Pam", res.get(2).getName());
        System.out.println("Final result: [" + res.stream().map(Student::getName).collect(Collectors.toList()) + "]");
    }

    @Test
    public void testStudentsInClassesExample2() throws Exception {


        Student john = new Student("John Wilson", new Position(-118.443539, 34.069849));
        Student jane = new Student("Jane Graham", new Position(-118.441562, 34.069901));
        Student pam = new Student("Pam Pam", new Position(-118.441171, 34.071523));


        List<Student> tes = Arrays.asList(john, jane, pam);

        GeolocationUtil utils = new GeolocationUtil();

        List<Student> res = utils.studentsInClasses(tes, getClassrooms());

        System.out.println("Final result: [" + res.stream().map(Student::getName).collect(Collectors.toList()) + "]");

        Assert.assertEquals(1, res.size());
        Assert.assertEquals("Pam Pam", res.get(0).getName());
    }
}