package in.kb.main.entitys;

import in.kb.main.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  int  transactionsId;

    @Column
    private long accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Column(nullable = false)
    private BigDecimal amount;

    @CreationTimestamp
    @Column
    private LocalDate transactionDate;

    @Column()
    private Long relativeAccountNumber  ;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_accountNumber_id")
    private AccountNumber BankAccount;



}
