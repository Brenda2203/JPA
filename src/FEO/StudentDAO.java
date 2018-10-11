/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FEO;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 
 * @author Labing
 */
public class StudentDAO {

    private Connection connection;

    public StudentDAO(String database) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        connection = DbUtil.getConnection(database);
    }
    
    public void createStudent(Student student) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name,last_name) values (?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getLast_name());
        preparedStatement.executeUpdate();
    }

    public Student readStudent(int id) throws SQLException, URISyntaxException {
        Student student = new Student();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select * from student where deleted=false and id=" + id);
        while (rs.next()) {
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setLast_name(rs.getString("last_name"));
        }
        return student;
    }

    public void updateStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update company set name=?,last_name=?" + " where id=?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getLast_name());
        preparedStatement.executeUpdate();
    }
 

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update student set deleted=true where id=" + id);
        preparedStatement.executeUpdate();
    }


}
