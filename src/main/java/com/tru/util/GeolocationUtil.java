package com.tru.util;

import com.tru.model.Classroom;
import com.tru.model.Student;

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

    /**
     * Returns a list of students which are physically in any classroom
     * <p>
     * <b>Assumptions</b>
     * - Each classroom has the a square or rectangular shape, every classroom has its dimensions.
     * - None of the classrooms intersect.
     * - Students are dimensionless outside of their latitude / longitude point
     * - Height is not a concern for either the student nor the classroom
     * - It does not matter which student was in which classroom, we only care about the list of students found
     * - This is intended to be performed in memory where you don’t have the usage of a database of some sort.
     * - This function uses UTM projection which has a deformation using high latitudes
     *
     * @param  students  list of students
     * @param  classrooms list of classrooms
     * @return list of students inside a classroom
     */
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
