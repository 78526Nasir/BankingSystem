
package BankingSystem;

import javax.swing.JOptionPane;


public class Account {
    private double balance;
    private final String accountNumber;
    
    private boolean firstTime=true; // for transaction fees purpose
    
    
    Account(double initBalance,String accountNumber){
        if(initBalance>=100){
            balance=initBalance;
        }
        else{
            System.err.println("Sorry you must need minimum 100$ to open an account !");
            JOptionPane.showMessageDialog (null, "Sorry you must need minimum 100$ to open an account !","Insufficient Account",JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        this.accountNumber=accountNumber;
        
    }


    public void deposit(double depositedBalance){
        if(depositedBalance>0){
            balance+=depositedBalance;
            System.out.println("You successfully deposited "+depositedBalance+" taka");            
        }
        
        else{
            System.err.println("You do not deposit a negative value !");
        }
    }
    
    
    public void withdraw(double withdrawBalance){
        
        if(withdrawBalance>0){
                if (firstTime==true) { 
                    double remainingBalance=balance-withdrawBalance;
                        if(remainingBalance<100){
                            System.err.println("You do not have sufficient amount on your account !");
                        }
                        else{
                            System.out.println("You successfully withdraw "+withdrawBalance+" taka from you account !");
                            balance-=withdrawBalance;
                            firstTime=false;
                        }
                }
                else{
                    Bank b = new Bank();  // for getting transication fees 
                    double remainingBalance=balance-(withdrawBalance+b.getTRANSACTION_FEES());
                        if(remainingBalance<100){
                            System.err.println("You do not have sufficient amount for withdraw !");
                        }
                        else{
                            System.out.println("You successfully withdraw "+withdrawBalance+" taka from you account !");
                            balance=balance-(withdrawBalance+b.getTRANSACTION_FEES());
                            System.out.println("For this withdraw Bank will take a transication fees from your account balance!");
                        }
                }
        }
        else{
            System.err.println("You cannot withdraw a negative  amount !!");
        }

    }
    
    public void setBalance(double amount){
        balance=amount;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }


  
}
