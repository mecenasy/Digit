package com.company;


/*
 *
 *  First user story to be solved
 *  User Story 1 - Solved :)
 *
 *
 */

class Digit {

    private String w0 = " _ ";
    private String w1 = "   ";
    private String w2 = "  |";
    private String w3 = "| |";
    private String w4 = "|_|";
    private String w5 = " _|";
    private String w6 = "|_ ";


    //Convert input to account number as char array
    public char[] convertStringToAccountNumberCharArray(String[] Input){
        char[] Result = this.convertStringToAccountNumber(Input).toCharArray();
        return Result;
    }

    //Convert input to account number as int array
    public int convertStringToAccountNumberInt(String[] Input){
        int Result;
        String AccountNumber= this.convertStringToAccountNumber(Input);
        Result = Integer.parseInt(AccountNumber);
        return Result;
    }

    //Convert input to account Number as String
    public String convertStringToAccountNumber(String[] Input){
        String Result = "";
        for(int i = 0; i < 9;i++){
            Result += this.convertStringToNumber(Input,i);
        }
        return Result;
    }

    //Convert input to number by id. ID range 0-8
    public String convertStringToNumber(String[] Input, int Digit_Place){
        String Result;

        String[] Output = {Input[0].substring(Digit_Place*3,(Digit_Place*3)+3),
                Input[1].substring(Digit_Place*3,(Digit_Place*3)+3),
                Input[2].substring(Digit_Place*3,(Digit_Place*3)+3)};

        Result = this.convert(Output);
        return Result;
    }

    public String convert(String[] digit) {
        if (digit.length != 3) {
            return "?";
        }
        if (digit[0].equals(w1)) {
            if (digit[1].equals(w2)){
                if (digit[2].equals(w2))return "1";
                else return "?";
            } else if (digit[1].equals(w4)){
                if (digit[2].equals(w2))return "4";
                else return "?";
            }
        } else {
            if (digit[1].equals(w2)) {
                if (digit[2].equals(w2)) return "7";
                else return "?";
            } else if (digit[1].equals(w3)) {
                if (digit[2].equals(w4)) return "0";
                else return "?";
            } else if (digit[1].equals(w4)) {
                if (digit[2].equals(w4)) return "8";
                else if (digit[2].equals(w5)) return "9";
                else return "?";
            } else if (digit[1].equals(w5)) {
                if (digit[2].equals(w5)) return "3";
                else if (digit[2].equals(w6)) return "2";
                else return "?";
            } else if (digit[1].equals(w6)) {
                if (digit[2].equals(w5)) return "5";
                else if (digit[2].equals(w4)) return "6";
                else return "?";
            }
        }
        return "?";
    }

}
