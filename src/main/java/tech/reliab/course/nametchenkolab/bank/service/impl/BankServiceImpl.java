package tech.reliab.course.nametchenkolab.bank.service.impl;

import tech.reliab.course.nametchenkolab.bank.entity.*;
import tech.reliab.course.nametchenkolab.bank.service.BankService;

import java.util.ArrayList;
import java.util.Random;

public class BankServiceImpl implements BankService {
    ArrayList<Bank> banks = new ArrayList<>();
    ArrayList<BankOffice> offices = new ArrayList<>();
    ArrayList<BankAtm> atms = new ArrayList<>();
    ArrayList<CreditAccount> creditAccounts = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<PaymentAccount> paymentAccounts = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    @Override
    public Bank createBank(String name) {
        Bank bank = new Bank();
        bank.setId(banks.size());
        banks.add(bank);
        bank.setName(name);
        int rating = givesRandomRating();
        bank.setRating(rating);
        bank.setAllMoney(givesRandomAllMoney());
        bank.setInterestRate(givesRandomInterestRate(rating));
        return bank;
    }

    @Override
    public void addOffice(Bank bank) {
        bank.setNumberOfOffice(bank.getNumberOfOffice() + 1);
    }

    @Override
    public void addATM(Bank bank) {
        bank.setNumberOfBankAtm(bank.getNumberOfBankAtm() + 1);
    }

    @Override
    public void addEmployee(Bank bank) {
        bank.setNumberOfEmployee(bank.getNumberOfEmployee() + 1);
    }

    @Override
    public void addUser(Bank bank) {
        bank.setNumberOfUser(bank.getNumberOfUser() + 1);
    }

    @Override
    public int givesRandomRating() {
        return new Random().nextInt(MAX_RATING + 1);
    }

    @Override
    public int givesRandomAllMoney() {
        return new Random().nextInt(MAX_ALL_MONEY + 1);
    }

    @Override
    public int givesRandomInterestRate(int rating) {
        return MAX_INTEREST_RATE - rating / 5;
    }


    @Override
    public void deleteBank(int index) {
        banks.remove(index);
    }

    @Override
    public Bank givesBankById(int id) {
        for (Bank bank : banks)
            if (bank.getId() == id)
                return bank;
        return null;
    }


    @Override
    public String toStringBanks() {
        String str = "BankServiceImpl{\n";
        int indexDelete = 0;
        for (Bank bank : banks) {
            str += "indexDelete = " + indexDelete++ + " ";
            str += bank.toString() + "\n";
        }
        str += '}';
        return str;
    }

    @Override
    public String toStringOffices(int idBank) {
        String str = "BankOfficeServiceImpl{\n";
        int indexDelete = 0;
        for (BankOffice office : offices) {
            if (office.getIdBank()==idBank) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += office.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }

    @Override
    public String toStringUsers(int idBank) {
        String str = "UserServiceImpl{\n";
        int indexDelete = 0;
        for (User user : users) {
           if (user.getArrayOfIdBanks().contains(idBank)) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += user.toString() + "\n";
           }
        }
        str += '}';
        return str;
    }

    @Override
    public String toStringEmployees(int idBank) {
        String str = "EmployeeServiceImpl{\n";
        int indexDelete = 0;
        for (Employee employee : employees) {
            if (employee.getIdBank()==idBank) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += employee.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }

    @Override
    public String toStringAtms(int idBank) {
        String str = "AtmServiceImpl{\n";
        int indexDelete = 0;
        for (BankAtm atm : atms) {
            if (atm.getIdBank()==idBank) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += atm.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }


    @Override
    public String toStringCreditAccount(int idUser) {
        String str = "CreditAccountServiceImpl{\n";
        int indexDelete = 0;
        for (CreditAccount creditAccount : creditAccounts) {
            if (creditAccount.getIdUser()==idUser) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += creditAccount.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }

    @Override
    public String toStringPaymentAccounts(int idUser) {
        String str = "PaymentAccountServiceImpl{\n";
        int indexDelete = 0;
        for (PaymentAccount paymentAccount : paymentAccounts) {
            if (paymentAccount.getIdUser()==idUser) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += paymentAccount.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }

    public  ArrayList<Integer> getIdEmployeeInBank(int idBank){
        ArrayList<Integer> employeeById = new ArrayList<>();
        for (var employee: employees)
            if (employee.getIdBank()==idBank)
                employeeById.add(employee.getId());

        return employeeById;
    }

    public  ArrayList<Integer> getIdEmployeeInOffice(int idOffice){
        ArrayList<Integer> employeeById = new ArrayList<>();
        for (var employee: employees)
            if (employee.getIdBankOffice()==idOffice)
                employeeById.add(employee.getId());

        return employeeById;
    }

    public ArrayList<BankOffice> getOffices() {
        return offices;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public ArrayList<BankAtm> getAtms() {
        return atms;
    }

    public ArrayList<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setOffices(ArrayList<BankOffice> offices) {
        this.offices = offices;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public void setAtms(ArrayList<BankAtm> atms) {
        this.atms = atms;
    }

    public void setCreditAccounts(ArrayList<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void setPaymentAccounts(ArrayList<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}