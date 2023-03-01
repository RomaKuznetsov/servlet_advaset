import EntityManager.Address;
import EntityManager.Contract;
import EntityManager.Customer;
import EntityManager.Payment;
import Enums.CodeAddress;
import Enums.PaymentTypesContract;
import repository.AddressRepository;
import repository.ContractRepository;
import repository.CustomerRepository;
import repository.PaymentRepository;

public class Main {
    public static void main(String[] args) {
        CustomerRepository cr = new CustomerRepository();
        AddressRepository ar = new AddressRepository();
        PaymentRepository pr = new PaymentRepository();
        ContractRepository ccr = new ContractRepository();


//      CUSTOMER REPOSITORY
// нужен поиск return Object phone firstname lastname по username and mail
//        cr.create(new Customer(RoleCustomer.ROLE_CONFIRMATION_ADMINISTRATOR.getRole(), "Kuznetsov", "Roman", "mr.Proper", "mainkuznetso@gmail.com",
//                "password_Roman", 295781440, "1989-01-15 12:00:00.0", "male"));
//        cr.create(new Customer(RoleCustomer.ROLE_CONFIRMATION_MODERATOR.getRole(), "Kuznetsova", "Anastasiya", "mrs.Flox", "my6ecember@yahoo.com",
//                "password_Anastasiya", 295445501, "1988-12-23 12:00:00.0", "female"));
        //--------------
        cr.findAll();
//        //--------------
        cr.findCustomerUsernameMail(new Customer("mr.Proper", "mainkuznetso@gmail.com"));

//     ADDRESS REPOSITORY

//        ar.create(new Address(cr.findIdCustomer(new Customer("mr.Proper", "mainkuznetso@gmail.com")),
//                CodeAddress.CODE_ADDRESS_REGISTRATION.getCode(), "Belarus", "Mogilev", "Belynichy",
//                "Michurina", 12, "A", 10));
//        ar.create(new Address(cr.findIdCustomer(new Customer("mr.Proper", "mainkuznetso@gmail.com")),
//                CodeAddress.CODE_ADDRESS_DELIVERY.getCode(), "Belarus", "Mogilev", "Belynichy",
//                "Michurina", 12, "A", 10));
//        ar.create(new Address(cr.findIdCustomer(new Customer("mrs.Flox", "my6ecember@yahoo.com")),
//                CodeAddress.CODE_ADDRESS_REGISTRATION.getCode(),
//                "Belarus", "Mogilev", "Belynichy", "Michurina", 12, "A", 10));
//        ar.create(new Address(cr.findIdCustomer(new Customer("mrs.Flox", "my6ecember@yahoo.com")),
//                CodeAddress.CODE_ADDRESS_DELIVERY.getCode(),
//                "Belarus", "Mogilev", "Belynichy", "Michurina", 12, "A", 10));
//        //--------------
          ar.findAll();
//        //--------------!!!!!!
          ar.findAddressDelOrReg(new Address(cr.findCustomerUsernameMail(new Customer("mr.Proper", "mainkuznetso@gmail.com")).getId(), CodeAddress.CODE_ADDRESS_DELIVERY.getCode()));
          ar.findAddressDelOrReg(new Address(cr.findCustomerUsernameMail(new Customer("mr.Proper", "mainkuznetso@gmail.com")).getId(), CodeAddress.CODE_ADDRESS_REGISTRATION.getCode()));
//        //--------------находим список адресов по покупателю
//        ar.findOne(new Customer(100000).getId());

//        PAYMENT REPOSITORY

//          pr.create(new Payment(295781440, StatusPayment.STATUS_PAYMENT_ACTIVE.getStatus(),
//                  "Kuznetsov", "Roman", "5556517891414579", "2024-01-23"));
//          pr.create(new Payment(295781440, StatusPayment.STATUS_PAYMENT_INACTIVE.getStatus(),
//                  "Kuznetsov", "Roman", "5556517891414576", "2024-01-23"));
//
//          pr.create(new Payment(295445501, StatusPayment.STATUS_PAYMENT_ACTIVE.getStatus(),
//                  "Kuznetsova", "Anastasiya", "5556517891416789", "2025-01-23"));
//          pr.create(new Payment(295445501, StatusPayment.STATUS_PAYMENT_INACTIVE.getStatus(),
//                  "Kuznetsova", "Anastasiya", "5556517891418967", "2025-01-23"));
//        //--------------
          pr.findAll();
//        //--------------
          pr.findListIdPayment(new Payment(295781440, "Kuznetsov", "Roman"));
//        //--------------
          pr.findOne(new Payment(200001).getId());
//        //--------------
          pr.findOnePaymentPay(new Payment(295781440, "Kuznetsov", "Roman"));
        //--------------!! не находит совпадение по оплате
//        pr.delete(new Payment(200001).getId());
        //--------------
//        pr.update(new Payment(200002, 297778910, "Kuznetsova_"));

//      CONTRACT REPOSITORY
        // int phone, String firstname, String lastname, int customer_id, int address_id,
        //                    int payment_id, String payment_types
        ccr.create(new Contract(295781440, "Kuznetsov", "Roman",
                        (cr.findCustomerUsernameMail(new Customer("mr.Proper", "mainkuznetso@gmail.com"))).getId(),
                ar.findAddressDelOrReg(new Address(cr.findCustomerUsernameMail(new Customer("mr.Proper",
                        "mainkuznetso@gmail.com")).getId(), CodeAddress.CODE_ADDRESS_DELIVERY.getCode())).getId(),
                pr.findOnePaymentPay(new Payment(295781440, "Kuznetsov", "Roman")).getId(),
                        PaymentTypesContract.PAYMENT_TYPES_CONTRACT_CARD.getCode()));

//        ccr.create(new Contract(295781440, "Kuznetsov", "Roman", 100001, 150000, 200000, "cash"));

    }
}

