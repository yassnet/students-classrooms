# students-classrooms
Useful library to handle students and classrooms

public java.util.List<com.tru.model.Student> studentsInClasses(java.util.List<com.tru.model.Student> students, java.util.List<com.tru.model.Classroom> classrooms)

Returns a list of students which are physically in any classroom

Assumptions

- Each classroom has the a square or rectangular shape, every classroom has its dimensions. 
- None of the classrooms intersect. 
- Students are dimensionless outside of their latitude / longitude point 
- Height is not a concern for either the student nor the classroom 
- It does not matter which student was in which classroom, we only care about the list of students found 
- This is intended to be performed in memory where you don’t have the usage of a database of some sort. 
- This function uses UTM projection which has a deformation using high latitudes

Parameters:

- students: list of students
- classrooms: list of classrooms

Returns: List of students inside a classroom