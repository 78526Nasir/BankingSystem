
package BankingSystem;


public class Customer {
    private final String customerName;
    private  Account account;
    

    public Customer(String customerName, Account account) {
        this.customerName = customerName;
        this.account = account;
    }
    
    public void showAllInfo(){
        System.out.println("Customer Information");
        System.out.println("--------------------");
        System.out.println("Name : "+getCustomerName());
        System.out.println("Account Number : "+account.getAccountNumber());
        System.out.println("Account Balance : "+account.getBalance());
    }
    public String getCustomerName(){
        return customerName;
    }
    public Account getAccount(){
        return account;
    }
    


   

   
}
