package in.kb.main.services;

import in.kb.main.dto.AccountDto;
import in.kb.main.dto.CustomerDto;
import in.kb.main.entitys.AccountNumber;
import in.kb.main.enums.Status;
import in.kb.main.exception.AccountCloseException;
import in.kb.main.exception.AccountNotFountException;
import in.kb.main.reproserty.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServicesImpliments implements  AccountServices {

    @Autowired
    private final AccountRepository accountRepository;


    @Override
    public AccountDto closeAccount(long accNumber) {
            AccountNumber accountNumber = accountRepository.findByaccountNumber(accNumber);

            if(accountNumber == null){
                throw new AccountNotFountException("Account not fount in bank recored");
            }
            if (accountNumber.getStatus() == Status.Closed){
                throw new AccountCloseException("Account alredy closed ");

            }else {
                accountNumber = AccountNumber.builder()
                        .accountNumberId(accountNumber.getAccountNumberId())
                        .accountNumber(accountNumber.getAccountNumber())
                        .accountType(accountNumber.getAccountType())
                        .status(Status.Closed)
                        .balance(accountNumber.getBalance())
                        .openingDate(accountNumber.getOpeningDate())
                        .customer(accountNumber.getCustomer())
                        .build();

                try {
                    accountNumber = accountRepository.save(accountNumber);
                    System.out.println("Bank Account number: " + accNumber + " closed successfully.");
                } catch (RuntimeException e) {
                    throw new RuntimeException("Failed to Close bank account. Please try again");
                }

                return AccountDto.builder()
                        .accountNumberId(accountNumber.getAccountNumberId())
                        .accountNumber(accountNumber.getAccountNumber())
                        .accountType(accountNumber.getAccountType())
                        .status(accountNumber.getStatus())
                        .balance(accountNumber.getBalance())
                        .openingDate(accountNumber.getOpeningDate())
                        .build();


            }



    }
}
