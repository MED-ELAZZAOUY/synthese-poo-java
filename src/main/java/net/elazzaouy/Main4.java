package net.elazzaouy;

import net.elazzaouy.business.BankAccountService;
import net.elazzaouy.business.BankAccountServiceImpl;
import net.elazzaouy.utils.DataTransformationUtils;

public class Main4 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandomData(10);
        bankAccountService.getAllAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);

    }
}
