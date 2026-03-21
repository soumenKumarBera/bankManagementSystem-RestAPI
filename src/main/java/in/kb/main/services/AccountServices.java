package in.kb.main.services;

import in.kb.main.dto.AccountDto;
import in.kb.main.dto.CustomerDto;
import in.kb.main.entitys.AccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountServices {

    public AccountDto closeAccount(long accNumber);
}
