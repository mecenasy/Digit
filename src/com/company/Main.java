package com.company;

public class Main {

    public static void main(String[] args) {
	   Digit digit = new Digit();


         String pion = "|";
        String poziom = "_";
        String spacja = " ";

        String[][] v9 = {
                {spacja, poziom, spacja},
                {pion, poziom, pion},
                {spacja, poziom, pion}
        };

        System.out.println(digit.convert(v9));
    }
}
