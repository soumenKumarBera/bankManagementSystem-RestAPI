package in.kb.main.dto;

import in.kb.main.entitys.AccountNumber;
import in.kb.main.entitys.Customer;
import in.kb.main.entitys.Transactions;
import in.kb.main.enums.AccountType;
import in.kb.main.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private Integer accountNumberId;
    private long accountNumber;
    private AccountType accountType;
    private BigDecimal balance;
    private Status status;
    private LocalDate openingDate;







}
