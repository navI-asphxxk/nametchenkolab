package tech.reliab.course.nametchenkolab.bank;

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

        randomObjects.printBanks();
        randomObjects.printOffices(0);
        randomObjects.printEmployees(0);
        randomObjects.printAtms(0);
        randomObjects.printUsers(0);
        randomObjects.printPaymentAccounts(0);
        randomObjects.printCreditAccount(0);
    }
}

