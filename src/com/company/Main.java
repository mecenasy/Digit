package com.company;

public class Main {

    public static void main(String[] args) {
        Digit digit = new Digit();

        String[] v0 = {" _ ", "| |", "|_|"};
        String[] v1 = {"   ", "  |", "  |",};
        String[] v2 = {" _ ", " _|", "|_ ",};
        String[] v3 = {" _ ", " _|", " _|",};
        String[] v4 = {"   ", "|_|", "  |",};
        String[] v5 = {" _ ", "|_ ", " _|",};
        String[] v6 = {" _ ", "|_ ", "|_|",};
        String[] v7 = {" _ ", "  |", "  |",};
        String[] v8 = {" _ ", "|_|", "|_|",};
        String[] v9 = {" _ ", "|_|", " _|",};

        System.out.println(digit.convert(v0));
        System.out.println(digit.convert(v1));
        System.out.println(digit.convert(v2));
        System.out.println(digit.convert(v3));
        System.out.println(digit.convert(v4));
        System.out.println(digit.convert(v5));
        System.out.println(digit.convert(v6));
        System.out.println(digit.convert(v7));
        System.out.println(digit.convert(v8));
        System.out.println(digit.convert(v9));
    }
}
