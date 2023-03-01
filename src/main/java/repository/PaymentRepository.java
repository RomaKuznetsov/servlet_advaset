package repository;

import EntityManager.Payment;
import Enums.SQL_CRUD;
import Enums.StatusPayment;
import connection.CloseConnectionMySQL;
import connection.PoolConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository extends PoolConnectionMySQL implements CRUDRepository, CloseConnectionMySQL {

    private Payment payment;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Payment paymentPay;
    List<Payment> listAllPayment;
    List<Payment> listAllPaymentId;

    @Override
    public Object create(Object object) {
        payment = (Payment) object;
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.INSERT_INTO_PAYMENT.getCRUD());
            preparedStatement.setInt(1, payment.getPhone());
            preparedStatement.setString(2, payment.getStatus());
            preparedStatement.setString(3, payment.getFirstname());
            preparedStatement.setString(4, payment.getLastname());
            preparedStatement.setLong(5, Long.valueOf(payment.getCard()));
            preparedStatement.setDate(6, Date.valueOf(payment.getValidity()));
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
        listAllPayment = new ArrayList<>();
        try {
            connection = takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_CRUD.SELECT_ALL_FROM_PAYMENT.getCRUD());
            while (resultSet.next()) {
                listAllPayment.add(new Payment(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Payment payment : listAllPayment) {
            System.out.println(payment.toString());
        }
        return listAllPayment;
    }

    public List findListIdPayment(Object object) {
        payment = (Payment) object;
        listAllPaymentId = new ArrayList<>();
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_LIST_PAYMENT_ID.getCRUD());
            preparedStatement.setInt(1, payment.getPhone());
            preparedStatement.setString(2, payment.getFirstname());
            preparedStatement.setString(3, payment.getLastname());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listAllPaymentId.add(new Payment(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7)));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        for (Payment payment : listAllPaymentId) {
            System.out.println(payment.toString());
        }
        return listAllPaymentId;
    }

    @Override
    public Object findOne(Object id) {
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_FROM_PAYMENT_CARD.getCRUD());
            preparedStatement.setInt(1, (Integer) id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                payment = new Payment(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        System.out.println(payment.toString());
        return payment;
    }

    public Payment findOnePaymentPay(Object object) {
        payment = (Payment) object;
        listAllPaymentId = new ArrayList<>();
        try {
            connection = takeConnection();
            preparedStatement = connection.prepareStatement(SQL_CRUD.SELECT_ALL_LIST_PAYMENT_ID.getCRUD());
            preparedStatement.setInt(1, payment.getPhone());
            preparedStatement.setString(2, payment.getFirstname());
            preparedStatement.setString(3, payment.getLastname());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listAllPaymentId.add(new Payment(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7)));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            deregisterDriver();
        }
        for (Payment payment : listAllPaymentId) {
            System.out.println(payment.toString());
            if (payment.getStatus().contains(StatusPayment.STATUS_PAYMENT_ACTIVE.getStatus())) {
                paymentPay = payment;
            }
        }
        System.out.println(paymentPay.toString());
        return paymentPay;
    }

    @Override
    public void delete(Object id) {
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.DELETE_FROM_PAYMENT_CARD.getCRUD());
            preparedStatement.setInt(1, (Integer) id);
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
        System.out.println(flag);
    }

    @Override
    public Object update(Object object) {
        payment = (Payment) object;
        int flag = 0;
        try {
            connection = takeConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(SQL_CRUD.UPDATE_PAYMENT_PHONE_LASTNAME.getCRUD());
            preparedStatement.setLong(1, payment.getPhone());
            preparedStatement.setString(2, payment.getLastname());
            preparedStatement.setInt(3, payment.getId());
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
}
