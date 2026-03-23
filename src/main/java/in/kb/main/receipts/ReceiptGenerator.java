package in.kb.main.receipts;

import in.kb.main.entitys.Transactions;
import in.kb.main.enums.TransactionType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class ReceiptGenerator {


    public static void generatrReceipt(Transactions t)throws IOException {

        String directory = "src/generatedRecepits/";
        String fileName = "Receipt_" + t.getTransactionsId() + "_" + t.getAccountNumber() + ".txt";

        File obj = new File(directory + fileName);
        obj.createNewFile();

        FileWriter writer = new FileWriter(directory + fileName);

            writer.write("=============== KB BANK ===============\n");
            writer.write("Transection Type         : " + t.getTransactionType() + "\n");
            writer.write("Transaction Id           : " + t.getTransactionsId()+ "\n");

        if (t.getTransactionType() == TransactionType.Transfer){
            if (t.getDescription() == "Withdrawal from account for transfer"){
                writer.write("Your's Account number    : " + t.getAccountNumber() + "\n");
                writer.write("Receiver's account number: "+ t.getRelativeAccountNumber() + "\n");

            }else {
                writer.write("Your's Account number    : " + t.getAccountNumber() + "\n");
                writer.write("Sender's account number  : "+ t.getRelativeAccountNumber() + "\n");

            }

        }else {
            writer.write("Account Number           : " + t.getAccountNumber()+ "\n");
        }
            writer.write("Amount                   : " + t.getAmount()+ "\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            writer.write("Date & Time              : " + LocalDate.now() +" & " + LocalTime.now().format(formatter) + "\n");
            writer.write("Drescription             : "+ t.getDescription()+ "\n");
            writer.write("=========================================");
            writer.close();

    }



}
