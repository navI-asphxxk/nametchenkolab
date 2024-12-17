package tech.reliab.course.nametchenkolab.bank.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import tech.reliab.course.nametchenkolab.bank.entity.*;
import tech.reliab.course.nametchenkolab.bank.exceptions.*;
import tech.reliab.course.nametchenkolab.bank.service.*;
import tech.reliab.course.nametchenkolab.bank.service.impl.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

class BankingTests {

    @Test
    void testBankInfrastructureWorkflow() {
        // Создание банка
        BankServiceImpl bankService = new BankServiceImpl();
        String bankName = "bank1";
        Bank bank = bankService.createBank(bankName);

        assertNotNull(bank, "Банк не должен быть null");
        assertEquals(bankName, bank.getName(), "Имя банка должно совпадать");
        assertEquals(0, bank.getNumberOfOffice(), "Изначально у банка не должно быть офисов");
        assertEquals(0, bank.getNumberOfBankAtm(), "Изначально у банка не должно быть банкоматов");
        assertEquals(0, bank.getNumberOfEmployee(), "Изначально у банка не должно быть сотрудников");
        assertEquals(0, bank.getNumberOfUser(), "Изначально у банка не должно быть пользователей");

        // Создание офиса
        BankOfficeServiceImpl officeService = new BankOfficeServiceImpl(bankService);
        BankOffice office = officeService.createOffice(
                "Main Office",       // Имя офиса
                "Main Street 1",     // Адрес
                bank.getId(),        // ID банка
                true,                // Статус работы офиса
                true,                // Возможность размещения банкоматов
                true,                // Возможность выдачи кредитов
                true,                // Возможность снятия денег
                true,                // Возможность внесения депозитов
                1200                 // Стоимость аренды
        );

        assertNotNull(office, "Офис не должен быть null");
        assertEquals(bank.getId(), office.getIdBank(), "Офис должен быть привязан к банку");
        assertEquals(1, bank.getNumberOfOffice(), "Количество офисов у банка 1");

        // Создание сотрудника
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(bankService);
        Employee employee = employeeService.createEmployee(
                "John Doe",         // Полное имя
                "1990-01-01",       // Дата рождения
                "Manager",          // Должность
                bank.getId(),       // ID банка
                true,               // Работает в офисе
                office.getId(),     // ID офиса
                true,               // Может выдавать кредиты
                1500                // Зарплата
        );

        assertNotNull(employee, "Сотрудник не должен быть null");
        assertEquals("John Doe", employee.getFullName(), "Полное имя сотрудника John Doe");
        assertEquals(1, bank.getNumberOfEmployee(), "Количество сотрудников в банке должно увеличиться на 1");

        // Создание банкомата
        AtmServiceImpl atmService = new AtmServiceImpl(bankService, officeService);
        BankAtm atm = atmService.createAtm(
                "ATM 1",                // Имя банкомата
                WorkStatus.WORKS,       // Статус работы
                bank.getId(),           // ID банка
                office.getId(),         // ID офиса
                employee.getId(),       // ID сотрудника
                true,                   // Возможность снятия денег
                true,                   // Возможность внесения денег
                500                     // Стоимость обслуживания
        );

        assertNotNull(atm, "Банкомат не должен быть null");
        assertEquals("ATM 1", atm.getName(), "Банкомат должен называться ATM 1");
        assertEquals(office.getAddress(), atm.getAddress(), "Банкомат должен иметь тот же адрес, что и офис," +
                " которому он принадлежит");
        assertEquals(1, bank.getNumberOfBankAtm(), "Количество банкоматов у банка должно увеличиться на 1");
        assertEquals(1, office.getNumberOfAtm(), "Количество банкоматов в офисе должно увеличиться на 1");
    }

    @Test
    void testBankUserAccountsWorkflow() {
        // Создание банка
        BankServiceImpl bankService = new BankServiceImpl();
        Bank bank1 = bankService.createBank("bank1");
        Bank bank2 = bankService.createBank("bank2");

        // Создание пользователя
        UserServiceImpl userService = new UserServiceImpl(bankService);
        ArrayList<Integer> userBanks = new ArrayList<>();
        userBanks.add(bank1.getId());
        User user = userService.createUser(
                "Alice Smith",
                "1985-02-15",
                "Software Engineer",
                userBanks
        );

        assertNotNull(user, "Пользователь не должен быть null");
        assertEquals("Alice Smith", user.getFullName(), "Имя пользователя должно совпадать");
        assertEquals("1985-02-15", user.getDateOfBirth(), "Дата рождения должна совпадать");
        assertEquals("Software Engineer", user.getPlaceOfWork(), "Место работы должно совпадать");
        assertEquals(userBanks, user.getArrayOfIdBanks(), "Пользователь должен быть связан с банка");
        assertEquals(1, bank1.getNumberOfUser(), "Количество пользователей в банке 1, клиентом которого " +
                "является пользователь, должно увеличиться на 1");
        assertEquals(0, bank2.getNumberOfUser(), "Количество пользователей в банке 2, клиентом которого " +
                "не является пользователь, должно быть 0");

        // создание нового платёжного счёта в банке, к которому не привязан пользователь
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl(bankService, userService);
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user.getId(), bank2.getId());

        assertNotNull(paymentAccount, "Платёжный счёт не должен быть null");
        assertTrue(user.getArrayOfIdBanks().contains(bank2.getId()), "Банк должен появиться в листе клиента");
        assertEquals(1, bank2.getNumberOfUser(), "Количество пользователей в банке, клиентом которого " +
                "не являлся пользователь до создание платежного счета, увеличится на 1");
        assertTrue(user.getArrayOfIdPaymentAccounts().contains(paymentAccount.getId()), "Платёжный счёт должен появиться в листе клиента");

        // создание нового платёжного счёта в банке, в котором уже числится пользователь
        int countUserBeforeAddingAccount = bank2.getNumberOfUser();
        PaymentAccount paymentAccount2 = paymentAccountService.createPaymentAccount(user.getId(), bank2.getId());
        int countUserAfterAddingAccount = bank2.getNumberOfUser();
        assertEquals(countUserBeforeAddingAccount, countUserAfterAddingAccount, "Количество пользователей в банке, клиентом которого " +
                "уже являлся пользователь, должно остаться неизменно при добавлении нового платёжного счёта этого пользователя");
        assertEquals(1, Collections.frequency(user.getArrayOfIdBanks(), bank2.getId()), "Id банка, " +
                "который уже есть в списке пользователя не должно дублироваться при добавлении платёжного аккаунта");


        // создание нового кредитного счёта в банке
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl(bankService, userService);
        LocalDate loanStartDate = LocalDate.of(2024, 1, 1);
        LocalDate loanEndDate = loanStartDate.plusMonths(12);
        int countUserBeforeAddingCreditAccount = bank2.getNumberOfUser();
        CreditAccount creditAccount = creditAccountService.createCreditAccount(user.getId(), bank2.getId(),
                loanStartDate, loanEndDate, 10000, 1, paymentAccount.getId());
        int countUserAfterAddingCreditAccount = bank2.getNumberOfUser();

        assertNotNull(creditAccount, "Кредитный счёт не должен быть null");
        assertTrue(user.getArrayOfIdCreditAccounts().contains(creditAccount.getId()),
                "Кредитный счёт должен присутствовать в списке пользователя, которому он принадлежит");
        assertEquals(countUserAfterAddingCreditAccount, countUserBeforeAddingCreditAccount, "Количество клиентов в " +
                "банке не должно меняться при добавлении кредитного счета, пользователь уже должен числиться в банке");
        assertEquals(1, Collections.frequency(user.getArrayOfIdBanks(), bank2.getId()), "Id банка, " +
                "который уже есть в списке пользователя не должно дублироваться при добавлении кредитного аккаунта");
    }

    @Test
    void testLoanIssuanceWorkflow() {
        BankServiceImpl bankService = new BankServiceImpl();
        BankOfficeServiceImpl officeService = new BankOfficeServiceImpl(bankService);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl(bankService);
        AtmServiceImpl atmService = new AtmServiceImpl(bankService, officeService);
        UserServiceImpl userService = new UserServiceImpl(bankService);
        PaymentAccountServiceImpl paymentAccountService = new PaymentAccountServiceImpl(bankService, userService);
        CreditAccountServiceImpl creditAccountService = new CreditAccountServiceImpl(bankService, userService);

        Bank bank1 = bankService.createBank("Test Bank");

        BankNotFoundException exception = assertThrows(BankNotFoundException.class,
                () -> bankService.chooseBestWeightedBank(bankService.getBanks()),
                "Исключение должно быть выброшено, если подходящий банк не найден");
        assertEquals("Подходящий банк не найден", exception.getMessage(),
                "Сообщение исключения должно быть 'Подходящий банк не найден'");

        ArrayList<Integer> userBanks = new ArrayList<>();
        userBanks.add(bank1.getId());
        User user = userService.createUser("Alice Smith", "1985-02-15", "Software Engineer", userBanks);
        BankOffice office = officeService.createOffice("Main Office", "Main Street 1", bank1.getId(),
                true, true, false, true, true, 1200);
        BankOfficeNotFoundException exception1 = assertThrows(BankOfficeNotFoundException.class,
                () -> bankService.chooseBankOffice(bank1.getId(), 500),
                "Исключение должно быть выброшено, если подходящий офис не найден");
        assertEquals("Подходящий офис для выдачи кредита не найден", exception1.getMessage(),
                "Сообщение исключения должно быть 'Подходящий офис не найден'");
        office.setCanGetLoan(true);

        Employee employee = employeeService.createEmployee("John Doe", "1990-01-01", "Manager",
                bank1.getId(), true, office.getId(), false, 1500);
        EmployeeNotFoundException exception2 = assertThrows(EmployeeNotFoundException.class,
                () -> bankService.chooseEmployee(office.getId()),
                "Исключение должно быть выброшено, если подходящий работник не найден");
        assertEquals("Сотрудник, который может выдавать кредиты, не найден", exception2.getMessage(),
                "Сообщение исключения должно быть 'Сотрудник, который может выдавать кредиты, не найден'");
        employee.setCanGiveLoan(true);

        BankAtm atm = atmService.createAtm("ATM 1", WorkStatus.WORKS, bank1.getId(), office.getId(), employee.getId(),
                true, true, 500);
        atm.setAllMoney(1000);
        AtmNotEnoughMoneyException exception3 = assertThrows(AtmNotEnoughMoneyException.class,
                () -> bankService.checkAtmsForLoan(office.getId(), 10000, bank1, officeService),
                "Исключение должно быть выброшено, если подходящий, банкомат не найден");
        assertEquals("Недостаточно средств в банкоматах этого офиса. Обратитесь в другой офис банка: Test Bank",
                exception3.getMessage());

        bank1.setRating(51);
        user.setCreditRatingForBank(4000);
        LoanApprovalException exception4 = assertThrows(LoanApprovalException.class,
                () -> bankService.checkLoanApproval(user.getId(), bank1, userService),
                "Исключение должно быть выброшено, если  кредитный рейтинг клиента меньше 5000, а рейтинг банка больше 50");
        assertEquals("Кредит не может быть выдан: низкий кредитный рейтинг клиента",
                exception4.getMessage());
        user.setCreditRatingForBank(6000);

        assertDoesNotThrow(() -> {
            bankService.issueLoan(100, user.getId(), bankService, officeService, userService);
        }, "Метод issueLoan должен завершиться без исключений (кредит успешно выдан)");
    }
}

