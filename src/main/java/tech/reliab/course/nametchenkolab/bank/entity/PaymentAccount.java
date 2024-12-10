package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.PaymentAccountService;

public class PaymentAccount implements PaymentAccountService {
    private int id; //Id платёжного счета
    private int idUser; //Пользователь, за которым закреплен этот платежный счет
    private int idBank; //Название банка, в котором открыт этот счет
    private int sum;    //Сумма, которая лежит в данный момент на счету (по умолчанию 0)

    public PaymentAccount(int id, int idUser, int idBank, int sum) {
        this.id = id;
        this.idUser = idUser;
        this.idBank = idBank;
        this.sum = sum;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getIdUser() {
        return idUser;
    }

    @Override
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int getIdBank() {
        return idBank;
    }

    @Override
    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public void printPaymentAccount() {
        System.out.println("PaymentAccount");
        System.out.println("id=" + id);
        System.out.println("idUser=" + idUser);
        System.out.println("idBank=" + idBank);
        System.out.println("sum=" + sum);
        System.out.println();
    }
}
