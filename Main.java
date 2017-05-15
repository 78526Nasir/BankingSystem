package BankingSystem;

import java.util.Scanner;



/*
    A customer opens an account in a bank, the customer must have an initial balance of 100$
    while opening the account, the customer can withdraw, deposit, and check  his balance any time
    he wants, the bank does not charge any fees for the 1st withdraw but for all subsequent withdrwals 
    the bank charges some transiction fees. The bank also claculates a certain amount of interest
    on the amount deposited by the customer as per its interest rate. When a customer want to deposit 
    the deposited amount will be checked, if the deposited amount was negative then the system gives a error 
    message. Same thing will happens when a customer withdraw amount. Create method to showing all the information 
    of a customer. Create a menu driven program in main class. Create an object oriented program to automate this problem.

*/

public class Main {
    
    static Scanner scanf = new Scanner(System.in);
    static int currentNoOfCustomer=0;
    static Bank bankObj = new Bank();
    static Customer [] customerArray=bankObj.getCustomers();
    
    public static void main(String[] args) {    
      
            while(true){
                System.out.println("ABC Bank System");
                System.out.println("---------------");
                System.out.println("1. Create an Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Calculate Interest");
                System.out.println("6. EXIT");
                System.out.println("Please Enter your Choice: ");
                int choice= scanf.nextInt(); 

                switch(choice){
                    case 1:
                        System.out.println("Creating an account for a New Customer");
                        System.out.println("Please Enter the Initial Amount in your Account");
                        double initialAmount=scanf.nextDouble();
                        takeDummy();
                        System.out.println("Please Enter your Account Number :");
                        String accountNumber= scanf.nextLine();
                        Account newAccount = new Account(initialAmount,accountNumber);
                        System.out.println("Please Enter Your Name :");
                        String customerName= scanf.nextLine();
                        Customer newCustomer = new Customer(customerName,newAccount);
                        customerArray[currentNoOfCustomer++]=newCustomer;
                        System.out.println("Account Has Been Created Successfully\n");
                        break;
                        
                    case 2:
                        takeDummy();
                        System.out.println("\nEnter The Account Number : ");
                        String takeAccountNumber = scanf.nextLine();
                        if(currentNoOfCustomer==0){
                            System.err.println("Sorry The Bank has no Customer yet !");
                        }
                        else{
                            boolean accountFound=false;
                            for(int i=0;i<currentNoOfCustomer;i++){
                                Account tempAccount=customerArray[i].getAccount();
                                String tempAccountNumber=tempAccount.getAccountNumber();
                                if(takeAccountNumber.contains(tempAccountNumber)){
                                    System.out.println("Please Enter the Deposited Amount :");
                                    double depositedAmount= scanf.nextDouble();
                                    tempAccount.deposit(depositedAmount);
                                    accountFound=true;
                                    break;
                                }
                            }
                            
                            if(accountFound==false){
                                System.out.println("\nAccount Not FOUND !!!\n");
                            }
                            
                        }
                        
                        break;
                        
                    case 3:
                        takeDummy();
                        System.out.println("\nEnter The Account Number : ");
                        takeAccountNumber = scanf.nextLine();
                        if(currentNoOfCustomer==0){
                            System.err.println("Sorry The Bank has no Customer yet !");
                        }
                        else{
                            boolean accountFound=false;
                            for(int i=0;i<currentNoOfCustomer;i++){
                                Account tempAccount=customerArray[i].getAccount();
                                String tempAccountNumber=tempAccount.getAccountNumber();
                                if(takeAccountNumber.contains(tempAccountNumber)){
                                    System.out.println("Please Enter the Withdraw Amount :");
                                    double withdrawAmount= scanf.nextDouble();
                                    tempAccount.withdraw(withdrawAmount);
                                    accountFound=true;
                                    break;
                                }
                            }
                            
                            if(accountFound==false){
                                System.out.println("\nAccount Not FOUND !!!\n");
                            }
                            
                        }
                        break;

                    case 4:
                        takeDummy();
                        System.out.println("\nEnter The Account Number : ");
                        takeAccountNumber = scanf.nextLine();
                        if(currentNoOfCustomer==0){
                            System.err.println("Sorry The Bank has no Customer yet !");
                        }
                        else{
                            boolean accountFound=false;
                            for(int i=0;i<currentNoOfCustomer;i++){
                                Account tempAccount=customerArray[i].getAccount();
                                String tempAccountNumber=tempAccount.getAccountNumber();
                                if(takeAccountNumber.contains(tempAccountNumber)){
                                    System.out.println("\nThe Current Amount is :" +tempAccount.getBalance()+"\n");
                                    accountFound=true;
                                    break;
                                }
                            }
                            
                            if(accountFound==false){
                                System.err.println("\nAccount Not FOUND !!!\n");
                            }
                            
                        }
                        break;
                        
                    case 5:
                        takeDummy();
                        System.out.println("\nEnter The Account Number : ");
                        takeAccountNumber = scanf.nextLine();
                        if(currentNoOfCustomer==0){
                            System.err.println("Sorry The Bank has no Customer yet !");
                        }
                        else{
                            boolean accountFound=false;
                            for(int i=0;i<currentNoOfCustomer;i++){
                                Account tempAccount=customerArray[i].getAccount();
                                String tempAccountNumber=tempAccount.getAccountNumber();
                                if(takeAccountNumber.contains(tempAccountNumber)){
                                    Bank b = new Bank();
                                    b.calculateInterest(customerArray[i]);
                                    accountFound=true;
                                    break;
                                }
                            }
                            
                            if(accountFound==false){
                                System.err.println("\nAccount Not FOUND !!!\n");
                            }
                        
                        }
                        break;
                    
                    case 6:    
                        System.exit(0);
                        
                    default:
                        System.out.println("Please Enter a valid Choice !");
                  
            } // switch case end here
            
            } // while loop end here
     
        
    } //main method end here
    
    public static void takeDummy(){
        String dummy = scanf.nextLine();
    }

}
