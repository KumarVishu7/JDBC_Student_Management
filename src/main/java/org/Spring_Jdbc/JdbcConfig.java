package org.Spring_Jdbc;
//this class is used for remove the xml file configuration

import org.Spring_Jdbc.dao.StudentDao;
import org.Spring_Jdbc.dao.StudentDaoImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"org.Spring_Jdbc.dao"})
public class JdbcConfig {
@Bean(name={"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("#Vishu@2691");
        return  ds;
    }
    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
    JdbcTemplate jdbcTemplate=new JdbcTemplate();
    jdbcTemplate.setDataSource(getDataSource());
    return jdbcTemplate;
    }

    @Bean(name={"studentDao"})
    public StudentDao getStudentDao(){
      StudentDaoImple studentDao=new StudentDaoImple();
       studentDao.setJdbcTemplate(getTemplate());
      return studentDao;
    }
}
