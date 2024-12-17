package tech.reliab.course.nametchenkolab.bank;

import tech.reliab.course.nametchenkolab.bank.entity.*;
import tech.reliab.course.nametchenkolab.bank.exceptions.*;
import tech.reliab.course.nametchenkolab.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.nametchenkolab.bank.service.impl.BankServiceImpl;
import tech.reliab.course.nametchenkolab.bank.service.impl.UserServiceImpl;
import tech.reliab.course.nametchenkolab.bank.utils.CreateRandomObjects;


public class Main {
    public static void main(String[] args) {
        int numberOfBanks = 5;
        int numberOfAtms = 1;
        int numberOfOffices = 3;
        int numberOfEmployees = 5;
        int numberOfUsers = 5;
        int numberOfCreditAccounts = 2;
        int numberOfPaymentAccounts = 2;

        CreateRandomObjects randomObjects = new CreateRandomObjects();
        randomObjects.createBanks(numberOfBanks);
        randomObjects.createOffices(numberOfBanks, numberOfOffices);
        randomObjects.createEmployees(numberOfEmployees);
        randomObjects.createAtm(numberOfAtms);
        randomObjects.createUsers(numberOfUsers);
        randomObjects.createPaymentAccount(numberOfPaymentAccounts);
        randomObjects.createCreditAccount(numberOfCreditAccounts);

        /*
        вывод некоторой инфы по созданным банкам
        randomObjects.printBanks();
        randomObjects.printOffices(0);
        randomObjects.printEmployees(0);
        randomObjects.printAtms(0);
        randomObjects.printUsers(0);
        randomObjects.printPaymentAccounts(0);
        randomObjects.printCreditAccount(0);
         */

        // 3 lab
        int requestedCreditAmount = 500;
        int idUser = 0;
        BankServiceImpl bankService = randomObjects.getBankService();
        BankOfficeServiceImpl officeService = randomObjects.getOfficeService();
        UserServiceImpl userService = randomObjects.getUserService();

        bankService.issueLoan(requestedCreditAmount, idUser, bankService, officeService, userService);

    }
}

