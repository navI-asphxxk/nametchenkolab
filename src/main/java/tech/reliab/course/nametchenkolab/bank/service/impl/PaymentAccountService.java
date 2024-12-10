package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface PaymentAccountService {
    int getId();

    void setId(int id);

    int getIdUser();

    void setIdUser(int idUser);

    int getIdBank();

    void setIdBank(int idBank);

    int getSum();

    void setSum(int sum);

    void printPaymentAccount();
}
