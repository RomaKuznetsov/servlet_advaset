package EntityManager;

import java.sql.Timestamp;
import java.util.Objects;

public class Customer {

    private int id;
    private String role;
    private String firstname;
    private String lastname;
    private String username;
    private String mail;
    private String password;
    private int phone;
    private String birthday;
    private String gender;
    private Timestamp create_time;
    private Timestamp update_time;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(String username, String mail) {
        this.username = username;
        this.mail = mail;
    }


    public Customer(String role, String firstname, String lastname, String username, String mail, String password,
                    int phone, String birthday, String gender) {
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Customer(int id, String role, String firstname, String lastname, String username,
                    String mail, String password, int phone, String birthday, String gender,
                    Timestamp create_time, Timestamp update_time) {
        this.id = id;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.create_time = create_time;
        this.update_time = update_time;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Customer customer = (Customer) object;
        return id == customer.id && phone == customer.phone && Objects.equals(role, customer.role) && Objects.equals(firstname, customer.firstname) && Objects.equals(lastname, customer.lastname) && Objects.equals(username, customer.username) && Objects.equals(mail, customer.mail) && Objects.equals(password, customer.password) && Objects.equals(birthday, customer.birthday) && Objects.equals(gender, customer.gender) && Objects.equals(create_time, customer.create_time) && Objects.equals(update_time, customer.update_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role, firstname, lastname, username, mail, password, phone, birthday, gender, create_time, update_time);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", phone=" + phone +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
