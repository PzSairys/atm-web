package th.ac.ku.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import th.ac.ku.atm.model.BankAcc;
import th.ac.ku.atm.model.Customer;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.Customer;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private ArrayList<BankAcc> bankAccList;

    @PostConstruct
    public void PostContruct(){
        bankAccList = new ArrayList<>();
    }

    public void createBankAccount(BankAcc bankAcc){
        bankAccList.add(bankAcc);
    }

    public ArrayList<BankAcc> getBankacc(){
        return new ArrayList<>(bankAccList);
    }


}
