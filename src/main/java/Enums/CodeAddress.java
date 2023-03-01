package Enums;

public enum CodeAddress {
    CODE_ADDRESS_DELIVERY("Del"), CODE_ADDRESS_REGISTRATION("Reg");
    private String code;

    private CodeAddress(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;

    }
}
