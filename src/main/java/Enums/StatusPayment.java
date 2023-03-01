package Enums;

public enum StatusPayment {

    STATUS_PAYMENT_ACTIVE("ACT"), STATUS_PAYMENT_INACTIVE("PAS");

    private String status;

    private StatusPayment(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;

    }
}
