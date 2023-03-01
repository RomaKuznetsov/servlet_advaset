package EntityManager;


import java.util.Objects;

public class Payment {
    private int id;
    private String status;
    private int phone;
    private String firstname;
    private String lastname;
    private String card;
    private String validity;

    public Payment(int id) {
        this.id = id;
    }
    public Payment(int id, int phone, String lastname) {
        this.id = id;
        this.phone = phone;
        this.lastname = lastname;
    }

    public Payment(int phone, String firstname, String lastname) {
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Payment(int phone, String status, String firstname, String lastname) {
        this.phone = phone;
        this.status = status;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Payment(int phone, String status, String firstname, String lastname, String card, String validity) {
        this.phone = phone;
        this.status = status;
        this.firstname = firstname;
        this.lastname = lastname;
        this.card = card;
        this.validity = validity;
    }

    public Payment(int id, String status, int phone, String firstname, String lastname, String card, String validity) {
        this.id = id;
        this.status = status;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.card = card;
        this.validity = validity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Payment payment = (Payment) object;
        return id == payment.id && phone == payment.phone && Objects.equals(status, payment.status) && Objects.equals(firstname, payment.firstname) && Objects.equals(lastname, payment.lastname) && Objects.equals(card, payment.card) && Objects.equals(validity, payment.validity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, phone, firstname, lastname, card, validity);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", phone=" + phone +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", card='" + card + '\'' +
                ", validity='" + validity + '\'' +
                '}';
    }
}
