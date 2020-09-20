package th.ac.ku.atm.model;

public class BankAcc {
    private int id;
    private String cusid;
    private String type;
    private int balance;

    public BankAcc(int id, String cusid, String type, int balance) {
        this.id = id;
        this.cusid = cusid;
        this.type = type;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance(){return balance;}
    public void setBalance(int Balance){this.balance = balance;}
}
