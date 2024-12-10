package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.UserService;

import java.util.Arrays;

public class User implements UserService {
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String placeOfWork;
    private int salaryAmount;
    private int[] arrayOfIdBanks;
    private int[] arrayOfIdCreditAccounts;
    private int[] arrayOfIdPaymentAccounts;
    private int creditRatingForBank;


    public User(int id, String fullName, String dateOfBirth, String placeOfWork, int salaryAmount, int[] arrayOfIdBanks, int[] arrayOfIdCreditAccounts, int[] arrayOfIdPaymentAccounts, int creditRatingForBank) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfWork = placeOfWork;
        this.salaryAmount = salaryAmount;
        this.arrayOfIdBanks = arrayOfIdBanks;
        this.arrayOfIdCreditAccounts = arrayOfIdCreditAccounts;
        this.arrayOfIdPaymentAccounts = arrayOfIdPaymentAccounts;
        this.creditRatingForBank = creditRatingForBank;
        Bank.numberOfUser++;
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
    public String getPlaceOfWork() {
        return placeOfWork;
    }

    @Override
    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    @Override
    public int getSalaryAmount() {
        return salaryAmount;
    }

    @Override
    public void setSalaryAmount(int salaryAmount) {
        if (salaryAmount >= 0 && salaryAmount <= 10000)
            this.salaryAmount = salaryAmount;
        else
            System.out.println("Enter the salary amount from 0 to 20 inclusive");
    }

    @Override
    public int[] getArrayOfIdBanks() {
        return arrayOfIdBanks;
    }

    @Override
    public void setArrayOfIdBanks(int[] arrayOfIdBanks) {
        this.arrayOfIdBanks = arrayOfIdBanks;
    }

    @Override
    public int[] getArrayOfIdCreditAccounts() {
        return arrayOfIdCreditAccounts;
    }

    @Override
    public void setArrayOfIdCreditAccounts(int[] arrayOfIdCreditAccounts) {
        this.arrayOfIdCreditAccounts = arrayOfIdCreditAccounts;
    }

    @Override
    public int[] getArrayOfIdPaymentAccounts() {
        return arrayOfIdPaymentAccounts;
    }

    @Override
    public void setArrayOfIdPaymentAccounts(int[] arrayOfIdPaymentAccounts) {
        this.arrayOfIdPaymentAccounts = arrayOfIdPaymentAccounts;
    }

    @Override
    public int getCreditRatingForBank() {
        return creditRatingForBank;
    }

    @Override
    public void setCreditRatingForBank(int creditRatingForBank) {
        this.creditRatingForBank = creditRatingForBank;
    }

    @Override
    public void printUser() {
        System.out.println("User");
        System.out.println("id=" + id);
        System.out.println("full name=" + fullName);
        System.out.println("date of birth=" + dateOfBirth);
        System.out.println("place of work=" + placeOfWork);
        System.out.println("salary amount=" + salaryAmount);
        System.out.println("array of id banks=" + Arrays.toString(arrayOfIdBanks));
        System.out.println("array of id credit accounts=" + Arrays.toString(arrayOfIdCreditAccounts));
        System.out.println("array of id payment accounts=" + Arrays.toString(arrayOfIdPaymentAccounts));
        System.out.println("credit rating for bank=" + creditRatingForBank);
        System.out.println();
    }
}

