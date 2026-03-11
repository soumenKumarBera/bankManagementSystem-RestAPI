package in.kb.main.entitys;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class AccountNumber {

    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int customerId;

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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_customer_Id")
    private Customer customer;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
