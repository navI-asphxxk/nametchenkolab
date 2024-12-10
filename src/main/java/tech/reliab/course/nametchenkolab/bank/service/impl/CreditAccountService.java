package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface CreditAccountService {

     int getId();

     void setId(int id);

     int getIdUser();

     void setIdUser(int idUser);

     int getIdBank();

     void setIdBank(int idBank);

     String getLoanStartDate();

     void setLoanStartDate(String loanStartDate);

     String getLoanEndDate();

     void setLoanEndDate(String loanEndDate);

     int getLoanLongInMonths();

     void setLoanLongInMonths(int loanLongInMonths);

     int getCreditAmount();

     void setCreditAmount(int creditAmount);

     int getMonthlyPayment() ;

     void setMonthlyPayment(int monthlyPayment);

     int getInterestRate();

     void setInterestRate(int interestRate);

     int getIdEmployee();

     void setIdEmployee(int idEmployee);

     int getIdPaymentAccount();

     void setIdPaymentAccount(int idPaymentAccount);

     void printCreditAccount();
}
