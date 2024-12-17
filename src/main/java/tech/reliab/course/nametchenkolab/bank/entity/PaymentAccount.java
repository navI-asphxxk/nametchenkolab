package tech.reliab.course.nametchenkolab.bank.entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class PaymentAccount {
    private int id; //Id платёжного счета
    private int idUser; //Пользователь, за которым закреплен этот платежный счет
    private int idBank; //Название банка, в котором открыт этот счет
    private int sum = 0;    //Сумма, которая лежит в данный момент на счету (по умолчанию 0)
}
