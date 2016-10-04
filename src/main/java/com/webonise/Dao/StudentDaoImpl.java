package com.webonise.Dao;

import com.webonise.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("Data")
public class StudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>() {

            {
                put(1, new Student(1, "Amit", "Course 1"));
                put(2, new Student(2, "Nikhil", "Course 2"));
                put(3, new Student(3, "Ajay", "Course 3"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

}