package banking;

//An exception whose class extends java.lang.Exception but
//not java.lang.RuntimeException is checked at compile time
//i.e it can only occur within a try block in which it is
//caught or in a method in which it is declared to be thrown.
public class InsufficientFundsException extends Exception {}
