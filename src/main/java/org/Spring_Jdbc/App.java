package org.Spring_Jdbc;

import org.Spring_Jdbc.dao.StudentDao;
import org.Spring_Jdbc.entites.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        //Spring Jdbc =>jdbc Template
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcTemplate template=context.getBean("jdbcTemplate", JdbcTemplate.class);

        //Insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        String query1="insert into student(id,name,city) values(?,?,?)";

        //Fire the query
       int result=template.update(query,50,"Parkash","Mumbai");//run at once
        int result1=template.update(query1,70,"VedParkash","Central Mumbai");
        System.out.println("number of record inserted:"+result);
        System.out.println("number of record inserted:"+result1);

        StudentDao studentDao = (StudentDao) context.getBean("studentDao");


       /* //insert query
        Student student=new Student();
        student.setId(550);
        student.setName("John");
        student.setCity("Indore");

        int result=studentDao.insert(student);
        System.out.println(result);*/


        //update query
        /*  Student student=new Student();
          student.setId(555);
          student.setName("Raj");
          student.setCity("Pune");

         int result1 =studentDao.change(student);
        System.out.println(result1);*/

        //delete query
       /* int result2=studentDao.delete(70);
        System.out.println(result2);*/

        //select single student
    /*   Student student=studentDao.getStudent(45);
        System.out.println(student);*/

        //select all student
        List<Student> students =studentDao.getAllStudents();
        for(Student s:students){
            System.out.println(s);
        }

    }
}
