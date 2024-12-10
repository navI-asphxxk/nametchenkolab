package tech.reliab.course.nametchenkolab.bank.entity;

import tech.reliab.course.nametchenkolab.bank.service.impl.CreditAccountService;

public class CreditAccount implements CreditAccountService {
    private int id;
    private int idUser;
    private int idBank;
    private String loanStartDate;
    private String loanEndDate;
    private int loanLongInMonths;
    private int creditAmount;
    private int monthlyPayment;
    private int interestRate;
    private int idEmployee;
    private int idPaymentAccount;

    public CreditAccount(int id, int idUser, int idBank, String loanStartDate, String loanEndDate, int loanLongInMonths, int creditAmount, int monthlyPayment, int interestRate, int idEmployee, int idPaymentAccount) {
        this.id = id;
        this.idUser = idUser;
        this.idBank = idBank;
        this.loanStartDate = loanStartDate;
        this.loanEndDate = loanEndDate;
        this.loanLongInMonths = loanLongInMonths;
        this.creditAmount = creditAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.idEmployee = idEmployee;
        this.idPaymentAccount = idPaymentAccount;
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
    public String getLoanStartDate() {
        return loanStartDate;
    }

    @Override
    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    @Override
    public String getLoanEndDate() {
        return loanEndDate;
    }

    @Override
    public void setLoanEndDate(String loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    @Override
    public int getLoanLongInMonths() {
        return loanLongInMonths;
    }

    @Override
    public void setLoanLongInMonths(int loanLongInMonths) {
        this.loanLongInMonths = loanLongInMonths;
    }

    @Override
    public int getCreditAmount() {
        return creditAmount;
    }

    @Override
    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Override
    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public int getInterestRate() {
        return interestRate;
    }

    @Override
    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
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
    public int getIdPaymentAccount() {
        return idPaymentAccount;
    }

    @Override
    public void setIdPaymentAccount(int idPaymentAccount) {
        this.idPaymentAccount = idPaymentAccount;
    }

    @Override
    public void printCreditAccount() {
        System.out.println("CreditAccount");
        System.out.println("id=" + id);
        System.out.println("idUser=" + idUser);
        System.out.println("idBank=" + idBank);
        System.out.println("loanStartDate='" + loanStartDate + '\'');
        System.out.println("loanEndDate='" + loanEndDate + '\'');
        System.out.println("loanLongInMonths=" + loanLongInMonths);
        System.out.println("creditAmount=" + creditAmount);
        System.out.println("monthlyPayment=" + monthlyPayment);
        System.out.println("interestRate=" + interestRate);
        System.out.println("idEmployee=" + idEmployee);
        System.out.println("idPaymentAccount=" + idPaymentAccount);
        System.out.println();
    }
}
