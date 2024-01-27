public class SavingsAccount extends BankAccount 
{
    private boolean status;
    
    public SavingsAccount(double balance, double apr) 
    {
        super(balance, apr);
        
        if (balance >= 25) 
        {
            status = true;
        } 
        else 
        {
            status = false;
        }
    }
    
    public void withdraw(double w) 
    {
        if (status) 
        {
            super.withdraw(w);
        }
        
        if (super.getBalance() < 25) 
        {
            status = false;
        }
    }
    
    public void deposit(double d) 
    {
        if (!status) 
        {
            double available = super.getBalance() + d;
            if (available >= 25) 
            {
                status = true;
            }
        }
        
        super.deposit(d);
    }
    
    public void monthlyService() 
    {
        int withdrawalCount = super.getNumOfWithdrawals();
        if (withdrawalCount > 4) 
        {
            super.setServiceCharge();
        }
        
        super.monthlyService();
        
        if (super.getBalance() < 25)
        {
            status = false;
        }
    }
    
    public boolean isStatus() 
    {
        return status;
    }
    
    public void setStatus(boolean status) 
    {
        this.status = status;
    }
}