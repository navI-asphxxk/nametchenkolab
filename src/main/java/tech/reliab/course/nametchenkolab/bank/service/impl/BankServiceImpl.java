package tech.reliab.course.nametchenkolab.bank.service.impl;

import lombok.Getter;
import lombok.Setter;
import tech.reliab.course.nametchenkolab.bank.entity.*;
import tech.reliab.course.nametchenkolab.bank.exceptions.*;
import tech.reliab.course.nametchenkolab.bank.service.BankService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

@Setter
@Getter
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
            if (office.getIdBank() == idBank) {
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
            if (employee.getIdBank() == idBank) {
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
            if (atm.getIdBank() == idBank) {
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
            if (creditAccount.getIdUser() == idUser) {
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
            if (paymentAccount.getIdUser() == idUser) {
                str += "indexDelete = " + indexDelete++ + " ";
                str += paymentAccount.toString() + "\n";
            }
        }
        str += '}';
        return str;
    }

    public ArrayList<Integer> getIdEmployeeInBank(int idBank) {
        ArrayList<Integer> employeeById = new ArrayList<>();
        for (var employee : employees)
            if (employee.getIdBank() == idBank)
                employeeById.add(employee.getId());

        return employeeById;
    }

    public ArrayList<Integer> getIdEmployeeInOffice(int idOffice) {
        ArrayList<Integer> employeeById = new ArrayList<>();
        for (var employee : employees)
            if (employee.getIdBankOffice() == idOffice)
                employeeById.add(employee.getId());

        return employeeById;
    }

    // Метод для получения сотрудников, которые принадлежат банку и офису
    private ArrayList<Employee> getEmployeesByBankAndOffice(int idOffice) {
        ArrayList<Employee> employeesByBankAndOffice = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getIdBankOffice() == idOffice) {
                employeesByBankAndOffice.add(employee);
            }
        }
        return employeesByBankAndOffice;
    }


    // Метод для расчета "веса" банка
    private int calculateBankWeight(Bank bank) {
        int atmCoefficient = 1;
        int employeeCoefficient = 1;
        int officeCoefficient = 1;
        int interestRateCoefficient = 10;

        int weight = (atmCoefficient * bank.getNumberOfBankAtm()) +
                (employeeCoefficient * bank.getNumberOfEmployee()) +
                (officeCoefficient * bank.getNumberOfOffice()) -    // вычитание, чтобы меньше - лучше
                (interestRateCoefficient * bank.getInterestRate()); // Влияние процентной ставки

        return weight;
    }

    // Метод выбора банка с учетом весов
    public Bank chooseBestWeightedBank(ArrayList<Bank> banks) throws BankNotFoundException {
        return banks.stream()
                .filter(bank -> bank.getNumberOfBankAtm() > 0 &&
                        bank.getNumberOfEmployee() > 0 &&
                        bank.getNumberOfOffice() > 0)
                .max(Comparator.comparingInt(this::calculateBankWeight))
                .orElseThrow(() -> new BankNotFoundException("Подходящий банк не найден"));
    }

    public ArrayList<BankOffice> getOfficeInBank(int idBank) {
        ArrayList<BankOffice> officeById = new ArrayList<>();
        for (var office : offices) {
            if (office.getIdBank() == idBank) {
                officeById.add(office);
            }
        }

        return officeById;
    }

    // Метод для выбора подходящего офиса банка
    public BankOffice chooseBankOffice(int idBank, int requestedCreditAmount) throws BankOfficeNotFoundException {
        ArrayList<BankOffice> bankOffices = getOfficeInBank(idBank);

        return bankOffices.stream()
                .filter(office -> office.isStatusOfJob() && office.isCanGetLoan() &&
                        office.getAllMoney() >= requestedCreditAmount)
                .findFirst()
                .orElseThrow(() -> new BankOfficeNotFoundException("Подходящий офис для выдачи кредита не найден"));
    }

    // Метод для выбора подходящего сотрудника
    public Employee chooseEmployee(int idOffice) throws EmployeeNotFoundException {
        ArrayList<Employee> employees = getEmployeesByBankAndOffice(idOffice);

        return employees.stream()
                .filter(Employee::isCanGiveLoan)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник, который может выдавать кредиты, не найден"));
    }

    // Функция для проверки кредитного рейтинга клиента и рейтинга банка
    public void checkLoanApproval(int idUser, Bank bank, UserServiceImpl userService) throws LoanApprovalException {
        User user = userService.givesUserById(idUser);
        if (user.getCreditRatingForBank() < 5000 && bank.getRating() > 50) {
            throw new LoanApprovalException("Кредит не может быть выдан: низкий кредитный рейтинг клиента");
        }
    }

    private ArrayList<BankAtm> getAtmsInOffice(int officeId, BankOfficeServiceImpl bankOfficeService) {
        ArrayList<BankAtm> atmsInOffice = new ArrayList<>();
        BankOffice office = bankOfficeService.givesOfficeById(officeId);
        String address = office.getAddress();
        for (var atm : atms) {
            if (atm.getAddress() == address) {
                atmsInOffice.add(atm);
            }
        }
        return atmsInOffice;
    }

    // Метод для проверки наличия нужной суммы в банкоматах офиса
    public BankAtm checkAtmsForLoan(int officeId, int requestedAmount, Bank bank, BankOfficeServiceImpl bankOfficeService) throws AtmNotEnoughMoneyException {
        ArrayList<BankAtm> atmsInOffice = getAtmsInOffice(officeId, bankOfficeService);

        return atmsInOffice.stream()
                .filter(atm -> atm.getAllMoney() >= requestedAmount)
                .findFirst()
                .orElseThrow(() -> new AtmNotEnoughMoneyException("Недостаточно средств в банкоматах этого офиса. Обратитесь в другой офис банка: " + bank.getName()));
    }

    public void issueLoan(int requestedCreditAmount, int idUser, BankServiceImpl bankService, BankOfficeServiceImpl officeService, UserServiceImpl userService) {
        try {
            Bank bestBank = bankService.chooseBestWeightedBank(bankService.getBanks());
            System.out.println("Выбран банк: " + bestBank.toString());

            int idBestBank = bestBank.getId();
            BankOffice chosenOffice = bankService.chooseBankOffice(idBestBank, requestedCreditAmount);
            System.out.println("Выбран офис: " + chosenOffice.toString());

            int idChosenOffice = chosenOffice.getId();
            Employee chosenEmployee = bankService.chooseEmployee(idChosenOffice);
            System.out.println("Выбран сотрудник: " + chosenEmployee.toString());

            bankService.checkLoanApproval(idUser, bestBank, userService);
            System.out.println("Кредит может быть выдан");

            BankAtm chosenAtm = bankService.checkAtmsForLoan(chosenOffice.getId(), requestedCreditAmount, bestBank, officeService);
            System.out.println("Кредит будет выдан через банкомат с названием: " + chosenAtm.getName() + " по адресу " +
                    chosenAtm.getAddress());
        } catch (BankNotFoundException | BankOfficeNotFoundException | EmployeeNotFoundException |
                 LoanApprovalException | AtmNotEnoughMoneyException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}