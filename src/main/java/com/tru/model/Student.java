package com.tru.model;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-04
 * @since 1.8
 */
public class Student {

    private String name;
    private Position position;

    public Student(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
