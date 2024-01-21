package gr.aueb.cf.ch18;

import gr.aueb.cf.ch18.dao.AccountDAOImpl;
import gr.aueb.cf.ch18.dao.IAccountDAO;
import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.dto.UserDTO;
import gr.aueb.cf.ch18.service.AccountServiceImpl;
import gr.aueb.cf.ch18.service.IAccountService;
import gr.aueb.cf.ch18.service.exceptions.*;

/**
 * Demo of accounts domain.
 *
 * @author Thodoris
 */
public class Main {
    public static void main(String[] args) {
        IAccountDAO accountDAO = new AccountDAOImpl();
        IAccountService accountService = new AccountServiceImpl(accountDAO);
        UserDTO userDTO1 = new UserDTO("Teo", "N", "1234");
        UserDTO userDTO2 = new UserDTO("Jim", "K", "2345");
        UserDTO userDTO3 = new UserDTO("Maria", "M", "7890");
        AccountDTO accountDTO1 = new AccountDTO("GR123", userDTO1, 1000.0);
        AccountDTO accountDTO2 = new AccountDTO("GR234", userDTO2, 1500.0);
        AccountDTO accountDTO3 = new AccountDTO("GR789", userDTO3, 2000.0);

        try {
            accountService.insertAccount(accountDTO1);
            accountService.insertAccount(accountDTO2);
            accountService.insertAccount(accountDTO3);
            accountService.updateAccount("GR789", userDTO1);
            accountService.deleteAccountByIban("GR789");

            accountService.depositToIban("GR123", 1000.0);
            accountService.withdraw("GR234", 500.0, "2345");
            Double balance = accountService.getBalanceByIban("GR123", "1234");
            System.out.println(balance);
        } catch (AccountAlreadyExistsException | AccountNotFoundException | NegativeAmountException |
                 SsnNotValidException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(accountService.getAllAccounts());
    }
}
