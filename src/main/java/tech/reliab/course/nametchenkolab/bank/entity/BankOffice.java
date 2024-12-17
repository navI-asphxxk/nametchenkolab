package tech.reliab.course.nametchenkolab.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class BankOffice {
    private int id;
    private String name;
    private String address;
    private int idBank; //
    private boolean isStatusOfJob;
    private boolean canAtmPlacement;
    private int numberOfAtm;
    private boolean canGetLoan;
    private boolean canTakeMoney;
    private boolean canDepositAllowed;
    private int allMoney;
    private int costOfRent;
}
