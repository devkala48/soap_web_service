package com.revature.soap;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;

import com.revature.bank.Account;
import com.revature.bank.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use=Use.LITERAL)
public interface BankService {
	static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/bank_soapAPI";
	static final String DEFAULT_USERNAME = "postgres";
	static final String DEFAULT_PASSWORD = "password";
	
	@WebMethod
	@WebResult(name="User")
	//authenticate user
	public User authenticate(@WebParam(name="username")String username, @WebParam(name="password")String password);
	
	@WebMethod
	public boolean storeUser (@WebParam(name="user")User u);
	
	@WebMethod
	public User getUserInformation(@WebParam(name="operator")User operator, @WebParam(name="id")Integer id);
	
	@WebMethod
	public Account newAccount (@WebParam(name="user")User user);
	
	@WebMethod
	@WebResult(name="Account")
	public Account getAccount (@WebParam(name="id")Integer id);
	
	@WebMethod
	@WebResult(name="Account")
	public ArrayList<Account> getPendingAccounts (@WebParam(name="operator")User operator);
	
	@WebMethod
	public boolean approveAccount (@WebParam(name="opertator")User operator, @WebParam(name="account")Account a);
	
	@WebMethod
	public boolean denyAccount (@WebParam(name="operator")User operator, @WebParam(name="account")Account a);
	
	@WebMethod
	public boolean withdraw(@WebParam(name="user")User user, @WebParam(name="account")Account account, @WebParam(name="amount")double amount);
	
	@WebMethod
	public boolean deposit(@WebParam(name="user")User user, @WebParam(name="account")Account account, @WebParam(name="amount")double amount);
	
	@WebMethod
	public boolean transfer(@WebParam(name="user")User user, @WebParam(name="src")Account src,  @WebParam(name="dst")Account dst, @WebParam(name="amount")double amount, @WebParam(name="memo")String memo);
	
	@WebMethod
	public boolean apiTransfer(@WebParam(name="user")User user, @WebParam(name="src")Integer src_id, @WebParam(name="dst")Integer dst_id, @WebParam(name="amount")double amount, @WebParam(name="memo")String memo);
}
