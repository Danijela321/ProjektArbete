package com.webbutik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbutik.entity.Account;
import com.webbutik.exception.OurServerException;
import com.webbutik.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping("/register")
	public Account register(@RequestBody Account account) throws OurServerException {
		try {
			return service.SaveAccount(account);
		} catch (Exception e) {
			throw new OurServerException("Kunde inte registrera ny användare");
		}
	}
	
	@GetMapping("/login")
	public boolean login(String email, String password) {
		return service.login(email, password);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@GetMapping("/accounts/fullName/{fullName}")
	public List<Account> getAccountsByFullName(@PathVariable String firstName, String surname) {
		return service.getAccountsByFullName(firstName, surname);
	}
	
	@GetMapping("/account({id}")
	public Account getAccountById(@PathVariable Integer id) {
		return service.getAccountById(id);
	}
	

}
