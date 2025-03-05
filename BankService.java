package com.example.banking.service;

import com.example.banking.model.Account;
import com.example.banking.repository.BankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    private final BankRepository repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    public String addAccount(String username, double balance) {
        if (repository.findByUsername(username) != null) {
            return "Account already exists!";
        }
        repository.save(new Account(username, balance));
        return "Account created!";
    }

    public Double getBalance(String username) {
        Account account = repository.findByUsername(username);
        return account != null ? account.getBalance() : null;
    }

    public String transfer(String from, String to, double amount) {
        Account sender = repository.findByUsername(from);
        Account receiver = repository.findByUsername(to);

        if (sender == null || receiver == null) return "Invalid accounts!";
        if (!sender.withdraw(amount)) return "Insufficient funds!";
        
        receiver.deposit(amount);
        return "Transfer successful!";
    }

    public String deleteAccount(String username) {
        repository.delete(username);
        return "Account deleted!";
    }

    public Map<String, Account> getAllAccounts() {
        return repository.findAll();
    }
}
