package org.Spring_Jdbc.dao;

import org.Spring_Jdbc.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("studentDao")
public class StudentDaoImple implements StudentDao{
@Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(Student student) {
        //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        //updating data
        String query1="update student set name=? , city=? where id=?";
        int r1=this.jdbcTemplate.update(query1,student.getName(),student.getCity(),student.getId());
        return r1;
    }

    @Override
    public int delete(int studentid) {
        //delete operation
        String query2="delete from student where id=?";
        int r2=this.jdbcTemplate.update(query2,studentid);
        return r2;
    }

    public Student getStudent(int studentId) {
        //selecting single student data
        String query3="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapper_Imple();
        Student student=this.jdbcTemplate.queryForObject(query3, rowMapper,studentId);
        return student;
    }
    //NOTE--queryForObject method is used for single object fetch to database
     //     --query method is used for all object fetch to database

    @Override
    public List<Student> getAllStudents() {

        //selecting multiple student
        String query4="select * from student";
        List<Student> students=this.jdbcTemplate.query(query4,new RowMapper_Imple());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
