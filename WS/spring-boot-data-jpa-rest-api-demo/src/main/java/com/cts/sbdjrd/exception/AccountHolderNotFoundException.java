package com.cts.sbdjrd.exception;

public class AccountHolderNotFoundException extends Exception{

	public AccountHolderNotFoundException() {
		super("The account holder record not found");
	}
}
