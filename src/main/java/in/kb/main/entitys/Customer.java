package in.kb.main.entitys;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    private String aadres;

    @Column(nullable = false, unique = true)
    private String panNumber;

    @Column(unique = true, nullable = false)
    private long aadharNumber;

    @CreationTimestamp
    @Column
    private LocalDate createAtTime;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<AccountNumber> accountNumber;

}
