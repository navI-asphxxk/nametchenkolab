package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface BankOfficeService {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    boolean isStatusOfJob();

    void setStatusOfJob(boolean statusOfJob);

    boolean isCanAtmPlacement();

    void setCanAtmPlacement(boolean canAtmPlacement);

    int getNumberOfAtm();

    void setNumberOfAtm(int numberOfAtm);

    boolean isCanGetLoan();

    void setCanGetLoan(boolean canGetLoan);

    boolean isCanTakeMoney();

    void setCanTakeMoney(boolean canTakeMoney);

    boolean isCanDepositAllowed();

    void setCanDepositAllowed(boolean canDepositAllowed);

    int getAllMoney();

    void setAllMoney(int allMoney);

    int getCostOfRent();

    void setCostOfRent(int costOfRent);

    void printBankAtm();
}
