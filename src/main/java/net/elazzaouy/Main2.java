package net.elazzaouy;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.elazzaouy.model.BankAccount;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("=============== tables =================");
        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new BankAccount(17000, "MAD");
        accounts[1] = new BankAccount(22000, "MAD");
        accounts[2] = new BankAccount(7000, "USA");
        accounts[3] = new BankAccount(1000, "USA");
        for (int i=0; i<accounts.length; i++){
            System.out.println(accounts[i].toString()); // account[i] == account[i].toString() (@Override)
        }
        System.out.println("===========================");

        System.out.println("============= Lists ==============");
        List<BankAccount> accountList = new ArrayList<>();
        accountList.add(new BankAccount(9000, "MAD"));
        accountList.add(new BankAccount(500, "USA"));
        for (BankAccount acc : accountList){
            System.out.println(acc);
        }
        System.out.println("=======================");

        System.out.println("============ Maps ==============");
        Map<String, BankAccount> accountMap = new HashMap<>();
        accountMap.put("acc1", new BankAccount(85000, "USA"));
        accountMap.put("acc2", new BankAccount(185000, "MAD"));
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
