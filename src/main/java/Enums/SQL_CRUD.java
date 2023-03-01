package Enums;

public enum SQL_CRUD {

//CUSTOMER

    INSERT_INTO_CUSTOMER("INSERT INTO Customer (role, firstname, lastname, username, mail, password, phone, birthday, " +
            "gender, create_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"),
    SELECT_ID_CUSTOMER("SELECT id FROM Customer WHERE username = ? AND mail = ?;"),
    SELECT_ALL_FROM_CUSTOMER("SELECT * FROM Customer;"),
    SELECT_ALL_FROM_CUSTOMER_ID("SELECT * FROM Customer WHERE id = ?;"),
    SELECT_ALL_FROM_CUSTOMER_USERNAME_MAIL("SELECT * FROM Customer WHERE username = ? AND mail = ?;"),


//ADDRESS


    INSERT_INTO_ADDRESS("INSERT INTO Address (customer_id, code, country, region, city, street, house, frame, apartment) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? );"),
    SELECT_ALL_ADDRESS_REG_OR_DEL("SELECT * FROM Address WHERE customer_id = ? AND code = ?;"),
    SELECT_ALL_FROM_ADDRESS("SELECT * FROM Address;"),
    SELECT_ALL_FROM_ADDRESS_CUSTOMER_ID("SELECT * FROM Address WHERE customer_id = ?;"),


//PAYMENT


    INSERT_INTO_PAYMENT("INSERT INTO Payment (phone, status, firstname, lastname, card, validity) VALUES (?, ?, ?, ?, ?, ?);"),
    SELECT_ALL_FROM_PAYMENT("SELECT * FROM Payment;"),
    SELECT_ALL_LIST_PAYMENT_ID("SELECT * FROM Payment WHERE phone = ? AND firstname = ? AND lastname = ?;"),
    SELECT_ALL_FROM_PAYMENT_CARD("SELECT * FROM Payment WHERE id = ?;"),
    SELECT_ID_FROM_PAYMENT("SELECT id FROM Payment WHERE phone = ? AND status = ? AND firstname = ? AND lastname = ?;"),
    DELETE_FROM_PAYMENT_CARD("DELETE FROM Payment WHERE id = ?;"),
    UPDATE_PAYMENT_PHONE_LASTNAME("UPDATE Payment SET phone = ?, lastname = ? WHERE id = ?;"),


//CONTRACT

INSERT_INTO_CONTRACT("INSERT INTO Contract (phone, firstname, lastname, customer_id, address_id, payment_id, payment_types, " +
        "create_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?);")

    ;



    private String CRUD;

    SQL_CRUD(String CRUD) {
        this.CRUD = CRUD;
    }

    public String getCRUD() {
        return CRUD;
    }
    }
