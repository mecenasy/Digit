package com.company;
public class Digit {

    private String pion = "|";
    private String poziom = "_";
    private String spacja = " ";

    private String[][] v0 = {
            {spacja, poziom, spacja},
            {pion, spacja, pion},
            {pion, poziom, pion}
    };
    private String[][] v1 = {
            {spacja, spacja, spacja},
            {spacja, spacja, pion},
            {spacja, spacja, pion}
    };
    private String[][] v2 = {
            {spacja, poziom, spacja},
            {spacja, poziom, pion},
            {pion, poziom, pion}
    };
    private String[][] v3 = {
            {spacja, poziom, pion},
            {spacja, poziom, pion},
            {spacja, poziom, pion}
    };
    private String[][] v4 = {
            {spacja, spacja, spacja},
            {pion, poziom, pion},
            {spacja, spacja, pion}
    };
    private String[][] v5 = {
            {spacja, poziom, spacja},
            {pion, poziom, spacja},
            {spacja, poziom, pion}
    };
    private String[][] v6 = {
            {spacja, poziom, spacja},
            {pion, poziom, spacja},
            {pion, poziom, pion}
    };
    private String[][] v7 = {
            {spacja, poziom, spacja},
            {spacja, spacja, pion},
            {spacja, spacja, pion}
    };
    private String[][] v9 = {
            {spacja, poziom, spacja},
            {pion, poziom, pion},
            {spacja, poziom, pion}
    };
    private String[][] v8 = {
            {spacja, poziom, spacja},
            {pion, poziom, pion},
            {pion, poziom, pion}
    };
    private String[][][] digits = {v0, v1, v2, v3, v4, v5, v6, v7, v8, v9};

    public int convert(String[][] digit) {
        if (digit.length != 3 && digit[0].length != 3) {
            return -1;
        }
        for (int v = 0; v < digits.length; v++) {
            boolean tonietacyfra = false;
            for (int i = 0; i < 3; i++) {
                if (tonietacyfra) {
                    break;
                }
                for (int j = 0; j < 3; j++) {
                    if (digit[i][j].equals(digits[v][i][j])) {
                    } else {
                        tonietacyfra = true;
                        break;
                    }
                }
            }
            if (tonietacyfra) {
                continue;
            }
            return v;
        }
        return 1;
    }
}



