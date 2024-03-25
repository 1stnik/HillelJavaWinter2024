package com.sparkjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final String GET = "select * from user_table";
    private final String INSERT = """
        insert into user_table (id, firstname, lastname, email)
        values ('%s', '%s', '%s', '%s');
        """;

    @Override
    public void addUser(User user) throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(String.format(INSERT,
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail())
        );
        connection.close();
    }

    @Override
    public Collection<User> getUsers() throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET);
        List<User> users = Mapper.userRsToDto(resultSet);
        connection.close();
        return users;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public User editUser(User user) throws UserException {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public boolean userExist(String id) {
        return false;
    }
}
