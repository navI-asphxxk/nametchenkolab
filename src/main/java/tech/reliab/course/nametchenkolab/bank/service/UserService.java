package tech.reliab.course.nametchenkolab.bank.service;

import tech.reliab.course.nametchenkolab.bank.entity.Bank;
import tech.reliab.course.nametchenkolab.bank.entity.User;
import tech.reliab.course.nametchenkolab.bank.service.impl.BankServiceImpl;

import java.util.ArrayList;
import java.util.Random;

public interface UserService {
    static final int MAX_SALARY_AMOUNT = 10000;

    /* добавление клиена */
    public User createUser(String fullName, String dateOfBirth, String placeOfWork, ArrayList<Integer> arrayOfIdBanks);

    /* возвращает рандомно сгенерированную сумму, но не более 10 000*/
    public int givesRandomSalaryAmount();

    /* возвращает рандомно сгенерированный рейтинг исходя из ежемесячного дохода,
         от меньше 1 000 – 100, от 1 000 до 2 000 – 200 и т.д. вплоть до 10 000 */
    int givesRandomRating(int salaryAmount);

    /* увеличивает количество пользователей на 1 в банках, в которых находится пользователь*/
    public void addUserToBanks(ArrayList<Integer> arrayOfIdBanks);

    /*добавляет банк в список банков, которыми пользуется пользователь, и увеличивает
      в этом банке количество пользователей на 1 */
    public void addBankOfListUser(User user, int idBank);

    /* возвращает клиента по id */
    public User givesUserById(int idUser);

    /* добавляет id платежного счета в список клиента*/
    public void addPaymentAccount(User user, int idPaymentAccount);

    /* добавляет id кредитного счета в список клиента*/
    public void addCreditAccount(User user, int idCreditAccount);
}
