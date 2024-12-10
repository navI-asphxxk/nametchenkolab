package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.BankService;

public class Bank implements BankService {
    private int id;
    private String name;
    static int numberOfOffice = 0;
    static int numberOfBankAtm = 0;
    static int numberOfEmployee = 0;
    static int numberOfUser = 0;
    private int rating;
    private int allMoney;
    private int interestRate;

    public Bank(int id, String name, int rating, int allMoney, int interestRate) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.allMoney = allMoney;
        this.interestRate = interestRate;
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

    static int getNumberOfOffice() {
        return numberOfOffice;
    }

    public static void setNumberOfOffice(int numberOfOffice) {
        Bank.numberOfOffice = numberOfOffice;
    }

    public static int getNumberOfBankAtm() {
        return numberOfBankAtm;
    }

    public static void setNumberOfBankAtm(int numberOfBankAtm) {
        Bank.numberOfBankAtm = numberOfBankAtm;
    }

    public static int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public static void setNumberOfEmployee(int numberOfEmployee) {
        Bank.numberOfEmployee = numberOfEmployee;
    }

    public static int getNumberOfUser() {
        return numberOfUser;
    }

    public static void setNumberOfUser(int numberOfUser) {
        Bank.numberOfUser = numberOfUser;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setRating(int rating) {
        if (rating >= 0 && rating <= 100)
            this.rating = rating;
        else
            System.out.println("Enter a rating from 0 to 100 inclusive");
    }

    @Override
    public int getAllMoney() {
        return allMoney;
    }

    @Override
    public void setAllMoney(int allMoney) {
        if (allMoney >= 0 && allMoney <= 1000000)
            this.allMoney = allMoney;
        else
            System.out.println("Enter a amount of money from 0 to 100 inclusive");
    }

    @Override
    public int getInterestRate() {
        return interestRate;
    }

    @Override
    public void setInterestRate(int interestRate) {
        if (interestRate >= 0 && interestRate <= 20)
            this.interestRate = interestRate;
        else
            System.out.println("Enter the interest rate from 0 to 20 inclusive without indicating the sign %");
    }

    @Override
    public void printBank() {
        System.out.println("Bank " + name);
        System.out.println("id: " + id);
        System.out.println("number of office: " + numberOfOffice);
        System.out.println("number of bankAtm: " + numberOfBankAtm);
        System.out.println("number of employee: " + numberOfEmployee);
        System.out.println("number of user: " + numberOfUser);
        System.out.println("rating: " + rating);
        System.out.println("total money in the bank: " + allMoney);
        System.out.println("interest rate: " + interestRate);
        System.out.println();
    }

}
