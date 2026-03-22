package in.kb.main.services;

import in.kb.main.dto.AccountDto;
import in.kb.main.dto.CustomerDto;
import in.kb.main.entitys.AccountNumber;
import in.kb.main.entitys.Transactions;
import in.kb.main.enums.AccountType;
import in.kb.main.enums.Status;
import in.kb.main.enums.TransactionType;
import in.kb.main.exception.AccountCloseException;
import in.kb.main.exception.AccountNotFountException;
import in.kb.main.exception.InsufficientBlanceException;
import in.kb.main.exception.InvalidAmountException;
import in.kb.main.reproserty.AccountRepository;
import in.kb.main.reproserty.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServicesImpliments implements  AccountServices {

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final TransactionRepository transactionRepository;


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

    @Override
    public String withDrawAmount(long accNumber, BigDecimal amount) {

        if (amount.compareTo(BigDecimal.ZERO) < 0 ){
            throw  new InvalidAmountException("Unable to initiate transaction due to nagetive amount input");
        } else if (amount.compareTo(BigDecimal.ZERO) == 0) {
            throw  new InvalidAmountException("Unable to initiate transaction. Enter amount grater than 0.");
        }else {
            AccountNumber bankAccount = accountRepository.findByaccountNumber(accNumber);
            if (bankAccount == null){
                throw new AccountNotFountException("Invalid bank Account number entered.");
            }if (bankAccount.getStatus() == Status.Closed){
                throw new AccountCloseException("Account alredy closed..");

            }
            // SAVINF ACCOUNT = min_balance = 0
            //CURRENT ACCOUNT = min_balance = -1000;

            double min_balance = bankAccount.getAccountType() == AccountType.SavingAccount ? 0 : -1000;
            if ( bankAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) < min_balance){
                throw new InsufficientBlanceException("Enter withdrawal amount exceeds the minimum balance rules of bank account.");

            }

            BigDecimal storAmount = bankAccount.getBalance().subtract(amount);

            AccountNumber account = AccountNumber.builder()
                    .accountNumberId(bankAccount.getAccountNumberId())
                    .accountNumber(bankAccount.getAccountNumber())
                    .accountType(bankAccount.getAccountType())
                    .balance(storAmount)
                    .openingDate(bankAccount.getOpeningDate())
                    .customer(bankAccount.getCustomer())
                    .status(bankAccount.getStatus())
                    .build();

            try{
                account = accountRepository.save(account);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }

            Transactions transactions = Transactions.builder()
                    .accountNumber(account.getAccountNumber())
                    .amount(amount)
                    .transactionType(TransactionType.Withdrawl)
                    .transactionDate(LocalDate.now())
                    .description("Succesfull")
                    .BankAccount(account)
                    .build();

            try{
                transactionRepository.save(transactions);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }



        }




        return "WithDrawAmount: " + amount;
    }
}
