package in.kb.main.entitys;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  int  transactionsId;

    @Column
    private long accountNumber;

    @Column(nullable = false)
    private String tranctionType;

    @Column(nullable = false)
    private BigDecimal amount;

    @CreationTimestamp
    @Column
    private LocalDate transactionDate;

    @Column
    private long relativeAccountNumber;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_accountNumber_id")
    private AccountNumber BankAccount;



    public int getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(int transactionsId) {
        this.transactionsId = transactionsId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTranctionType() {
        return tranctionType;
    }

    public void setTranctionType(String tranctionType) {
        this.tranctionType = tranctionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getRelativeAccountNumber() {
        return relativeAccountNumber;
    }

    public void setRelativeAccountNumber(long relativeAccountNumber) {
        this.relativeAccountNumber = relativeAccountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountNumber getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(AccountNumber bankAccount) {
        BankAccount = bankAccount;
    }
}
