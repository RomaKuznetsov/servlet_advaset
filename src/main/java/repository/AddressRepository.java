package repository;

import EntityManager.Address;
import Enums.SQL_CRUD;
import connection.CloseConnectionMySQL;
import connection.PoolConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository extends PoolConnectionMySQL implements CRUDRepository, CloseConnectionMySQL {

    private Address address;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    List<Address> listAllAddress;
    List<Address> listOneCustomerAddress;

    @Override
    public Object create(Object object) {
        address = (Address) object;
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.INSERT_INTO_ADDRESS.getCRUD());
            preparedStatement.setInt(1, address.getCustomer_id());
            preparedStatement.setString(2, address.getCode());
            preparedStatement.setString(3, address.getCountry());
            preparedStatement.setString(4, address.getRegion());
            preparedStatement.setString(5, address.getCity());
            preparedStatement.setString(6, address.getStreet());
            preparedStatement.setInt(7, address.getHouse());
            preparedStatement.setString(8, address.getFrame());
            preparedStatement.setInt(9, address.getApartment());
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
        listAllAddress = new ArrayList<>();
        try {
            connection = takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_CRUD.SELECT_ALL_FROM_ADDRESS.getCRUD());
            while (resultSet.next()) {
                listAllAddress.add(new Address(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getString(9), resultSet.getInt(10)));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        for (Address address : listAllAddress) {
            System.out.println(address.toString());
        }
        return listAllAddress;
    }
    @Override
    public Object findOne(Object id) {
        listOneCustomerAddress = new ArrayList<>();
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_FROM_ADDRESS_CUSTOMER_ID.getCRUD());
            preparedStatement.setInt(1, (Integer) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOneCustomerAddress.add(new Address(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9),
                        resultSet.getInt(10)));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        for (Address address : listOneCustomerAddress) {
            System.out.println(address.toString());
        }
        return listOneCustomerAddress;
    }


    public Address findAddressDelOrReg(Object object) {
        this.address = (Address) object;
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_ADDRESS_REG_OR_DEL.getCRUD());
            preparedStatement.setInt(1, address.getCustomer_id());
            preparedStatement.setString(2, address.getCode());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getInt(8), resultSet.getString(9),
                        resultSet.getInt(10));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        System.out.println(address.toString());
        return address;
    }

    @Override
    public Object update(Object object) {
//Update
        return null;
    }

    @Override
    public void delete(Object id) {
//DELETE FROM Address WHERE customer_id = ? AND code = ?;
    }
}
