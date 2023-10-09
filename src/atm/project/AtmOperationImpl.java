package atm.project;
import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmoperationInterf {
    ATM atm = new ATM();
    Map<String,Double> ministmt = new HashMap<>();
    @Override
    public void viewBalance(){
        System.out.println("Available Balance is :" + atm.getBalance());
    }
    @Override
    public void withdrawAmount(double withdrawAmount){
        if(withdrawAmount%500 == 0){
            ministmt.put("Amount Withdraw",withdrawAmount);
            System.out.println("Collect Cash " + withdrawAmount);
            atm.setBalance(atm.getBalance() - withdrawAmount);
            viewBalance();
        }
        else {
            System.out.println("Insufficient Balance ");
        }
    }
    @Override
    public void depositAmount(double depositAmount){
        ministmt.put("Amount Deposited",depositAmount);
        System.out.println(depositAmount+"Deposited Successfully");
        atm.setBalance(atm.getBalance() + depositAmount);
        viewBalance();
    }
    @Override
    public void viewMiniStatement(){
        for(Map.Entry<String,Double> m : ministmt.entrySet()){
            System.out.println(m.getValue()+" "+ m.getKey());

        }
    }
}
