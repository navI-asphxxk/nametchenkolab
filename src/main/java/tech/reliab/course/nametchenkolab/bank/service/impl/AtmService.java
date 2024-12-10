package tech.reliab.course.nametchenkolab.bank.service.impl;

import tech.reliab.course.nametchenkolab.bank.entity.BankAtm;

public interface AtmService {
    public enum WorkStatus {
        WORKS,
        NOT_WORKS,
        N0_MONEY
    }

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    WorkStatus getWorkStatus();

    void setWorkStatus(WorkStatus workStatus);

    int getIdBank();

    void setIdBank(int idBank);

    int getIdEmployee();

    void setIdEmployee(int idEmployee);

    boolean isDispensingCash();

    void setDispensingCash(boolean dispensingCash);

    boolean isCanDepositAllowed();

    void setCanDepositAllowed(boolean canDepositAllowed);

    int getAllMoney();

    void setAllMoney(int allMoney);

    int getAtmMaintenanceCost();

    void setAtmMaintenanceCost(int atmMaintenanceCost);

    void printBankAtm();
}