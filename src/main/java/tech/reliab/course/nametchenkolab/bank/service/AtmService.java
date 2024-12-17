package tech.reliab.course.nametchenkolab.bank.service;


import tech.reliab.course.nametchenkolab.bank.entity.BankAtm;
import tech.reliab.course.nametchenkolab.bank.entity.WorkStatus;



public interface AtmService {
    /* создание банкомата */
    public BankAtm createAtm(String name, WorkStatus workStatus, int idBank, int idOffice, int idEmployee,
                             boolean isDispensingCash, boolean canDepositAllowed, int atmMaintenanceCost);

    /* удаление банкомата */
    public void deleteAtm(int index);

    /* возвращается сумму денег в банкомате в зависимости от их количества в банке*/
    public int givesAllMoney(int moneyInBank);
}