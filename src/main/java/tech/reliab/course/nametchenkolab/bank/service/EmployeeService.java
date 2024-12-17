package tech.reliab.course.nametchenkolab.bank.service;

import tech.reliab.course.nametchenkolab.bank.entity.Bank;
import tech.reliab.course.nametchenkolab.bank.entity.Employee;
import tech.reliab.course.nametchenkolab.bank.service.impl.BankServiceImpl;

public interface EmployeeService {
    /* создание сотрудника*/
    public Employee createEmployee(String fullName, String dateOfBirth, String position, int idBank,
                                   boolean isOfficeJob, int idBankOffice, boolean canGiveLoan, int salaryAmount);

    /* удаление сотрудника*/
    public void deleteEmployee(int index);

}
