package tech.reliab.course.nametchenkolab.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Bank {
    private int id;
    private String name;
    private int numberOfOffice = 0;
    private int numberOfBankAtm = 0;
    private int numberOfEmployee = 0;
    private int numberOfUser = 0;
    private int rating;
    private int allMoney;
    private int interestRate;
}
