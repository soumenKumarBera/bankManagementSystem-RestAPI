package in.kb.main.services;

import in.kb.main.entitys.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountServices extends JpaRepository<AccountNumber, Integer> {

}
