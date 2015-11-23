package com.ncs.thread;

public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount account = new BankAccount();
		MoneyThread thread1 = new MoneyThread(account);
		MoneyThread thread2 = new MoneyThread(account);
		
		thread1.start();
		thread2.start();
		
		
	}
}

class BankAccount{
	
	private int money = 1000;
	
	public synchronized int collectMoney( int amount ){
		
		if(amount > money){
			System.out.println("not much money to get...");
			return -1;
		}else if(amount <= 0){
			System.out.println("amount is invalid...");
			return -1;
		}else{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			money -= amount;
			return amount;
		}
	}
	
}

class MoneyThread extends Thread{
	
	private BankAccount bankAccount;
	
	public MoneyThread(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		System.out.println(bankAccount.collectMoney(800));
	}
}