package com.example.banking.repository;

import com.example.banking.model.Account;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    private final Map<String, Account> accounts = new HashMap<>();

    public Account findByUsername(String username) {
        return accounts.get(username);
    }

    public void save(Account account) {
        accounts.put(account.getUsername(), account);
    }

    public void delete(String username) {
        accounts.remove(username);
    }

    public Map<String, Account> findAll() {
        return accounts;
    }
}
