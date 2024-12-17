package tech.reliab.course.nametchenkolab.bank.service;

import tech.reliab.course.nametchenkolab.bank.entity.BankOffice;
import tech.reliab.course.nametchenkolab.bank.service.impl.BankServiceImpl;


public interface BankOfficeService {
    /* создание офиса */
    public BankOffice createOffice(String name, String address, int idBank, boolean isStatusOfJob,
                                   boolean canAtmPlacement, boolean canGetLoan, boolean canTakeMoney,
                                   boolean canDepositAllowed, int costOfRent );

    /* увеличивает количество банковских автоматов на 1 в офисе*/
    public void addAtm(BankOffice office);

    /* возвращает офис по id*/
    public BankOffice givesOfficeById(int id);

    /* возвращается сумму денег в офисе в зависимости от их количества в банке*/
    public int givesAllMoney(int moneyInBank);

    /* удаление офиса */
    public void deleteOfOffice(int index);
}
