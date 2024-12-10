package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.AtmService;

//банкомат
public class BankAtm implements AtmService {
    private int id;
    private String name;
    private String address;
    private WorkStatus workStatus;
    private int idBank;
    private int idEmployee;
    private boolean isDispensingCash;
    private boolean canDepositAllowed;
    private int allMoney;
    private int atmMaintenanceCost;

    public BankAtm(int id, String name, String address, WorkStatus workStatus, int idBank, int idEmployee, boolean isDispensingCash, boolean canDepositAllowed, int allMoney, int atmMaintenanceCost) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.workStatus = workStatus;
        this.idBank = idBank;
        this.idEmployee = idEmployee;
        this.isDispensingCash = isDispensingCash;
        this.canDepositAllowed = canDepositAllowed;
        this.allMoney = allMoney;
        this.atmMaintenanceCost = atmMaintenanceCost;
        Bank.numberOfBankAtm++;
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
    public WorkStatus getWorkStatus() {
        return workStatus;
    }

    @Override
    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
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
    public int getIdEmployee() {
        return idEmployee;
    }

    @Override
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean isDispensingCash() {
        return isDispensingCash;
    }

    @Override
    public void setDispensingCash(boolean dispensingCash) {
        isDispensingCash = dispensingCash;
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
    public int getAtmMaintenanceCost() {
        return atmMaintenanceCost;
    }

    @Override
    public void setAtmMaintenanceCost(int atmMaintenanceCost) {
        this.atmMaintenanceCost = atmMaintenanceCost;
    }

    @Override
    public void printBankAtm() {
        System.out.println("Bank ATM" + name);
        System.out.println("id: " + id);
        System.out.println("address: " + address);
        System.out.println("work status: " + workStatus);
        System.out.println("id Bank: " + idBank);
        System.out.println("id employee: " + idEmployee);
        System.out.println("is dispensing cash: " + isDispensingCash);
        System.out.println("can deposit allowed: " + canDepositAllowed);
        System.out.println("total money in the bank ATM: " + allMoney);
        System.out.println("atm maintenance cost: " + atmMaintenanceCost);
        System.out.println();
    }
}


