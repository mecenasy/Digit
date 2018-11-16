package com.company;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class Main {

    public static void main(String[] args) {
        Digit digit = new Digit();
        Path file = Paths.get("C:\\bank.txt");
        AccountReader reader = new AccountReader(file);
        String [] d = reader.ReadFile().IsolateAccounts().GetAllAcounts().get(0);

        System.out.println(digit.convertStringToAccountNumber(d));
    }
}
