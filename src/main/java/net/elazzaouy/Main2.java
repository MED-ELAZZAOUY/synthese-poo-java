package net.elazzaouy;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.elazzaouy.model.BankAccount;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.elazzaouy.model.CurrentAccount;
import net.elazzaouy.model.SavingAccount;

public class Main2 {
    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("=============== tables =================");
        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new CurrentAccount("MAD",17000, 400);
        accounts[1] = new CurrentAccount("MAD", 22000, 500);
        accounts[2] = new SavingAccount(7000, "USA",  1.5);
        accounts[3] = new SavingAccount(1000, "USA",  5.5);
        for (int i=0; i<accounts.length; i++){
            System.out.println(accounts[i].toString()); // account[i] == account[i].toString() (@Override)
        }
        System.out.println("===========================");

        System.out.println("============= Lists ==============");
        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(new CurrentAccount("MAD", 9000, 555));
        accountList.add(new SavingAccount(500, "USA", 49.2));
        accountList.add(new CurrentAccount("MAD", 16000, 90));
        accountList.add(new SavingAccount(2009, "USA", 2.2));
        for (BankAccount acc : accountList){
            /* ==> Ce code représente le travail effectué par la JVM
                   pour déterminer la méthode qui va être appelée "POLYMORPHISME".
               ==> Car le compilateur ne peut pas détecter quelle méthode va être appelée.
            if(acc instanceof CurrentAccount){
                System.out.println(((CurrentAccount)acc).getType());
            }else
                if (acc instanceof SavingAccount){
                    System.out.println(((SavingAccount)acc).getType());
                }
            */ 
            System.out.println(acc.getType()); // polymorphisme
        }
        System.out.println("=======================");

        System.out.println("============ Maps ==============");
        Map<String, BankAccount> accountMap = new HashMap<>();
        accountMap.put("acc1", new CurrentAccount("MAD", 12000, 700));
        accountMap.put("acc2", new SavingAccount(185000, "MAD", 5));
        System.out.println("-->Keys : ");
        for (String key : accountMap.keySet()){
            System.out.println(key);
        }
        System.out.println("-->Values : ");
        for (BankAccount values : accountMap.values()){
            System.out.println(toJson(values)); // JSON format
        }




    }

    public static String toJson(Object obj) throws JsonProcessingException { // JavaScript Object Notation
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }
}
