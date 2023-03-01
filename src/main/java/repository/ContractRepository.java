package repository;

import EntityManager.Contract;
import Enums.SQL_CRUD;
import connection.CloseConnectionMySQL;
import connection.PoolConnectionMySQL;

import java.sql.*;
import java.util.List;

public class ContractRepository extends PoolConnectionMySQL implements CRUDRepository, CloseConnectionMySQL {
    private Contract contract;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    @Override
    public Object findOne(Object id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Object create(Object object) {
        contract = (Contract) object;
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.INSERT_INTO_CONTRACT.getCRUD());
            preparedStatement.setInt(1, contract.getCustomer_id());
            preparedStatement.setString(2, contract.getFirstname());
            preparedStatement.setString(3, contract.getLastname());
            preparedStatement.setInt(4, contract.getCustomer_id());
            preparedStatement.setInt(5, contract.getAddress_id());
            preparedStatement.setInt(6, contract.getPayment_id());
            preparedStatement.setString(7, contract.getPayment_types());
            preparedStatement.setTimestamp(8,  new Timestamp(System.currentTimeMillis()));
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
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }
}

