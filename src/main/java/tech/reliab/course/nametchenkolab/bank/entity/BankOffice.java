package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.BankOfficeService;

public class BankOffice implements BankOfficeService {
    private int id;
    private String name;
    private String address;
    private boolean isStatusOfJob;
    private boolean canAtmPlacement;
    private int numberOfAtm;
    private boolean canGetLoan;
    private boolean canTakeMoney;
    private boolean canDepositAllowed;
    private int allMoney;
    private int costOfRent;

    public BankOffice(int id, String name, String address, boolean isStatusOfJob, boolean canAtmPlacement, int numberOfAtm, boolean canGetLoan, boolean canTakeMoney, boolean canDepositAllowed, int allMoney, int costOfRent) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.isStatusOfJob = isStatusOfJob;
        this.canAtmPlacement = canAtmPlacement;
        this.numberOfAtm = numberOfAtm;
        this.canGetLoan = canGetLoan;
        this.canTakeMoney = canTakeMoney;
        this.canDepositAllowed = canDepositAllowed;
        this.allMoney = allMoney;
        this.costOfRent = costOfRent;
        Bank.numberOfOffice++;
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean isStatusOfJob() {
        return isStatusOfJob;
    }

    @Override
    public void setStatusOfJob(boolean statusOfJob) {
        isStatusOfJob = statusOfJob;
    }

    @Override
    public boolean isCanAtmPlacement() {
        return canAtmPlacement;
    }

    @Override
    public void setCanAtmPlacement(boolean canAtmPlacement) {
        this.canAtmPlacement = canAtmPlacement;
    }

    @Override
    public int getNumberOfAtm() {
        return numberOfAtm;
    }

    @Override
    public void setNumberOfAtm(int numberOfAtm) {
        this.numberOfAtm = numberOfAtm;
    }

    @Override
    public boolean isCanGetLoan() {
        return canGetLoan;
    }

    @Override
    public void setCanGetLoan(boolean canGetLoan) {
        this.canGetLoan = canGetLoan;
    }

    @Override
    public boolean isCanTakeMoney() {
        return canTakeMoney;
    }

    @Override
    public void setCanTakeMoney(boolean canTakeMoney) {
        this.canTakeMoney = canTakeMoney;
    }

    @Override
    public boolean isCanDepositAllowed() {
        return canDepositAllowed;
    }

    @Override
    public void setCanDepositAllowed(boolean canDepositAllowed) {
        this.canDepositAllowed = canDepositAllowed;
    }

    @Override
    public int getAllMoney() {
        return allMoney;
    }

    @Override
    public void setAllMoney(int allMoney) {
        this.allMoney = allMoney;
    }

    @Override
    public int getCostOfRent() {
        return costOfRent;
    }

    @Override
    public void setCostOfRent(int costOfRent) {
        this.costOfRent = costOfRent;
    }

    @Override
    public void printBankAtm() {
        System.out.println("Bank office " + name);
        System.out.println("id: " + id);
        System.out.println("address: " + address);
        System.out.println("is status of job: " + isStatusOfJob);
        System.out.println("can Atm placement: " + canAtmPlacement);
        System.out.println("number of Atm: " + numberOfAtm);
        System.out.println("can get loan: " + canGetLoan);
        System.out.println("can take money: " + canTakeMoney);
        System.out.println("can deposit allowed: " + canDepositAllowed);
        System.out.println("total money in the bank office: " + allMoney);
        System.out.println("cost of rent: " + costOfRent);
        System.out.println();
    }
}
