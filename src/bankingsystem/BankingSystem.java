package bankingsystem;

abstract class Account{
    private String accountID;
    private String name;
    private int age;
    private String gender;
    private double accountBalance;

    

    public Account(String accountID, String name, int age, String gender) {
        this.accountID = accountID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        
    }
    
    
    public String getAccountID(){
        return accountID;
    }
    
    public double getAccountBalance(){
        return accountBalance;
    }
    
    public void setAccountBalance(double accountBalance){
        this.accountBalance=accountBalance;
    }
    
    public void deposit(double amount){
        accountBalance+=amount;
    }
    public void withdraw(double amount){
        accountBalance-=amount;
    }
    abstract void calculateInterest();
        
    
    
        
    
}

class SavingAccount extends Account{    
    private static boolean firstTime=true;
    private static final double INTEREST_RATE=0.05;

    
    public SavingAccount(String accountID, String name, int age, String gender) {
        super(accountID, name, age, gender);
    }
    
    
    @Override
    public void deposit(double amount) {
        if(firstTime==true){
            if(amount<1000){
                System.out.println("Sorry you can't deposit a amount which is less than 1000 tk at first Time");
            }
            else{
                super.deposit(amount);
                System.out.println("Successfully Deposited "+amount +"Taka on this account : "+getAccountID());
                firstTime=false;
            }
        }
        else{
                super.deposit(amount);
                System.out.println("Successfully Deposited "+amount +"Taka on this account : "+getAccountID());
                
            }
        
    }

    @Override
    public void withdraw(double amount) {
        double tempBalance=getAccountBalance()-amount;
        
        if(tempBalance<=500){
            System.out.println("Sorry You can't withdraw this amount  of Money!");
        }
        else{
            withdraw(amount);
            System.out.println("Sucessfully Withdraw "+amount+" taka from this account : "+getAccountID());
        }
    }

    @Override
    void calculateInterest() {
        double interestAmount=getAccountBalance()*INTEREST_RATE;
        double totalBalance=getAccountBalance()+interestAmount;
        setAccountBalance(totalBalance);
        System.out.println("Your  Interest Amount : "+interestAmount);
        
    }
    
    

}

class CurrentAccount extends Account{
    private static boolean firstTime=true;

    public CurrentAccount(String accountID, String name, int age, String gender) {
        super(accountID, name, age, gender);
    }
    
    
    @Override
    public void deposit(double amount) {
        if(firstTime==true){
            if(amount<5000){
                System.out.println("Sorry you can't deposit a amount which is less than 5000 tk at first Time");
            }else{
                super.deposit(amount);
                System.out.println("Successfully Deposited "+amount +" Taka on this account : "+getAccountID());
                firstTime=false;
            }
            
        }else{
                super.deposit(amount);
                System.out.println("Successfully Deposited "+amount +" Taka on this account : "+getAccountID());
        }
    }

    @Override
    public void withdraw(double amount) {
        double tempBalance=getAccountBalance()-amount;
        
        if(tempBalance<0){
            System.out.println("Sorry You can't withdraw this amount  of Money!");
        }
        else{
            super.withdraw(amount);
            System.out.println("Sucessfully Withdraw "+amount+" taka from this account : "+getAccountID());
        }
    }

    @Override
    void calculateInterest() {
        // i do not understand . because the scenerio was not clear here.
    }
    
}

class Mudaraba extends SavingAccount{

    public Mudaraba(String accountID, String name, int age, String gender) {
        super(accountID, name, age, gender);
    }

    
    public void profitShare(){
        // scenerio was not clear here. so i just print a line 
        System.out.println("Profit Sharing");
    }
}



public class BankingSystem {
    public static void main(String[] args) {

        Account savingAccount=new SavingAccount("sa00001", "Kuddus", 45, "Male");
        Account currentAccount=new CurrentAccount("ca00001", "Jamal", 50, "Male");
        Mudaraba mudarabaAccount=new Mudaraba("ma00001", "Mohiul", 40, "Male");
        
//        savingAccount.deposit(100);
        savingAccount.deposit(10001);
//        savingAccount.withdraw(500);
        
        savingAccount.calculateInterest();
        
//        currentAccount.deposit(500);
        currentAccount.deposit(5001);
        currentAccount.withdraw(5000);
        
        
        
        mudarabaAccount.profitShare();
        
        
        
    }

}
