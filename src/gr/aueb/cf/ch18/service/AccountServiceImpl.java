package gr.aueb.cf.ch18.service;

import gr.aueb.cf.ch18.dao.IAccountDAO;
import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.dto.UserDTO;
import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.model.User;
import gr.aueb.cf.ch18.service.exceptions.*;

import java.util.List;

/**
 * Implementation of service layer.
 */
public class AccountServiceImpl implements IAccountService {
    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public Account insertAccount(AccountDTO accountDTO) throws AccountAlreadyExistsException {
        Account account;
        try {
            account = mapFromAccountDTO(accountDTO);
            if (dao.accountExists(account.getIban())) {
                throw new AccountAlreadyExistsException(account);
            }
            return dao.insert(account);
        } catch (AccountAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account updateAccount(String iban, UserDTO userDTO) throws AccountNotFoundException {
        User user = mapFromUserDTO(userDTO);
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            return dao.update(iban, user);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAccountByIban(String iban) throws AccountNotFoundException {
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            dao.delete(iban);
        } catch (AccountNotFoundException e){
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getByIban(String iban) throws AccountNotFoundException {
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            return dao.get(iban);
        } catch(AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return dao.getAll();
    }

    @Override
    public Double getBalanceByIban(String iban, String ssn) throws AccountNotFoundException, SsnNotValidException {
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            if (!dao.get(iban).getHolder().getSsn().equals(ssn)) {
                throw new SsnNotValidException(ssn);
            }
            return dao.getBalance(iban);
        } catch (AccountNotFoundException | SsnNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void depositToIban(String iban, Double amount) throws AccountNotFoundException, NegativeAmountException {
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            if (amount < 0) {
                throw new NegativeAmountException();
            }
            dao.deposit(iban, amount);
        } catch (AccountNotFoundException | NegativeAmountException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Double withdraw(String iban, Double amount, String ssn)
            throws AccountNotFoundException, InsufficientBalanceException, NegativeAmountException, SsnNotValidException {
        try {
            if (!dao.accountExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            if (dao.get(iban).getBalance() < amount) {
                throw new InsufficientBalanceException();
            }
            if (amount < 0) {
                throw new NegativeAmountException();
            }
            if (!dao.get(iban).getHolder().getSsn().equals(ssn)) {
                throw new SsnNotValidException(ssn);
            }
            return dao.withdraw(iban, amount);
        } catch (AccountNotFoundException | InsufficientBalanceException | NegativeAmountException | SsnNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private User mapFromUserDTO(UserDTO userDTO) {
        return new User(userDTO.getFirstname(), userDTO.getLastname(), userDTO.getSsn());
    }

    private Account mapFromAccountDTO(AccountDTO accountDTO) {
        return new Account(accountDTO.getIban(), mapFromUserDTO(accountDTO.getHolder()), accountDTO.getBalance());
    }
}
