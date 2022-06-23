package com.cts.sbdjwd.exception;

public class AccountHolderNotFoundException extends Exception{

	public AccountHolderNotFoundException() {
		super("The account holder record not found");
	}
}
