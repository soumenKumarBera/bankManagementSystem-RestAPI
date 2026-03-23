package in.kb.main.controller;

import in.kb.main.dto.CustomerDto;
import in.kb.main.entitys.Customer;
import in.kb.main.services.CustomerServicesImpliments;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerServicesImpliments customerServicesImpliments;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createCustomrPage(@RequestBody CustomerDto customerDto ){
       String accNumber = customerServicesImpliments.creatCustomer(customerDto);


      return ResponseEntity.ok().body(accNumber);

    }
}
