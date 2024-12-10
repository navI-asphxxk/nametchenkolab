package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.EmployeeService;

public class Employee implements EmployeeService {
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String position;
    private int idBank;
    private boolean isOfficeJob;
    private int idBankOffice;
    private boolean canGiveLoan;
    private int salaryAmount;

    public Employee(int id, String fullName, String dateOfBirth, String position, int idBank, boolean isOfficeJob, int idBankOffice, boolean canGiveLoan, int salaryAmount) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.idBank = idBank;
        this.isOfficeJob = isOfficeJob;
        this.idBankOffice = idBankOffice;
        this.canGiveLoan = canGiveLoan;
        this.salaryAmount = salaryAmount;
        Bank.numberOfEmployee++;
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
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
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
    public boolean isOfficeJob() {
        return isOfficeJob;
    }

    @Override
    public void setOfficeJob(boolean officeJob) {
        isOfficeJob = officeJob;
    }

    @Override
    public int getIdBankOffice() {
        return idBankOffice;
    }

    @Override
    public void setIdBankOffice(int idBankOffice) {
        this.idBankOffice = idBankOffice;
    }

    @Override
    public boolean isCanGiveLoan() {
        return canGiveLoan;
    }

    @Override
    public void setCanGiveLoan(boolean canGiveLoan) {
        this.canGiveLoan = canGiveLoan;
    }

    @Override
    public int getSalaryAmount() {
        return salaryAmount;
    }

    @Override
    public void setSalaryAmount(int salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
    public void printEmployee() {
        System.out.println("Employee ");
        System.out.println("id=" + id);
        System.out.println("fullName='" + fullName + '\'');
        System.out.println("dateOfBirth='" + dateOfBirth + '\'');
        System.out.println("position='" + position + '\'');
        System.out.println("idBank=" + idBank);
        System.out.println("isOfficeJob=" + isOfficeJob);
        System.out.println("idBankOffice=" + idBankOffice);
        System.out.println("canGiveLoan=" + canGiveLoan);
        System.out.println("salaryAmount=" + salaryAmount);
        System.out.println();
    }

}



