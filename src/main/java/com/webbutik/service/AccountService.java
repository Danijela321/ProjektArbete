package com.webbutik.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbutik.entity.Account;
import com.webbutik.exception.OurCustomExceptions;
import com.webbutik.repository.AccountRepository;

@Transactional
@Service
public class AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	@Autowired
	private AccountRepository repository;

	public Account SaveAccount(Account account) throws Exception {
		if (repository.existsByEmail(account.getEmail())) {
			throw new OurCustomExceptions("Konto finns redan i tabellen");
		}
		return repository.save(account);
	}
	
	public String deleteAccount(int id) {
		if(!repository.existsById(id)) {
			LOGGER.error("Inget Konto med id:" + id + " existerar");
			throw new OurCustomExceptions("Kunde inte ta bort Konto");
		}
		repository.deleteById(id);
		return ("Konto med id:" + id + " lyckades bli raderad");	
	}
	
	public String deleteAccountByEmail(String email) {
		if(!repository.existsByEmail(email)) {
			LOGGER.error("Inget Konto med email" + email + " existerar");
			throw new OurCustomExceptions("Kunde inte ta bort Konto");
		}
		repository.deleteByEmail(email);
		return ("Konto med email " + email + " lyckades bli raderad");	
	}
	
	public boolean login(String email, String password) {
		if(repository.findByEmailAndPassword(email, password) == null) {
			LOGGER.error("Inloggning nekad: email eller lösenord är felatkiga");
			return false;
		}
		LOGGER.info("Inloggning godkänd");
		return true;
	}

	public List<Account> getAllAccounts() {
		if (repository.findAll().isEmpty()) {
			LOGGER.error("Fel: Inga Konton kunde hittas i tabellen");
			throw new OurCustomExceptions("Inga konton fanns i tabellen");
		} else {
			return repository.findAll();
		}
	}
	
	public Account getAccountById(int id) {
		if(!repository.existsById(id)) {
			throw new OurCustomExceptions("Kontot kunde inte hittas i tabellen");
		} 
		return repository.findById(id);

	}
	
	public List<Account> getAccountsByFullName(String firstName, String surname) {
		if(repository.findByFullName(firstName, surname).isEmpty()) {
			throw new OurCustomExceptions("Inget konto med av namnet:" + firstName + " " + surname + " kunde hittas");
		} 
		return repository.findByFullName(firstName, surname);

	}
	
	

}
