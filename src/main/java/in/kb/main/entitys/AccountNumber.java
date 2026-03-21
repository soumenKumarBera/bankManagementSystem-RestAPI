package in.kb.main.entitys;

import in.kb.main.enums.AccountType;
import in.kb.main.enums.Status;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class AccountNumber {

    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer accountNumberId;

    @Column(unique = true)
 private long accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
private AccountType accountType;

    @Column(precision = 15, scale = 2)
 private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
private Status status;

    @CreationTimestamp
  private LocalDate openingDate;

    @ManyToOne
    @JoinColumn(name = "fk_customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "BankAccount", cascade = CascadeType.ALL)
    private List<Transactions> transactionsList;

}
