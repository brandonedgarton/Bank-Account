public abstract class BankAccount 
{
    private double balance;
    private int numOfDeposits;
    private int numOfWithdrawals;
    private double apr;
    private double serviceCharge;

    public BankAccount(double balance, double apr) 
    {
        this.balance = balance;
        this.apr = apr;
    }
    
    public void deposit(double d) 
    {
        balance += d;
        numOfDeposits++;
    }
    
    public void withdraw(double w) 
    {
        if(balance > w)
        {
            balance -= w;
        }
        else 
        {
            System.out.println("Amount cannot be withdrawn.");
        }
        
        numOfWithdrawals++;
    }
    
    public void calcInterest() 
    {
        double monthlyApr = (apr / 12); 
        double monthlyInterest = this.balance * monthlyApr / 100;
        balance += monthlyInterest;
    }
    
    public void monthlyService() 
    {
        balance -= serviceCharge;
        calcInterest();
        numOfWithdrawals = 0;
        numOfDeposits = 0;
        serviceCharge = 0;
    }
    
    public void setBalance(double balance) 
    {
        this.balance = balance;
    }

    public void setNumOfDeposits(int numOfDeposits) 
    {
        this.numOfDeposits = numOfDeposits;
    }

    public void setNumOfWithdrawals(int numOfWithdrawals) 
    {
        this.numOfWithdrawals = numOfWithdrawals;
    }

    public void setApr(double apr) 
    {
        this.apr = apr;
    }

    public void setServiceCharge() 
    {
        if (numOfWithdrawals > 4) 
        {
            System.out.println("You've exceeded monthly limit of withdrawals. Fee of $1 charged" );
            this.serviceCharge = (numOfWithdrawals - 4) * 1.00;
        } 
        else 
        {
            serviceCharge = 0;
        }
    }

    public double getBalance() 
    {
        return balance;
    }
    
    public int getNumOfDeposits() 
    {
        return numOfDeposits;
    }
    
    public int getNumOfWithdrawals() 
    {
        return numOfWithdrawals;
    }
    
    public double getApr() 
    {
        return apr;
    }
    
    public double getServiceCharge() 
    {
        return serviceCharge;
    }

}