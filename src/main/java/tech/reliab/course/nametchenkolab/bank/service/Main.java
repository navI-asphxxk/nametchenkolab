package tech.reliab.course.nametchenkolab.bank.service;

import tech.reliab.course.nametchenkolab.bank.entity.*;
import tech.reliab.course.nametchenkolab.bank.service.impl.AtmService;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank(0, "bank1", 56, 6765578, 6);
        bank1.printBank();

        BankOffice office1 = new BankOffice(0, "office1", "street rose 51", true, true, 2, true, true, true, 456655, 10000);
        office1.printBankAtm();

        Employee employee1 = new Employee(0, "Ivanov Ivan Ivanovich", "19-02-1987", "Service specialist", 0, true, 0, false, 4000);
        employee1.printEmployee();

        CreditAccount creditAccount = new CreditAccount(0, 0, 0, "23-06-1999", "23-06-2024", 25 * 12, 999999, 7900, 15, 0, 0);
        creditAccount.printCreditAccount();

        BankAtm atm = new BankAtm(0, "atm1", "street rose 51", AtmService.WorkStatus.NOT_WORKS, 0, 0, false, false, 565656, 5600);
        atm.setWorkStatus(AtmService.WorkStatus.WORKS);

        User user = new User(0, "Ivanov Ivan Ivanovich", "19-08-1997", "bank89", 7600, null, null, null, 30);
        user.printUser();

        PaymentAccount paymentAccount = new PaymentAccount(0, 0, 0, 56);
        paymentAccount.printPaymentAccount();
    }
}

