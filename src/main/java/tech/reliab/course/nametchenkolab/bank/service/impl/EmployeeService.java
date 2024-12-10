package tech.reliab.course.nametchenkolab.bank.service.impl;

public interface EmployeeService {
    int getId();

    void setId(int id);

    String getFullName();

    void setFullName(String fullName);

    String getDateOfBirth();

    void setDateOfBirth(String dateOfBirth);

    String getPosition();

    void setPosition(String position);

    int getIdBank();

    void setIdBank(int idBank);

    boolean isOfficeJob();

    void setOfficeJob(boolean officeJob);

    int getIdBankOffice();

    void setIdBankOffice(int idBankOffice);

    boolean isCanGiveLoan();

    void setCanGiveLoan(boolean canGiveLoan);

    int getSalaryAmount();

    void setSalaryAmount(int salaryAmount);

    void printEmployee();
}
