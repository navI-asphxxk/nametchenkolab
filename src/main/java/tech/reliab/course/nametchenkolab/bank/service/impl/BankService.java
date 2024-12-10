package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface BankService {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    int getRating();

    void setRating(int rating);

    int getAllMoney();

    void setAllMoney(int allMoney);

    int getInterestRate();

    void setInterestRate(int interestRate);

    void printBank();
}