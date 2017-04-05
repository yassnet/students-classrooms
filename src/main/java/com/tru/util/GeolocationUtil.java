package com.tru.util;

import com.tru.util.model.Classroom;
import com.tru.util.model.Student;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class GeolocationUtil {

    public List<Student> studentsInClasses(List<Student> students,
                                           List<Classroom> classrooms) {

        BiFunction<Student, Classroom, Boolean> isStudentInRoom = (element, room) ->
                element.getPosition().getX() < room.getMaxXPosition() &&
                        element.getPosition().getX() > room.getMinXPosition() &&
                        element.getPosition().getY() < room.getMaxYPosition() &&
                        element.getPosition().getY() > room.getMinYPosition();

        Predicate<Student> isInAnyClassroom = element ->
                classrooms.stream().anyMatch(classroom -> isStudentInRoom.apply(element, classroom));

        return students.parallelStream().filter(isInAnyClassroom).collect(Collectors.toList());
    }
}
