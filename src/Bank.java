import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bank implements IBank{
    private List<IAccount>bankList=new ArrayList<>();
    public Bank() {
    }

    @Override
    public void OpenAccount(IAccount account) {
        List<IAccount>addAccount=new ArrayList<>();
        if(account instanceof BasicAccount){

            account=new BasicAccount(account.GetAccountNumber(),((BasicAccount) account).getWithdrawlLimit());
            addAccount.add(account);
        } else if (account instanceof PremiumAccount) {
            account=new PremiumAccount(((PremiumAccount) account).getAccountNumber());
            addAccount.add(account);
        }else {
            account=new StandardAccount(account.GetAccountNumber(),((StandardAccount) account).getCreditLimit());
            addAccount.add(account);
        }
        bankList.addAll(addAccount);

    }

    @Override
    public void CloseAccount(int accountNumber) {
        List<IAccount> accounts=new ArrayList<>();
        accounts.add((IAccount) bankList);
        for (IAccount item:accounts) {
            if (accountNumber==item.GetAccountNumber()){
                if (item.GetCurrentBalance()>=0 ){
                    accounts.remove(item);}
                else{
                    System.out.println("account cannot be removed balance is negative");
                }

            }
        }



    }

    @Override
    public List<IAccount> GetAllAccounts() {
        List<IAccount> accounts=new ArrayList<>();
        accounts.addAll(this.bankList);
        System.out.println(accounts);
        return accounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount>accounts= new ArrayList<>();
        accounts.add((IAccount) bankList);
        for (IAccount item:accounts) {
            if(item.GetCurrentBalance()>0){
                accounts.remove(item);
            }
        }
        return accounts;

    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount>accounts= new ArrayList<>();
        accounts.add((IAccount) bankList);
        for (IAccount item:accounts){
            if ( item.GetCurrentBalance()<balanceAbove){
                accounts.remove(item);
            }
        }
        return accounts;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankList=" + bankList +
                '}';
    }
}