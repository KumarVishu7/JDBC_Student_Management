package org.Spring_Jdbc.dao;

import org.Spring_Jdbc.entites.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface StudentDao{
    public int insert(Student student);
    public int change(Student student);
    public  int delete(int studentid);
    public Student getStudent(int StudentId);
    public List<Student> getAllStudents();

}
