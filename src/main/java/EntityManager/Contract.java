package EntityManager;

import java.sql.Timestamp;
import java.util.Objects;

public class Contract {

    private int id;
    private int phone;
    private String firstname;
    private String lastname;
    private int customer_id;
    private int address_id;
    private int payment_id;
    private int sum_order;
    private String payment_types;
    private Timestamp create_time;
    private Timestamp update_time;


    public Contract(int phone, String firstname, String lastname, int customer_id, int address_id,
                    int payment_id, String payment_types) {

        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.customer_id = customer_id;
        this.address_id = address_id;
        this.payment_id = payment_id;
        this.payment_types = payment_types;
    }

    public Contract(int id, int phone, String firstname, String lastname, int customer_id, int address_id, int payment_id,
                    int sum_order, String payment_types, Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.customer_id = customer_id;
        this.address_id = address_id;
        this.payment_id = payment_id;
        this.sum_order = sum_order;
        this.payment_types = payment_types;
        this.create_time = create_time;
        this.update_time = update_time;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getSum_order() {
        return sum_order;
    }

    public void setSum_order(int sum_order) {
        this.sum_order = sum_order;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getPayment_types() {
        return payment_types;
    }

    public void setPayment_types(String payment_types) {
        this.payment_types = payment_types;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Contract contract = (Contract) object;
        return id == contract.id && phone == contract.phone && customer_id == contract.customer_id && address_id == contract.address_id && payment_id == contract.payment_id && sum_order == contract.sum_order && Objects.equals(firstname, contract.firstname) && Objects.equals(lastname, contract.lastname) && Objects.equals(create_time, contract.create_time) && Objects.equals(update_time, contract.update_time) && Objects.equals(payment_types, contract.payment_types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone, firstname, lastname, customer_id, address_id, payment_id, sum_order, create_time, update_time, payment_types);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", phone=" + phone +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", customer_id=" + customer_id +
                ", address_id=" + address_id +
                ", payment_id=" + payment_id +
                ", sum_order=" + sum_order +
                ", payment_types='" + payment_types + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
