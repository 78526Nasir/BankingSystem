
package BankingSystem;


public class Bank {
    private static final double INTEREST_RATE=0.08;
    private static final double TRANSACTION_FEES=50;
    private  Customer [] customers=new Customer[1000];
    
    
    public void calculateInterest(Customer customerObj){
        Account tempAccount = customerObj.getAccount();
        double balance= tempAccount.getBalance();
        double interestAmount = balance*getINTEREST_RATE();
        double totalBalance=balance+interestAmount;
        System.out.println("Interest amount is : "+interestAmount+"Taka "+"\nTotal Balance After Adding  interest : "+totalBalance);
        customerObj.getAccount().setBalance(totalBalance);
    }
    
    public double getINTEREST_RATE(){
        return INTEREST_RATE;
    }
    public double getTRANSACTION_FEES(){
        return TRANSACTION_FEES;
    }
    public Customer[] getCustomers(){
        return customers;
    }

}
