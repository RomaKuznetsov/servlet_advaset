package Enums;

public enum PaymentTypesContract {
    PAYMENT_TYPES_CONTRACT_CASH("cash"), PAYMENT_TYPES_CONTRACT_CARD("card");
    private String payment_types;

    PaymentTypesContract(String payment_types) {
        this.payment_types = payment_types;
    }

    public String getCode() {
        return payment_types;

    }
}
