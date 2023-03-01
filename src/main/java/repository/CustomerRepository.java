package repository;

import EntityManager.Customer;
import Enums.SQL_CRUD;
import connection.CloseConnectionMySQL;
import connection.PoolConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository extends PoolConnectionMySQL implements CRUDRepository, CloseConnectionMySQL {
    private Customer customer;
    private int customer_id;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;
    private List<Customer> listAllCustomer;

    @Override
    public Object create(Object object) {
        customer = (Customer) object;
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.INSERT_INTO_CUSTOMER.getCRUD());
            preparedStatement.setString(1, customer.getRole());
            preparedStatement.setString(2, customer.getFirstname());
            preparedStatement.setString(3, customer.getLastname());
            preparedStatement.setString(4, customer.getUsername());
            preparedStatement.setString(5, customer.getMail());
            preparedStatement.setString(6, customer.getPassword());
            preparedStatement.setInt(7, customer.getPhone());
            preparedStatement.setTimestamp(8, Timestamp.valueOf(customer.getBirthday()));
            preparedStatement.setString(9, customer.getGender());
            preparedStatement.setTimestamp(10,  new Timestamp(System.currentTimeMillis()));
            flag = preparedStatement.executeUpdate();
            if (flag == 1) {
                connection.setAutoCommit(true);
            } else connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        return flag;
    }

    @Override
    public List findAll() {
        listAllCustomer = new ArrayList<>();
        try {
            connection = takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_CRUD.SELECT_ALL_FROM_CUSTOMER.getCRUD());
            while (resultSet.next()) {
                listAllCustomer.add(new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getTimestamp(11), resultSet.getTimestamp(12)));
            } resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        for (Customer customer : listAllCustomer)  {
            System.out.println(customer.toString());
        }
        return listAllCustomer;
    }
    @Override
    public Object findOne(Object id) {
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_FROM_CUSTOMER_ID.getCRUD());
            preparedStatement.setInt(1, (Integer) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                resultSet.getString(9), resultSet.getString(10), resultSet.getTimestamp(11), resultSet.getTimestamp(12));
            } resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        System.out.println(customer.toString());
        return customer;
    }

    public Customer findCustomerUsernameMail(Object object) {
        customer = (Customer) object;
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_FROM_CUSTOMER_USERNAME_MAIL.getCRUD());
            preparedStatement.setString(1, customer.getUsername());
            preparedStatement.setString(2, customer.getMail());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getTimestamp(11), resultSet.getTimestamp(12));
            } resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        System.out.println(customer.toString());
        return customer;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Object id) {
    }
}
