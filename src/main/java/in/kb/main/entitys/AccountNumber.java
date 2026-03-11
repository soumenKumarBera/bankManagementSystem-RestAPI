package in.kb.main.entitys;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class AccountNumber {

    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int accountNumberId;

    @Column(unique = true)
 private long accountNumber;

    @Column(nullable = false)
private String accountType;

    @Column(precision = 15, scale = 2)
 private BigDecimal balance;

    @Column(nullable = false)
private  String status;


    @Column(nullable = false)
  private LocalDate openingDate;

    @ManyToOne
    @JoinColumn(name = "fk_customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "BankAccount", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList;

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public int getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(int accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
