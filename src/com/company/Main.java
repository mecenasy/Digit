package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {
        Digit digit = new Digit();
        String GetPath = new File("").getAbsolutePath() + "/src/Inputs/Inputfile.txt";
        Path file = Paths.get(GetPath);
        AccountReader reader = new AccountReader(file);
        System.out.println(reader.GetAllAccounts());

    }
}
