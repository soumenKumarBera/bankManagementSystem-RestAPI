package in.kb.main.controller;

import in.kb.main.dto.AccountDto;
import in.kb.main.services.AccountServicesImpliments;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    private  final AccountServicesImpliments accountServicesImpliments;

    @PostMapping("/closeAcc/{accNumber}")
    public ResponseEntity<?> closeAccount(@PathVariable long accNumber){
        AccountDto accountDto = accountServicesImpliments.closeAccount(accNumber);
        return  ResponseEntity.ok().body(accountDto);

    }
}
