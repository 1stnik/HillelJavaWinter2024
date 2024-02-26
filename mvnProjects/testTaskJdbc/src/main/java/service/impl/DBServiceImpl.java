package service.impl;

import config.DBConnectivity;
import dto.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import mapper.Mapper;
import service.DBService;

public class DBServiceImpl implements DBService {

    private final String GET_GROUP_LIST = "select distinct s.student_group from student s order by s.student_group";
    private final String GET_STUDENT_LIST_BY_GROUP = "select * from student where student_group = '%s'";
    private final String INSERT_STUDENT = """
        insert into student (first_name, last_name, date_of_birth, email, student_group, country)
        values ('%s', '%s', '%s', '%s', '%s', '%s');
        """;
    private final String DELETE_STUDENT = """
        delete from student where id = %s
        """;

    @Override
    public List<String> getGroupList() throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_GROUP_LIST);
        List<String> groups = Mapper.groupRsToDto(resultSet);
        connection.close();
        return groups;
    }

    @Override
    public List<Student> getStudentsListByGroup(String groupNumber) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            String.format(GET_STUDENT_LIST_BY_GROUP, groupNumber));
        List<Student> groups = Mapper.studentRsToDto(resultSet);
        connection.close();
        return groups;
    }

    @Override
    public void createStudent(Student student) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(String.format(INSERT_STUDENT,
            student.getFirstName(),
            student.getLastName(),
            new Timestamp(student.getDateOfBirth().getTime()),
            student.getEmail(),
            student.getGroup(),
            student.getCountry())
        );
        connection.close();
    }

    @Override
    public void deleteStuden(int id) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(String.format(DELETE_STUDENT, id));
        connection.close();
    }
}
