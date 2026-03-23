package in.kb.main.services;

import in.kb.main.dto.CustomerDto;
import in.kb.main.entitys.AccountNumber;
import in.kb.main.entitys.Customer;
import in.kb.main.enums.AccountType;
import in.kb.main.enums.Status;
import in.kb.main.reproserty.AccountRepository;
import in.kb.main.reproserty.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CustomerServicesImpliments implements CustomerServices{

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final AccountRepository accountRepository;

    long accNumber = (long)(Math.random() *1000000000000l) +1 ;

    @Override
    public String creatCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .phoneNumber(customerDto.getPhoneNumber())
                .panNumber(customerDto.getPanNumber())
                .aadres(customerDto.getAadres())
                .aadharNumber(customerDto.getAadharNumber())
                .createAtTime(LocalDate.now())
                .build();



        try{
           customer = customerRepository.save(customer);


        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to create customer db");
        };

        AccountNumber accountNumber = AccountNumber.builder()
                .accountNumber(accNumber)
                .accountType(AccountType.SavingAccount)
                .balance(BigDecimal.valueOf(0.0))
                .status(Status.Active)
                .openingDate(LocalDate.now())
                .customer(customer)
                .build();

        try {
            accountRepository.save(accountNumber);

            System.out.println("Bank Account create sucessfully.\nYour account number is: " + accNumber);


        }catch (RuntimeException e){
            throw new RuntimeException(" Failed to create account.. ");
        }

        return "Your AccountNumber: "+ accNumber;


//        return CustomerDto.builder()
//                .customerId(customer.getCustomerId())
//                .firstName(customer.getFirstName())
//                .lastName(customer.getLastName())
//                .email(customer.getEmail())
//                .phoneNumber(customer.getPhoneNumber())
//                .panNumber(customer.getPanNumber())
//                .aadres(customer.getAadres())
//                .aadharNumber(customer.getAadharNumber())
//                .createAtTime(customer.getCreateAtTime())
//                .build();
    }






}
