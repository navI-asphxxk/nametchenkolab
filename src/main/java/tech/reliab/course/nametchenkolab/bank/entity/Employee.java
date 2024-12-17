package tech.reliab.course.nametchenkolab.bank.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee  {
    private int id;
    private String fullName;
    private String dateOfBirth;
    private String position;
    private int idBank;
    private boolean isOfficeJob;
    private int idBankOffice;
    private boolean canGiveLoan;
    private int salaryAmount;
}



