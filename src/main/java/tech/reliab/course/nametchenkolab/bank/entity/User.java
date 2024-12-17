package tech.reliab.course.nametchenkolab.bank.entity;


import java.util.ArrayList;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String placeOfWork;
    private int salaryAmount;
    private ArrayList<Integer> arrayOfIdBanks;
    private ArrayList<Integer> arrayOfIdCreditAccounts = new ArrayList<>();
    private ArrayList<Integer> arrayOfIdPaymentAccounts = new ArrayList<>();
    private int creditRatingForBank;


    public void addIdBankInArrayBanksOfBankUser(int idBank){
        this.arrayOfIdBanks.add(idBank);
    }
}

