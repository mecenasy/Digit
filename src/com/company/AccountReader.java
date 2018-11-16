package com.company;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static java.nio.file.Files.readAllLines;

public class AccountReader {
    private Path pathFile;
    private List<String> readFile;
    private List<String[]> listAccounts = new ArrayList<>();

    public AccountReader(Path pathFile){
        this.pathFile = pathFile;
    }

    public AccountReader ReadFile(){
        try {
            this.readFile = readAllLines(pathFile);
        } catch (Exception e){
            System.out.println("nie udalo sie wczytać pliku");
        }
        return this;
    }

    public AccountReader IsolateAccounts (){
        for (int i =0 ; i < this.readFile.size()/4; i++) {
            this.listAccounts.add(
                    new String[]{
                            this.readFile.get(i * 4),
                            this.readFile.get((i * 4)+1),
                            this.readFile.get((i * 4)+2),
                    }
            );
        }
        return this;
    }

    public  List<String[]> GetAllAcounts(){
        return  this.listAccounts;
    }

    public boolean CheckAccountSumControl (int indexAccount){
        int sum = 0;
        String acount = new Digit().convertStringToAccountNumber(this.listAccounts.get(indexAccount));
        for (int i = 1; i <= acount.length(); i++){
            sum += i * Integer.parseInt(acount.substring(i-1, i));
        }
        return sum /11 == 0;
    }
}
