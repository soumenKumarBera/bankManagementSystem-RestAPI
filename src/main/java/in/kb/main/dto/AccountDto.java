package in.kb.main.dto;

import in.kb.main.entitys.AccountNumber;
import in.kb.main.entitys.Customer;
import in.kb.main.entitys.Transactions;
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
    private String accountType;
    private BigDecimal balance;
    private  String status;
    private LocalDate openingDate;







}
