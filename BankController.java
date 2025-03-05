package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bank")
public class BankController {
    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public String addAccount(@RequestParam String username, @RequestParam double balance) {
        return service.addAccount(username, balance);
    }

    @GetMapping("/balance/{username}")
    public Double getBalance(@PathVariable String username) {
        return service.getBalance(username);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String from, @RequestParam String to, @RequestParam double amount) {
        return service.transfer(from, to, amount);
    }

    @DeleteMapping("/delete/{username}")
    public String deleteAccount(@PathVariable String username) {
        return service.deleteAccount(username);
    }

    @GetMapping("/all-balances")
    public Map<String, Account> getAllBalances() {
        return service.getAllAccounts();
    }
}
