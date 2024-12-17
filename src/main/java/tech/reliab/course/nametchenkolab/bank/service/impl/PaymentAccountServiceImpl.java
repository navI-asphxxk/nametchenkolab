package tech.reliab.course.nametchenkolab.bank.service.impl;

import tech.reliab.course.nametchenkolab.bank.entity.PaymentAccount;
import tech.reliab.course.nametchenkolab.bank.entity.User;
import tech.reliab.course.nametchenkolab.bank.service.PaymentAccountService;

import java.util.ArrayList;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    BankServiceImpl bankService;
    UserServiceImpl userService;

    public PaymentAccountServiceImpl(BankServiceImpl bankService, UserServiceImpl userService) {
        this.bankService = bankService;
        this.userService = userService;
    }

    @Override
    public PaymentAccount createPaymentAccount(int idUser, int idBank) {
        PaymentAccount paymentAccount = new PaymentAccount();
        int id = bankService.paymentAccounts.size();
        paymentAccount.setId(id);
        bankService.paymentAccounts.add(paymentAccount);

        paymentAccount.setIdBank(idBank);
        paymentAccount.setIdUser(idUser);
        User user = userService.givesUserById(idUser);
        if (!user.getArrayOfIdBanks().contains(idBank))
            userService.addBankOfListUser(user, idBank);
        this.addPaymentAccountToUser(idUser, id);

        return paymentAccount;
    }

    @Override
    public PaymentAccount createPaymentAccount(int idUser, int idBank, int sum) {
        PaymentAccount paymentAccount = this.createPaymentAccount(idUser, idBank);
        paymentAccount.setSum(sum);
        return paymentAccount;
    }

    @Override
    public void addPaymentAccountToUser(int idUser, int idPaymentAccount) {
        User user = userService.givesUserById(idUser);
        userService.addPaymentAccount(user, idPaymentAccount);
    }

    @Override
    public void deletePaymentAccount(int index) {
        bankService.paymentAccounts.remove(index);
    }

}
