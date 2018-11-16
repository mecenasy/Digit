package com.company;

import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        Digit digit = new Digit();
        Path file = Paths.get("C:\\bank1.txt");
        AccountReader reader = new AccountReader(file);
        System.out.println(reader.GetAllAccounts());

    }
}
