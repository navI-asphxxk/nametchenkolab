package tech.reliab.course.nametchenkolab.bank.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


public class CreditAccount {
    private int id;
    private int idUser;
    private int idBank;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private long loanLongInMonths;
    private int creditAmount;
    private double monthlyPayment;
    private int interestRate;
    private int idEmployee;
    private int idPaymentAccount;
}
