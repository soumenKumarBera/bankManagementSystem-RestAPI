package in.kb.main.controller;

import in.kb.main.dto.AccountDto;
import in.kb.main.services.AccountServicesImpliments;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    @PostMapping("withdraw")
    public ResponseEntity<?> withdrawApi(@RequestParam long accNumber, @RequestParam BigDecimal amount ){

        String result = accountServicesImpliments.withDrawAmount(accNumber,amount);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> depositAmpount(@RequestParam long accNumber, @RequestParam BigDecimal amount){
        String result = accountServicesImpliments.depositAmount(accNumber,amount);
        return  ResponseEntity.ok().body(result);

    }

    @PostMapping("/transfer")
    public ResponseEntity<?> moneyTransfer( @RequestParam long debitAccNumber, @RequestParam long creditAccNumber,@RequestParam BigDecimal amount){
        String result = accountServicesImpliments.transfer(debitAccNumber,creditAccNumber,amount);
        return  ResponseEntity.ok().body(result);
    }

}
