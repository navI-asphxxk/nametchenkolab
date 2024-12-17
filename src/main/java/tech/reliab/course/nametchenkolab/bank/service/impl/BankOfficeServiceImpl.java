package tech.reliab.course.nametchenkolab.bank.service.impl;

import tech.reliab.course.nametchenkolab.bank.entity.Bank;
import tech.reliab.course.nametchenkolab.bank.entity.BankOffice;
import tech.reliab.course.nametchenkolab.bank.service.BankOfficeService;
import tech.reliab.course.nametchenkolab.bank.service.BankService;


import java.util.Random;

public class BankOfficeServiceImpl implements BankOfficeService {
    BankServiceImpl bankService;

    public BankOfficeServiceImpl(BankServiceImpl bankService) {
        this.bankService = bankService;
    }

    @Override
    public BankOffice createOffice(String name, String address, int idBank, boolean isStatusOfJob,
                                   boolean canAtmPlacement, boolean canGetLoan, boolean canTakeMoney,
                                   boolean canDepositAllowed, int costOfRent ) {
        BankOffice office = new BankOffice();
        office.setId(bankService.offices.size());
        bankService.offices.add(office);
        Bank bank = bankService.givesBankById(idBank);
        bankService.addOffice(bank);

        office.setName(name);
        office.setAddress(address);
        office.setIdBank(idBank);
        office.setStatusOfJob(isStatusOfJob);
        office.setCanAtmPlacement(canAtmPlacement);
        office.setNumberOfAtm(0);
        office.setCanGetLoan(canGetLoan);
        office.setCanTakeMoney(canTakeMoney);
        office.setCanDepositAllowed(canDepositAllowed);
        office.setAllMoney(givesAllMoney(bank.getAllMoney()));
        office.setCostOfRent(costOfRent);
        return office;
    }

    @Override
    public void addAtm(BankOffice office){
        office.setNumberOfAtm(office.getNumberOfAtm() + 1);
    }

    @Override
    public BankOffice givesOfficeById(int id) {
        for (BankOffice office : bankService.offices)
            if (office.getId() == id)
                return office;
        return null;
    }

    @Override
    public int givesAllMoney(int moneyInBank) {
        return new Random().nextInt(moneyInBank);
    }

    @Override
    public void deleteOfOffice(int index) {
        bankService.offices.remove(index);
    }

    @Override
    public String toString() {
        String str = "BankOfficeServiceImpl{\n";
        int indexDelete = 0;
        for (BankOffice office : bankService.offices) {
            str += "indexDelete = " + indexDelete++ + " ";
            str += office.toString() + "\n";
        }
        str += '}';
        return str;
    }
}
