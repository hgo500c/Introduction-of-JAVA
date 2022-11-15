 
public class Account {
private static int AccountCount = 1;
private double balance =2000;
private int id;
public Account(){
    this.id = Account.AccountCount;
    this.AccountCount= Account.AccountCount+1;
}
public Account(double startingbalance){
    this.balance=startingbalance;
}
public boolean withdraw(double amount) {
	if(amount>this.balance)return false;
	else {
		this.balance=this.balance-amount;
		return true;
	}
}
public double getBalance() {
	return this.balance;
}
public void deposit(double amount) {
	this.balance=this.balance+amount;
}
public int getId() {
	return this.id;
}

}
