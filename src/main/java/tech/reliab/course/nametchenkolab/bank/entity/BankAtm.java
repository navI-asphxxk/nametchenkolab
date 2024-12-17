package tech.reliab.course.nametchenkolab.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//банкомат
public class BankAtm {
    private int id;
    private String name;
    private String address;
    private WorkStatus workStatus;
    private int idBank;
    private int idEmployee;
    private boolean isDispensingCash;
    private boolean canDepositAllowed;
    private int allMoney;
    private int atmMaintenanceCost;
}


