package com.revature.soap;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebService;

import com.revature.bank.Account;
import com.revature.bank.Bank;
import com.revature.bank.User;

@WebService(endpointInterface = "com.revature.soap.BankService") 
public class BankServiceImp implements BankService{
	public static Bank b;
	
	@PostConstruct
	public void init() {
		b = new Bank("My Bank", DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);
	}
	
	@Override
	public User authenticate(String username, String password) {
		return b.authenticate(username, password);
	}

	@Override
	public boolean storeUser(User u) {
		return b.storeUser(u);
	}
	
	@Override
	public Account newAccount(User user) {
		return b.newAccount(user);
	}

	@Override
	public Account getAccount(Integer id) {
		return b.getAccount(id);
	}

	@Override
	public ArrayList<Account> getPendingAccounts(User operator) {
		return b.getPendingAccounts(operator);
	}

	@Override
	public boolean approveAccount(User operator, Account a) {
		return b.approveAccount(operator, a);
	}

	@Override
	public boolean denyAccount(User operator, Account a) {
		return b.denyAccount(operator, a);
	}

	@Override
	public boolean withdraw(User user, Account account, double amount) {
		return b.withdraw(user, account, amount);
	}

	@Override
	public boolean deposit(User user, Account account, double amount) {
		return b.deposit(user, account, amount);
	}

	@Override
	public boolean transfer(User user, Account src, Account dst, double amount, String memo) {
		return b.transfer(user, src, dst, amount, memo);
	}
	@Override
	public User getUserInformation(User operator, Integer id) {
		return b.getUserInformation(operator, id);
	}
	
	@Override
	public boolean apiTransfer(User user, Integer src_id, Integer dst_id, double amount, String memo) {
		Account scr_obj = b.getAccount(src_id);
		Account dst_obj = b.getAccount(dst_id);
		return b.transfer(user, scr_obj, dst_obj, amount, memo);
	}
	
	@PreDestroy
	public void close() {
		b.close();
	}

}
