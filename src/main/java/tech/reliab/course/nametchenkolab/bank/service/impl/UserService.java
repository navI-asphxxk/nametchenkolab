package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface UserService {
    int getId();

    void setId(int id);

    String getFullName();

    void setFullName(String fullName);

    String getDateOfBirth();

    void setDateOfBirth(String dateOfBirth);

    String getPlaceOfWork();

    void setPlaceOfWork(String placeOfWork);

    int getSalaryAmount();

    void setSalaryAmount(int salaryAmount);

    int[] getArrayOfIdBanks();

    void setArrayOfIdBanks(int[] arrayOfIdBanks);

    int[] getArrayOfIdCreditAccounts();

    void setArrayOfIdCreditAccounts(int[] arrayOfIdCreditAccounts);

    int[] getArrayOfIdPaymentAccounts();

    void setArrayOfIdPaymentAccounts(int[] arrayOfIdPaymentAccounts);

    int getCreditRatingForBank();

    void setCreditRatingForBank(int creditRatingForBank);

    void printUser();
}
