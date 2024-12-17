package tech.reliab.course.nametchenkolab.bank.utils;

import tech.reliab.course.nametchenkolab.bank.entity.WorkStatus;
import tech.reliab.course.nametchenkolab.bank.service.impl.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class CreateRandomObjects {
    private BankServiceImpl bankService = new BankServiceImpl();
    private BankOfficeServiceImpl officeService = new BankOfficeServiceImpl(bankService);
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl(bankService);
    private AtmServiceImpl atmService = new AtmServiceImpl(bankService, officeService);
    private UserServiceImpl userService = new UserServiceImpl(bankService);
    private PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl(bankService, userService);
    private CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl(bankService, userService);

    public void createBanks(int numberOfBanks) {
        for (int i = 0; i < numberOfBanks; i++)
            bankService.createBank("bank" + i);
    }

    public void createOffices(int numberOfBanks, int numberOfOffices) {
        for (int i = 0; i < numberOfBanks; i++)
            for (int j = 0; j < numberOfOffices; j++) {
                officeService.createOffice("office" + i + j, "Trimwor" + j + +i, i, randomTrueOrFalse(),
                        randomTrueOrFalse(), randomTrueOrFalse(), randomTrueOrFalse(), randomTrueOrFalse(),
                        generateRandomIntRange(5000, 8000));
            }
    }

    public void createEmployees(int numberOfEmployees) {
        for (var office : bankService.getOffices()) {
            int idBank = office.getIdBank();
            int idOffice = office.getId();
            for (int i = 0; i < numberOfEmployees; i++)
                employeeService.createEmployee(generateFio(), generateRandomDate("01-01-1950", "01-01-2006"),
                        "Service specialist", idBank, randomTrueOrFalse(), idOffice, randomTrueOrFalse(),
                        generateRandomIntRange(5000,10000));
        }
    }

    public void createAtm(int numberOfAtms) {
        for (var office:bankService.getOffices()){
            int idBank = office.getIdBank();
            int idOffice = office.getId();
            ArrayList<Integer> idEmployees = bankService.getIdEmployeeInOffice(idBank);
            for (int i = 0; i < numberOfAtms; i++) {
                int idEmployee = getRandomEmployee(idEmployees);
                atmService.createAtm("A-"+idBank+idEmployee, WorkStatus.WORKS, idBank, idOffice, idEmployee, randomTrueOrFalse(),
                        randomTrueOrFalse(), generateRandomIntRange(1000,3000));
            }
        }
    }

    public void createUsers(int numberOfUsers) {
        for (var bank : bankService.getBanks()) {
            int idBank = bank.getId();
            ArrayList<Integer> arrayIdBank = new ArrayList<>();
            arrayIdBank.add(idBank);
            for (int i = 0; i < numberOfUsers; i++)
                userService.createUser(generateFio(), generateRandomDate("01-01-1924", "01-01-2014"), "Service specialist",
                        arrayIdBank);
        }

    }

    public void createPaymentAccount(int numberOfPaymentAccount) {
        for (var user:bankService.getUsers()){
            int idUser = user.getId();
            int idBank = user.getArrayOfIdBanks().get(0);
            for (int i = 0; i < numberOfPaymentAccount; i++)
                paymentAccountService.createPaymentAccount(idUser, idBank);
        }
    }

    public void createCreditAccount(int numberOfCreditAccount) {
        for (var user:bankService.getUsers()){
            int idUser = user.getId();
            int idBank = user.getArrayOfIdBanks().get(0);
            int idPaymentAccount = user.getArrayOfIdPaymentAccounts().get(0);
            var random = new Random();
            for (int i = 0; i < numberOfCreditAccount; i++) {
                String startDate =generateRandomDate("01-01-2024", "01-01-2074");
                String endDate = generateRandomDate("01-09-2024", "01-01-2074");
                ArrayList<Integer> idEmployees = bankService.getIdEmployeeInBank(idBank);
                var idEmployee = idEmployees.get(random.nextInt(idEmployees.size()));
                creditAccountService.createCreditAccount(idUser, idBank,parseStringToLocalDate(startDate) ,
                        parseStringToLocalDate(endDate), generateRandomIntRange(1000,10000),
                        idEmployee, idPaymentAccount);
            }
        }
    }

    public void printBanks() {
        System.out.println(bankService.toStringBanks());
    }

    public void printOffices(int idBank) {
        System.out.println(bankService.toStringOffices(idBank));
    }

    public void printAtms(int idBank) {
        System.out.println(bankService.toStringAtms(idBank));
    }

    public void printEmployees(int idBank) {
        System.out.println(bankService.toStringEmployees(idBank));
    }

    public void printUsers(int idBank) {
        System.out.println(bankService.toStringUsers(idBank));
    }

    public void printPaymentAccounts(int idUser) {
        System.out.println(bankService.toStringPaymentAccounts(idUser));
    }

    public void printCreditAccount(int idUser) {
        System.out.println(bankService.toStringCreditAccount(idUser));
    }




    public boolean randomTrueOrFalse() {
        return Math.random() < 0.5;
    }

    public int generateRandomIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public String generateFio() {
        ArrayList<String> FIRST_NAMES_MALE = new ArrayList<>();
        ArrayList<String> FIRST_NAMES_FEMALE = new ArrayList<>();
        ArrayList<String> LAST_NAMES = new ArrayList<>();
        ArrayList<String> PATRONYMICS = new ArrayList<>();

        FIRST_NAMES_MALE.add("John");
        FIRST_NAMES_MALE.add("David");
        FIRST_NAMES_MALE.add("Michael");

        FIRST_NAMES_FEMALE.add("Mary");
        FIRST_NAMES_FEMALE.add("Patricia");
        FIRST_NAMES_FEMALE.add("Linda");

        LAST_NAMES.add("Smith");
        LAST_NAMES.add("Jones");
        LAST_NAMES.add("Brown");

        PATRONYMICS.add("Williamson");
        PATRONYMICS.add("Anderson");
        PATRONYMICS.add("Thompson");

        Random random = new Random();
        boolean isMale = random.nextBoolean();
        String firstName = isMale ? FIRST_NAMES_MALE.get(random.nextInt(FIRST_NAMES_MALE.size())) : FIRST_NAMES_FEMALE.get(random.nextInt(FIRST_NAMES_FEMALE.size()));
        String lastName = LAST_NAMES.get(random.nextInt(LAST_NAMES.size()));
        String patronymic = PATRONYMICS.get(random.nextInt(PATRONYMICS.size()));

        return lastName + " " + firstName + " " + patronymic;
    }

    public String generateRandomDate(String startDate, String endDate) {
        // Форматтер для даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Преобразуем строки в даты
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        // Создаем рандомное число между двумя датами
        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();
        long randomDay = startEpochDay + new Random().nextLong() % (endEpochDay - startEpochDay + 1);

        // Создаем случайную дату
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        // Возвращаем дату в заданном формате
        return randomDate.format(formatter);
    }

    public LocalDate parseStringToLocalDate(String str){
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int getRandomEmployee(ArrayList<Integer> idEmployees){
        var random = new Random();
        return idEmployees.get(random.nextInt(idEmployees.size()));
    }

}

